package Entities;

import Enums.StatePost;
import ValueObjects.Category.CategoryId;
import ValueObjects.Comment.CommentId;
import ValueObjects.Post.PostContent;
import ValueObjects.Post.PostId;
import ValueObjects.Post.PostSummary;
import ValueObjects.Post.PostTitle;
import ValueObjects.Reaction.ReactionId;
import ValueObjects.Tag.TagId;
import ValueObjects.User.UserId;
import exceptions.DomainException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Post {
    private final PostId postId;
    private final PostTitle postTitle;
    private final PostContent postContent;
    private final PostSummary summary;
    private final UserId userId;
    private StatePost state;
    private final List<Reaction> reactions;
    private final List<Category> categories;
    private final List<Tag> tags;
    private final List<Comment> comments;

    //Constructor básico
    private Post(PostId postId,
                PostTitle postTitle,
                PostContent postContent,
                PostSummary summary,
                UserId userId) {
        if(postId == null) throw new IllegalArgumentException("El id del post no puede ser nulo");
        if(postTitle == null) throw new IllegalArgumentException("El titulo del post no puede ser nulo");
        if(postContent == null) throw new IllegalArgumentException("El contenido del post no puede ser nulo");
        if(userId == null) throw new IllegalArgumentException("El id del usuario generador del post no puede ser nulo");

        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.summary = summary;
        this.userId = userId;
        this.state = StatePost.PENDING;

        this.reactions = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // Constructor para reconstitución
    private Post(PostId postId,
                 PostTitle postTitle,
                 PostContent postContent,
                 PostSummary summary,
                 UserId userId,
                 StatePost state,
                 List<Reaction> reactions,
                 List<Comment> comments,
                 List<Tag> tags,
                 List<Category> categories) {
        if(postId == null) throw new IllegalArgumentException("El id del post no puede ser nulo");
        if(postTitle == null) throw new IllegalArgumentException("El titulo del post no puede ser nulo");
        if(postContent == null) throw new IllegalArgumentException("El contenido del post no puede ser nulo");
        if(userId == null) throw new IllegalArgumentException("El id del usuario generador del post no puede ser nulo");
        if(state == null) throw new IllegalArgumentException("El estado del post no puede ser nulo");

        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.summary = summary;
        this.userId = userId;
        this.state = state;
        this.reactions = reactions != null ? reactions : new ArrayList<>();
        this.categories = categories != null ? categories : new ArrayList<>();
        this.tags = tags != null ? tags : new ArrayList<>();
        this.comments = comments != null ? comments : new ArrayList<>();
    }

    public static Post create(PostId postId, PostTitle postTitle, PostContent postContent, PostSummary summary, UserId userId) {
        return new Post(postId, postTitle, postContent, summary, userId);
    }

    public static Post restore(PostId postId, PostTitle postTitle, PostContent postContent, PostSummary summary, UserId userId, StatePost state, List<Reaction> reactions, List<Comment> comments, List<Tag> tags, List<Category> categories) {
        return new Post(postId, postTitle, postContent, summary, userId, state, reactions, comments, tags, categories);
    }

    public void publishPost() {
        if(state == StatePost.PUBLISHED) {
            throw new DomainException("El post ya está publicado.");
        }
        this.state = StatePost.PUBLISHED;
    }

    public void addReaction(Reaction reaction) {
        if(reaction == null)
            throw new IllegalArgumentException("No se puede agregar una reacción nula");
        if(reactions.contains(reaction))
            throw new DomainException("El usuario ya ha reaccionado a este Post");
        reactions.add(reaction);

    }

    public void removeReaction(ReactionId reactionId) {
        reactions.removeIf(r -> r.getReactionId().equals(reactionId));
    }

    public void addTag(Tag tag) {
        if(tag == null)
            throw new IllegalArgumentException("No se puede agregar un tag nulo");
        if(tags.contains(tag))
            throw new DomainException("El tag ya existe");
        tags.add(tag);
    }

    public void removeTag(TagId tagId) {
        tags.removeIf(t -> t.getTagId().equals(tagId));
    }

    public void addCategory(Category category) {
        if(category == null)
            throw new IllegalArgumentException("No se puede agregar una categoría nula");
        if(categories.contains(category))
            throw new DomainException("Este post ya tiene dicha categoria");
        categories.add(category);
    }

    public void removeCategory(CategoryId categoryId) {
        categories.removeIf(c -> c.getCategoryId().equals(categoryId));
    }

    public void addComment(Comment comment) {
        if(comment == null)
            throw new IllegalArgumentException("No se puede agregar un comentario nulo");
        if(comments.contains(comment))
            throw new DomainException("El comentario ya existe");
        comments.add(comment);
    }

    public void removeComment(CommentId commentId) {
        comments.removeIf(c -> c.getCommentId().equals(commentId));
    }

    public List<Reaction> getReactions() {
        return Collections.unmodifiableList(reactions);
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public List<Tag> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public PostId getPostId() {
        return postId;
    }

    public PostTitle getPostTitle() {
        return postTitle;
    }

    public PostContent getPostContent() {
        return postContent;
    }

    public PostSummary getSummary() {
        return summary;
    }

    public UserId getUserId() {
        return userId;
    }

    public StatePost getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postId);
    }
}
