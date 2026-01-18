package Persistence.mappers;

import Entities.Post;
import Persistence.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "postId.id", target = "id")
    @Mapping(source = "postTitle.title", target = "title")
    @Mapping(source = "postContent.content", target = "content")
    @Mapping(source = "summary.summary", target = "summary")
    @Mapping(source = "userId.id", target = "author.id")
    @Mapping(source = "state", target = "status")
    PostEntity toEntity(Post post);
}
