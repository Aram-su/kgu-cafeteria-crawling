package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CrawlingApplication.class, args);
		List<Menu> gamcoMenus = GamcoService.getGamcoMenus();
		List<Menu> dormitMenus = DormitService.getDormitMenus();
		System.out.println( gamcoMenus );
		System.out.println( dormitMenus );
	}
}
