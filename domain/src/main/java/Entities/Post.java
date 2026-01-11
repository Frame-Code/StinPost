package Entities;

import Entities.Util.Util;
import Enums.StatePost;
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
        if(category == null)
            throw new IllegalArgumentException("No se puede agregar una categoría nula");
        categories.add(category);
    }

    public void removeCategory(Category category) {
        if (category == null)
            throw new IllegalArgumentException("No se puede eliminar una categoría nula");
        categories.remove(category);
    }

    public void addComment(Comment comment) {
        if(comment == null)
            throw new IllegalArgumentException("No se puede agregar un comentario nulo");
        comments.add(comment);
    }

    public void removeComment(Comment category) {
        if (category == null)
            throw new IllegalArgumentException("No se puede eliminar una categoría nula");
        categories.remove(category);

    }


}
