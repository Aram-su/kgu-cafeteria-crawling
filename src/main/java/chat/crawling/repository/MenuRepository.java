package chat.crawling.repository;



import chat.crawling.menu.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {

    Menu save(Menu menu);

    List<Menu> findToday();

    Optional<Menu> findTodayGamco();

    Optional<Menu> findTodayDormit();

    List<Menu> findThisWeek();

    List<Menu> findThisWeekGamco();

    List<Menu> findThisWeekDormit();
}
