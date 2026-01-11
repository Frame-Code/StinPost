package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends Person{

    @NotEmpty
    @Size(min = 4, max = 16)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 16)
    private String password;

    @Size(min = 1 , max = 255)
    private String bio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", unique = true,  nullable = false)
    private ImageEntity avatar;

}
