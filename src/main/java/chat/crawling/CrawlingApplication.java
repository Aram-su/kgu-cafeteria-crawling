package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.repository.MemoryMenuRepository;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) throws IOException {

		MemoryMenuRepository memoryMenuRepository = new MemoryMenuRepository();
		GamcoService gamcoService = new GamcoService(memoryMenuRepository);
		DormitService dormitService = new DormitService(memoryMenuRepository);

		SpringApplication.run(CrawlingApplication.class, args);
		List<Menu> gamcoMenus = gamcoService.getGamcoMenus();
		List<Menu> dormitMenus = dormitService.getDormitMenus();

		System.out.println( gamcoMenus );
		System.out.println( dormitMenus );
	}
}
