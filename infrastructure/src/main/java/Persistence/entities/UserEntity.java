package Persistence.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Enums.Roles;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends PersonEntity {

    @NotEmpty
    @Size(min = 4, max = 16)
    @Column(nullable = false, length = 16)
    private String username;

    @NotEmpty
    @Size(min = 4, max = 72)
    @Column(nullable = false, length = 72)
    private String password;

    @Size(min = 1 , max = 255)
    private String bio;

    @NotNull(message = "El usuario debe tener un rol")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", unique = true,  nullable = false)
    private ImageEntity avatar;

}
