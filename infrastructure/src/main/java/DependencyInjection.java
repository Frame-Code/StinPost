import Ports.ICategoryRepository;
import Ports.IPostRepository;
import Ports.ITagRepository;
import Ports.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.Ports.CreatePostCommand;
import services.usecase.CreatePostService;

@Configuration
public class DependencyInjection {

    @Bean
    public CreatePostCommand createPostCommand(IPostRepository postRepository, IUserRepository userRepository, ICategoryRepository categoryRepository, ITagRepository tagRepository) {
        return new CreatePostService(postRepository, userRepository, categoryRepository, tagRepository);
    }
}
