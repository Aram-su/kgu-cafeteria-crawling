package chat.crawling.service;

import chat.crawling.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;

@Transactional
public class DeleteService {

    private final MenuRepository menuRepository;

    public DeleteService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Scheduled(cron="0 25 9 ? * MON-FRI")
    public void deleteMenus(){
        menuRepository.deleteAll();
    }
}
