package Persistence.adapter;

import Entities.*;
import Persistence.entities.PostEntity;
import Persistence.mappers.PostMapper;
import Persistence.spring.PostRepositoryJpa;
import Ports.IPostRepository;
import ValueObjects.Category.CategoryId;
import ValueObjects.Category.CategoryName;
import ValueObjects.Post.PostContent;
import ValueObjects.Post.PostId;
import ValueObjects.Post.PostSummary;
import ValueObjects.Post.PostTitle;
import ValueObjects.Reaction.ReactionId;
import ValueObjects.Tag.TagId;
import ValueObjects.Tag.TagName;
import ValueObjects.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostRepositoryImpl implements IPostRepository {
    private final PostRepositoryJpa postRepository;
    private final PostMapper postMapper;

    @Override
    public PostId GetLastId() {
        Long id = postRepository.findLastId();
        return new PostId(id);
    }

    @Override
    public Post Save(Post post) {
        PostEntity entity = postMapper.toEntity(post);
        PostEntity entitySaved = postRepository.save(entity);

        PostId id = new PostId(entitySaved.getId());
        PostTitle title = new PostTitle(entitySaved.getTitle());
        PostContent content = new PostContent(entitySaved.getContent());
        PostSummary summary = new PostSummary(entitySaved.getSummary());
        UserId userId = new UserId(entitySaved.getAuthor().getId());
        List<Reaction> reactions = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        List<Category> categories = entitySaved.getCategories()
                .stream()
                .map(c -> Category.create(new CategoryId(c.getId()), new CategoryName(c.getName())))
                .toList();
        List<Tag> tags = entitySaved.getTags()
                .stream()
                .map(t -> Tag.create(new TagId(t.getId()), new TagName(t.getName())))
                .toList();

        return Post.restore(id, title, content,
                summary, userId, entitySaved.getStatus(), reactions,
                comments, tags, categories);
    }

}
