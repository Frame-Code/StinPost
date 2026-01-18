package Persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
public class ImageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "La url es obligatoria")
    @Size(max = 2000, message = "La url debe tener entre max 2000 caracteres")
    @Column(name = "url", length = 2000, nullable = false)
    private String url;

    @NotBlank(message = "El nombre del archivo es obligatorio")
    @Size(max = 500, message = "El nombre del archivo debe tener max 500 caracteres")
    @Column(name = "fileName", length = 500, nullable = false)
    private String fileName;

    @NotBlank(message = "La extension del archivo es obligatoria")
    @Size(max = 10, message = "La extension del archivo debe tener max 10 caracteres")
    @Column(name = "extensionFile", length = 10, nullable = false)
    private String extensionFile;

    @Size(max = 1000, message = "La descripción del archivo debe tener max 1000 caracteres")
    @Column(name = "description", length = 1000)
    private String description;

}
