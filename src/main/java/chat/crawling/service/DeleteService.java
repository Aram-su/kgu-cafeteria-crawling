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

    //@Scheduled(fixedDelay = 10000)
    //매주 월~금 오전 09시 29분 45초에 테이블의 데이터를 지움
    @Scheduled(cron="45 29 9 ? * MON-FRI")
    public void deleteMenus(){
        menuRepository.deleteAll();
    }
}
