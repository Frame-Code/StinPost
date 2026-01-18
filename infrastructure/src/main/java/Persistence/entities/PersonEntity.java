package Persistence.entities;


import exceptions.DomainException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @NotBlank(message = "El numero de identificación es obligatorio")
    @Size(min = 2, max = 10, message = "La cedula debe tener 10 caracteres")
    @Column(name = "ci", nullable = false, length = 10)
    private String dni;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(nullable = false, length = 50, name = "lastname")
    private String lastName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe contener entre 8 y 15 dígitos")
    @Column(name = "cell_phone_number", nullable = false, length = 20)
    private String cellPhone;

    @NotBlank(message = "La fecha de nacimiento no puede estar vacía")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    public String getFullNames() {
        return name + " " + lastName;
    }

    public Integer getAge(){
        if (this.birthDate == null)  throw new DomainException("Error: Fecha de nacimiento no puede ser vacía");
        return Period.between(this.birthDate,LocalDate.now()).getYears();
    }
}
