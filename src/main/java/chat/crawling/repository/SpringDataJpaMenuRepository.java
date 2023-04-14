package chat.crawling.repository;

import chat.crawling.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringDataJpaMenuRepository extends JpaRepository<Menu, Long>, MenuRepository{


    @Override
    Menu save(Menu menu);
}
