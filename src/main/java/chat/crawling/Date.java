package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;

import java.io.IOException;
import java.util.List;

public class Date {
    public static void main(String[] args) throws IOException {


        List<Menu> gamcoMenus = GamcoService.getGamcoMenus();
        for ( Menu gm : gamcoMenus )
            System.out.println( gm.toString() );

        System.out.println();

        List<Menu> dormitMenus = DormitService.getDormitMenus();
        for ( Menu dm : dormitMenus )
            System.out.println( dm.toString() );
    }
}
