package chat.crawling;

import chat.crawling.menu.Menu;
import chat.crawling.service.DormitService;
import chat.crawling.service.GamcoService;

import java.io.IOException;
import java.util.List;

public class Date {
    public static void main(String[] args) throws IOException {


        List<Menu> gamcoMenus = GamcoService.getGamcoMenus();
        for ( Menu gm : gamcoMenus ){
//            System.out.println( gm.getDay() );
//            System.out.println( gm.getPrice() );
//            System.out.println( gm.getMenu01()+" "+gm.getMenu02()+" "+gm.getMenu03()+"\n"
//                    +gm.getMenu04()+" "+gm.getMenu05()+" "+gm.getMenu06());
//            System.out.println("----------");
            System.out.println( gm.toString() );
        }

        System.out.println();

        List<Menu> dormitMenus = DormitService.getDormitMenus();
        for ( Menu dm : dormitMenus ){
//            System.out.println( dm.getDay() );
//            System.out.println( dm.getPrice() );
//            System.out.println( dm.getLunchOrDinner() );
//            System.out.println( dm.getMenu01()+" "+dm.getMenu02()+" "+dm.getMenu03()+"\n"
//                    +dm.getMenu04()+" "+dm.getMenu05()+" "+dm.getMenu06());
//            System.out.println("----------");
            System.out.println( dm.toString() );
        }
    }
}
