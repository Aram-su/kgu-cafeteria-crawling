package chat.crawling.repository;



import chat.crawling.menu.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {

    Menu save(Menu menu);

    void deleteAll();
}
