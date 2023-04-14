package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.repository.MemoryMenuRepository;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(CrawlingApplication.class, args);

		MemoryMenuRepository memoryMenuRepository = new MemoryMenuRepository();
		GamcoService gamcoService = new GamcoService(memoryMenuRepository);
		DormitService dormitService = new DormitService(memoryMenuRepository);

	}
}
