package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.repository.MemoryMenuRepository;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;

import java.io.IOException;
import java.util.List;

public class Date {
    public static void main(String[] args) throws IOException {

        MemoryMenuRepository memoryMenuRepository = new MemoryMenuRepository();
        GamcoService gamcoService = new GamcoService(memoryMenuRepository);
        DormitService dormitService = new DormitService(memoryMenuRepository);

        gamcoService.getGamcoMenus();
        dormitService.getDormitMenus();

        System.out.println( memoryMenuRepository.findTodayGamco() );
        System.out.println( memoryMenuRepository.findTodayDormit() );

        System.out.println();
        System.out.println( memoryMenuRepository.findThisWeek() );

    }
}
