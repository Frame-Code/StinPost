package Entities;

import ValueObjects.Post.PostContent;
import ValueObjects.Post.PostId;
import ValueObjects.Post.PostSummary;
import ValueObjects.Post.PostTitle;
import lombok.Getter;

@Getter
public class Post {
    private PostId postId;
    private PostTitle postTitle;
    private PostContent postContent;
    private PostSummary summary;

}
