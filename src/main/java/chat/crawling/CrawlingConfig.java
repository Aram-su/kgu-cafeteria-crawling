package chat.crawling;

import chat.crawling.repository.MenuRepository;
import chat.crawling.service.DeleteService;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrawlingConfig {

    private final MenuRepository menuRepository;

    @Autowired
    public CrawlingConfig(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Bean
    public GamcoService gamcoService(){
        return new GamcoService(menuRepository);
    }

    @Bean
    public DormitService dormitService(){
        return new DormitService(menuRepository);
    }

    @Bean
    public DeleteService deleteService() {
        return new DeleteService(menuRepository);
    }
}
