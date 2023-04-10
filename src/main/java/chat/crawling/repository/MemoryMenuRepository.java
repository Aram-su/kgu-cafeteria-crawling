package chat.crawling.repository;

import chat.crawling.menu.Menu;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MemoryMenuRepository implements MenuRepository{

    private static Map<String, Menu> store = new HashMap<>();

    @Override
    public Menu save(Menu menu) {
        store.put(menu.getDate(), menu);
        return menu;
    }

    @Override
    public List<Menu> findToday() {
        return store.values().stream()
                .filter( menu -> menu.getDate().equals(LocalDate.now().toString()) )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Menu> findTodayGamco() {
        return store.values().stream()
                .filter( menu -> menu.getCafeteria().equals("감성코어") )
                .filter( menu -> menu.getDate().equals(LocalDate.now().toString()) )
                .findAny();
    }

    @Override
    public Optional<Menu> findTodayDormit() {
        return store.values().stream()
                .filter( menu -> menu.getCafeteria().equals("기숙사식당") )
                .filter( menu -> menu.getDate().equals(LocalDate.now().toString()) )
                .findAny();
    }

    @Override
    public List<Menu> findThisWeek() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Menu> findThisWeekGamco() {
        return store.values().stream()
                .filter( menu -> menu.getCafeteria().equals("감성코어") )
                .collect(Collectors.toList());
    }

    @Override
    public List<Menu> findThisWeekDormit() {
        return store.values().stream()
                .filter( menu -> menu.getCafeteria().equals("기숙사식당") )
                .collect(Collectors.toList());
    }
}
