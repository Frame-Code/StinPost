package services.usecase;

import Entities.Post;
import Ports.ICategoryRepository;
import Ports.IPostRepository;
import Ports.ITagRepository;
import Ports.IUserRepository;
import ValueObjects.Post.PostContent;
import ValueObjects.Post.PostId;
import ValueObjects.Post.PostSummary;
import ValueObjects.Post.PostTitle;
import ValueObjects.User.UserId;
import org.springframework.transaction.annotation.Transactional;
import services.Ports.CreatePostCommand;
import services.common.BaseResponse;

public class CreatePostService implements CreatePostCommand {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final ICategoryRepository categoryRepository;
    private final ITagRepository tagRepository;

    public CreatePostService(IPostRepository postRepository,
                             IUserRepository userRepository,
                             ICategoryRepository categoryRepository,
                             ITagRepository tagRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    @Override
    public BaseResponse<CreatePostResult> execute(CreatePostRequest request) {
        boolean existsIdCategories = categoryRepository.existsIds(request.categoriesId());
        boolean existsIdTags = tagRepository.existsIds(request.tagsId());
        boolean existsUser = userRepository.existsById(request.userId());

        if(!existsIdTags) {
            return new BaseResponse<>(false, "Un tag es invalido", null);
        }
        if(!existsIdCategories) {
            return new BaseResponse<>(false, "Una categoria es invalida", null);
        }
        if(!existsUser) {
            throw new RuntimeException("El usuario no fue encontrado");
        }

        PostId id = postRepository.GetLastId();
        PostTitle title = new PostTitle(request.title());
        PostContent content = new PostContent(request.content());
        PostSummary summary = new PostSummary(request.summary());
        UserId userId = new UserId(request.userId());

        Post post = Post.create(id, title, content, summary, userId);
        post.publishPost();
        Post postSaved = postRepository.Save(post);
        return new BaseResponse<>(true, "Post creado correctamente",
                new CreatePostResult(postSaved.getPostId().id(), postSaved.getPostTitle().title()));
    }
}
