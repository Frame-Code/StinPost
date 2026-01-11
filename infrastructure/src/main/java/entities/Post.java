package entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El titulo del post no puede estar vacío")
    @Size(min = 2, max = 200, message = "El post debe tener entre 2 y 200 caracteres")
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @NotBlank(message = "El contenido del post no puede estar vacío")
    @Size(min = 2, max = 500, message = "El contenido debe tener entre 2 y 500 caracteres")
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @OneToMany(
        mappedBy = "post",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<CommentEntity> comments;

    public void addComment(CommentEntity comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(CommentEntity comment) {
        comments.remove(comment);
        comment.setActive(false);
    }
}
