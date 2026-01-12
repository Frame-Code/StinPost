package Entities;

import Entities.Util.Util;
import ValueObjects.Category.CategoryId;
import ValueObjects.Category.CategoryName;
import ValueObjects.Post.PostId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Category {
    private final CategoryId categoryId;
    private final CategoryName categoryName;
    private final List<Post> postList= new ArrayList<>();


    public void addPost(Post post){
        Util.add(postList,post,"No se puede agregar un post nulo");
    }

    public void removePost(PostId postId){
        Util.remove(postList, postId, "No se puede eliminar un post nulo", () ->
                postList.stream()
                        .filter(p -> p.getPostId().equals(postId))
                        .findFirst()
                        .orElse(null));

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoryId);
    }
}
