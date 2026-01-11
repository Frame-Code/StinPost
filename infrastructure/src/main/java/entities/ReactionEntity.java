package entities;


import Enums.TypeReaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reactions")
@Getter
@Setter
@NoArgsConstructor
public class ReactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeReaction reaction;

    @OneToOne
    @NotNull(message = "El user es obligatorio")
    @JoinColumn(nullable = false, name = "user_id")
    private UsersEntity user;

}
