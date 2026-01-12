package Entities;

import Entities.Util.Util;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private final PostId postId;
    private final PostTitle postTitle;
    private final PostContent postContent;
    private final PostSummary summary;
    private final StatePost statePost;
    private final UserId userId;
    private final List<Reaction> reactions = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();
    private final List<Tag> tags = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public void addReaction(Reaction reaction) {
        Util.add(reactions, reaction, "No se puede agregar una reacción nula");
    }

    public void removeReaction(ReactionId reactionId) {
        Util.remove(reactions, reactionId, "No se puede eliminar una reacción nula", () ->
                reactions.stream()
                        .filter(r -> r.getReactionId().equals(reactionId))
                        .findFirst()
                        .orElse(null));
    }

    public void addTags(Tag tag) {
        Util.add(tags, tag, "No se puede agregar un tag nulo");
    }

    public void removeTags(TagId tag) {
        Util.remove(tags, tag, "No se puede eliminar un tag nulo", () ->
                tags.stream()
                        .filter(r -> r.getTagId().equals(tag))
                        .findFirst()
                        .orElse(null));
    }

    public void addCategory(Category category) {
        Util.add(categories,category,"No se puede agregar una categoría nula");
    }

    public void removeCategory(CategoryId categoryId) {
        Util.remove(categories, categoryId, "No se puede eliminar una categoria asociada a un post", () ->
                categories.stream()
                        .filter(c -> c.getCategoryId().equals(categoryId))
                        .findFirst()
                        .orElse(null));
    }

    public void addComment(Comment comment) {
      Util.add(comments,comment,"No se puede agregar un comentario nulo");
    }

    public void removeComment(CommentId commentId) {
        Util.remove(comments, commentId, "No se puede eliminar una comentario nulo , ¡pendejo!", () ->
                comments.stream()
                        .filter(c -> c.getCommentId().equals(commentId))
                        .findFirst()
                        .orElse(null));

    }


}
