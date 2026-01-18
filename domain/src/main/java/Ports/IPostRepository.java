package Ports;

import Entities.Post;
import ValueObjects.Post.PostId;

public interface IPostRepository {
    PostId GetLastId();
    Post Save(Post post);
}
