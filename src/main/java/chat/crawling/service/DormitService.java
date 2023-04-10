package chat.crawling.service;

import chat.crawling.menu.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DormitService {

    private final static int year = LocalDate.now().getYear();
    private final static int month = LocalDate.now().getMonthValue();
    private final static int day = LocalDate.now().getDayOfMonth();
    private final static String gamcoURL = "https://dorm.kyonggi.ac.kr:446/Khostel/mall_main.php?viewform=B0001_foodboard_list" +
            "&gyear="+year+"&gmonth="+month+"&gday="+day;
    private final static String dormitPrice = "4,500원";


    public static List<Menu> getDormitMenus() throws IOException {
        List<Menu> menus = new ArrayList<>();

        Document doc = Jsoup.connect(gamcoURL).get();
        Elements contents = doc.select("tbody tbody tbody tbody tbody tr");

        for ( int i = 4 ; i <= 8 ; i++){
            Element content = contents.get(i);

            Menu lunch = new Menu();
            Menu dinner = new Menu();

            lunch.setCafeteria("기숙사식당");
            dinner.setCafeteria("기숙사식당");

            lunch.setDate( content.select("a").text().substring(0,10) );
            dinner.setDate( content.select("a").text().substring(0,10) );

            lunch.setDay( content.select("a").text().substring(11) );
            dinner.setDay( content.select("a").text().substring(11) );

            lunch.setPrice(dormitPrice);
            dinner.setPrice(dormitPrice);

            lunch.setLunchOrDinner( "점심" );
            dinner.setLunchOrDinner( "저녁" );

            String[] temp = content.select("td:nth-child(3)").text().split(" ");
            lunch.setMenu01( temp[0].trim() );
            lunch.setMenu02( temp[1].trim() );
            lunch.setMenu03( temp[2].trim() );
            lunch.setMenu04( temp[3].trim() );
            lunch.setMenu05( temp[4].trim() );
            lunch.setMenu06( temp[5].trim() );

            temp = content.select("td:nth-child(4)").text().split(" ");
            dinner.setMenu01( temp[0].trim() );
            dinner.setMenu02( temp[1].trim() );
            dinner.setMenu03( temp[2].trim() );
            dinner.setMenu04( temp[3].trim() );
            dinner.setMenu05( temp[4].trim() );
            dinner.setMenu06( temp[5].trim() );

            menus.add(lunch);
            menus.add(dinner);
        }

        return menus;
    }
}
