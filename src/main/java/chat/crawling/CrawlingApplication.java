package chat.crawling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(CrawlingApplication.class, args);

	}
}
