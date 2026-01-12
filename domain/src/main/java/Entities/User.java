package Entities;

import Entities.Util.Util;
import Enums.Roles;
import ValueObjects.Post.PostId;
import ValueObjects.User.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class User {

    private final UserId userId;
    private final UserDni dni;
    private final UserName firstName;
    private final UserName lastName;
    private final UserEmail email;
    private final UserPhone phone;
    private final UserBirthDate birthDate;
    private final UserUsername username;
    private final UserPassword password;
    private final UserBio bio;
    private final Roles role;
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        Util.add(posts,post,"No se puede añadir un post nulo");
    }

    public void removePost(PostId postId){
        Util.remove(posts,postId,"No se puede eliminar un post nulo", () ->
                posts.stream().
                        filter(p ->p.getPostId().equals(postId)).
                        findFirst().
                        orElse(null));
    }

    public String getFullName() {
        return firstName.value() + " " + lastName.value();
    }
}
