package Entities;

import ValueObjects.Comment.CommentContent;
import ValueObjects.Comment.CommentId;

import java.util.Objects;

public class Comment {
    private final CommentId commentId;
    private CommentContent commentContent;
    private final Post post;
    private final User user;

    private Comment(CommentId commentId, CommentContent commentContent, Post post, User user) {
        if(commentId == null) throw new IllegalArgumentException("El id del comentario no puede ser nulo");
        if(commentContent == null) throw new IllegalArgumentException("El contenido del comentario no puede ser nulo");
        if(post == null) throw new IllegalArgumentException("El post del comentario no puede ser nulo");
        if(user == null) throw new IllegalArgumentException("El usuario del comentario no puede ser nulo");

        this.commentId = commentId;
        this.commentContent = commentContent;
        this.post = post;
        this.user = user;
    }

    public void editContent(CommentContent commentContent) {
        if(commentContent == null)
            throw new IllegalArgumentException("El contenido del comentario no puede ser nulo");
        this.commentContent = commentContent;
    }

    public static Comment create(CommentId commentId, CommentContent commentContent, Post post, User user) {
        return new Comment(commentId, commentContent, post, user);
    }

    public static Comment restore(CommentId commentId, CommentContent commentContent, Post post, User user) {
        return new Comment(commentId, commentContent, post, user);
    }

    public CommentId getCommentId() {
        return commentId;
    }

    public CommentContent getCommentContent() {
        return commentContent;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentId);
    }
}
