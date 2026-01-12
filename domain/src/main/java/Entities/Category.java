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

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @EqualsAndHashCode.Include
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



}
