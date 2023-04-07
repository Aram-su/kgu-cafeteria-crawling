package chat.crawling.service;

import chat.crawling.menu.GamcoMenu;
import chat.crawling.menu.Menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GamcoService {
    private final static String gamcoURL = "http://www.kyonggi.ac.kr/webRestMenu.kgu?mzcode=K00M04038500&restGb=suwon";

    public static List<Menu> getGamcoMenus() throws IOException {
        List<Menu> menus = new ArrayList<>();

        Document doc = Jsoup.connect(gamcoURL).get();
        Elements contents = doc.select(".text_center tr");

        for (Element content : contents ){
            Menu menu = new Menu();

            menu.setCafeteria("감성코어");

            String dateAndDay = content.select("th").text();

            int year = LocalDate.now().getYear();
            String month = dateAndDay.substring(0, 2);
            String day = dateAndDay.substring(3, 5);

            String date = year+"-"+month+"-"+day;
            
            DayOfWeek dayOfWeek = LocalDate.of( year, Integer.parseInt(month), Integer.parseInt(day) ).getDayOfWeek();
            String dayOfWeekKorean = dayOfWeek.getDisplayName(TextStyle.SHORT,Locale.KOREAN);
            
            //날짜 설정 ex) 2023-04-07
            menu.setDate( date );
            //요일 설정 ex) (금)
            menu.setDay( "("+dayOfWeekKorean+")" );
            //가격 설정 ex) 5,500원
            menu.setPrice( content.select("td").first().text().substring(3) );
            menu.setLunchOrDinner("점심");

            String[] temp = content.select("td:last-child").text().split("\\|");

            menu.setMenu01( temp[0] );
            menu.setMenu02( temp[1] );
            menu.setMenu03( temp[2] );
            menu.setMenu04( temp[3] );
            menu.setMenu05( temp[4] );
            menu.setMenu06( temp[5] );

            menus.add( menu );
        }
        return menus;
    }
}
