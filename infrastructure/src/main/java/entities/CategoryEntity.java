package entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la categoria no puede estar vacío")
    @Size(max=50, message = "El nombre de la categoria no puede exceder los 50 caracteres")
    @Column(unique = true, nullable = false)
    private String name;

    @Size(max=200, message = "La descripción no puede exceder 200 caracteres")
    private String description;

    @OneToMany (mappedBy = "category")
    private List<PostEntity> posts;

}
