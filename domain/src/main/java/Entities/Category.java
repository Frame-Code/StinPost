package Entities;

import ValueObjects.Category.CategoryId;
import ValueObjects.Category.CategoryName;
import ValueObjects.Post.PostId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Category {
    private final CategoryId categoryId;
    private final CategoryName categoryName;
    private final List<Post> posts;

    private Category(CategoryId categoryId, CategoryName categoryName) {
        if(categoryId == null) throw new IllegalArgumentException("El id de la categoria no puede ser nulo");
        if(categoryName == null) throw new IllegalArgumentException("El nombre de la categoria no puede ser nulo");

        this.categoryId = categoryId;
        this.categoryName = categoryName;

        this.posts = new ArrayList<>();
    }

    private Category(CategoryId categoryId, CategoryName categoryName, List<Post> posts) {
        if(categoryId == null) throw new IllegalArgumentException("El id de la categoria no puede ser nulo");
        if(categoryName == null) throw new IllegalArgumentException("El nombre de la categoria no puede ser nulo");

        this.categoryId = categoryId;
        this.categoryName = categoryName;

        this.posts = posts != null? posts : new ArrayList<>();
    }

    public static Category create(CategoryId categoryId, CategoryName categoryName) {
        return new Category(categoryId, categoryName);
    }

    public static Category restore(CategoryId categoryId, CategoryName categoryName, List<Post> posts){
        return new Category(categoryId, categoryName, posts);
    }


    public void addPost(Post post){
        if(post == null)
            throw new IllegalArgumentException("No se puede agregar un post nulo");
        if(posts.contains(post))
            throw new IllegalArgumentException("El post ya existe");
        posts.add(post);
    }

    public void removePost(PostId postId){
        posts.removeIf(p -> p.getPostId().equals(postId));
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public List<Post> getPosts() {
        return Collections.unmodifiableList(posts);
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
