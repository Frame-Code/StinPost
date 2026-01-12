package Entities;

import Entities.Util.Util;
import ValueObjects.Comment.CommentContent;
import ValueObjects.Comment.CommentId;
import ValueObjects.Post.PostId;
import ValueObjects.User.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Comment {

    private final CommentId commentId;
    private final CommentContent commentContent;
    private final List<Post> posts = new ArrayList<>();
    private final List<User> users = new ArrayList<>();


    public void addCommentToPost(Post post){
        Util.add(posts,post,"No se puede agregar un comentario a un post nulo");
    }

    public void addComment(User user){
        Util.add(users,user,"No se puede agregar un comentario sin un autor");
    }

    public void removeCommentToPost(PostId postId){
        Util.remove(posts, postId, "No se puede eliminar un comentario de un post nulo", () ->
                posts.stream()
                        .filter(p -> p.getPostId().equals(postId))
                        .findFirst().
                        orElse(null));
    }

    public void removeCommentByUser(UserId userId){
        Util.remove(users, userId, "No se puede eliminar un comentario sin autor", () ->
                users.stream()
                        .filter(u-> u.getUserId().equals(userId))
                        .findFirst().
                        orElse(null));

    }

}
