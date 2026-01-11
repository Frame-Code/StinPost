package entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users extends Person{

    @NotEmpty
    @Size(min = 4, max = 16)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 16)
    private String password;


    @Size(min = 1 , max = 255)
    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;




    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private Boolean active = true;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
