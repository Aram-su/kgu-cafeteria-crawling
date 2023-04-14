package chat.crawling;

import chat.crawling.repository.MemoryMenuRepository;
import chat.crawling.repository.MenuRepository;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrawlingConfig {



    @Bean
    public MenuRepository menuRepository(){
        return new MemoryMenuRepository();
    }
}
