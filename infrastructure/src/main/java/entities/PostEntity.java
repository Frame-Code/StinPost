package entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roles.StatePost;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotBlank(message = "El titulo del post no puede estar vacío")
    @Size(min = 2, max = 200, message = "El post debe tener entre 2 y 200 caracteres")
    @Column(name = "title", nullable = false, length = 200)
    private String title;


    @NotBlank(message = "El contenido del post no puede estar vacío")
    @Lob
    @Column( nullable = false, columnDefinition = "TEXT")
    private String content;


    @Size(max= 300 , message = "El resumen no puede superar los 300 caracteres")
    private String summary;


    @NotBlank(message = "El estado del post es obligatorio")
    @Enumerated(EnumType.STRING)
    private StatePost status;

    @NotNull(message = "El post debe tener un autor")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  UsersEntity author;

    @NotNull(message = "El post debe tener una categoria")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @ManyToMany
    @JoinTable(
            name="post_tags",
            joinColumns = @JoinColumn (name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

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
