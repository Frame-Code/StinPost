package services.Ports;

import ValueObjects.Category.CategoryId;
import ValueObjects.Tag.TagId;
import services.common.BaseResponse;

import java.util.List;

public interface CreatePostCommand {
    BaseResponse<CreatePostResult> execute(CreatePostRequest request);

    record CreatePostRequest(String title, String content, String summary, Long userId, List<CategoryId> categoriesId, List<TagId> tagsId){}
    record CreatePostResult(Long id, String title){};
}
