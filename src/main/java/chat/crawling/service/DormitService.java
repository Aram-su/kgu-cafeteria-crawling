package chat.crawling.service;

import chat.crawling.menu.Menu;
import chat.crawling.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class DormitService {

    private final int year = LocalDate.now().getYear();
    private final int month = LocalDate.now().getMonthValue();
    private final int day = LocalDate.now().getDayOfMonth();
    private final String gamcoURL = "https://dorm.kyonggi.ac.kr:446/Khostel/mall_main.php?viewform=B0001_foodboard_list" +
            "&gyear="+year+"&gmonth="+month+"&gday="+day;
    private final String dormitPrice = "4,500원";

    private final MenuRepository menuRepository;

    public DormitService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //@Scheduled(fixedDelay = 10000)
    //매주 월~금 오전 09시 30분 에 테이블에 기숙사식당의 메뉴 정보를 저장함
    @Scheduled(cron="0 30 9 ? * MON-FRI")
    public List<Menu> getDormitMenus() throws IOException {
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

            lunch.setLunch_or_dinner( "점심" );
            dinner.setLunch_or_dinner( "저녁" );

            String[] temp = content.select("td:nth-child(3)").text().split(" ");

            lunch.setMenu01( "없음" );
            lunch.setMenu02( "없음" );
            lunch.setMenu03( "없음" );
            lunch.setMenu04( "없음" );
            lunch.setMenu05( "없음" );
            lunch.setMenu06( "없음" );

            if ( temp.length > 6 ){
                for ( int j = 6 ; j < temp.length ; j++){
                    temp[5] = temp[5] + "/" +temp[j];
                }
            }
            if ( temp.length >= 6 ){
                lunch.setMenu01( temp[0].trim() );
                lunch.setMenu02( temp[1].trim() );
                lunch.setMenu03( temp[2].trim() );
                lunch.setMenu04( temp[3].trim() );
                lunch.setMenu05( temp[4].trim() );
                lunch.setMenu06( temp[5].trim() );
            } else if (temp.length == 5 ){
                lunch.setMenu01( temp[0].trim() );
                lunch.setMenu02( temp[1].trim() );
                lunch.setMenu03( temp[2].trim() );
                lunch.setMenu04( temp[3].trim() );
                lunch.setMenu05( temp[4].trim() );
            } else if (temp.length == 4 ){
                lunch.setMenu01( temp[0].trim() );
                lunch.setMenu02( temp[1].trim() );
                lunch.setMenu03( temp[2].trim() );
                lunch.setMenu04( temp[3].trim() );
            } else if (temp.length == 3 ){
                lunch.setMenu01( temp[0].trim() );
                lunch.setMenu02( temp[1].trim() );
                lunch.setMenu03( temp[2].trim() );
            } else if (temp.length == 2 ){
                lunch.setMenu01( temp[0].trim() );
                lunch.setMenu02( temp[1].trim() );
            } else if (temp.length == 1 ){
                lunch.setMenu01( temp[0].trim() );
            }

            temp = content.select("td:nth-child(4)").text().split(" ");
            dinner.setMenu01( "없음" );
            dinner.setMenu02( "없음" );
            dinner.setMenu03( "없음" );
            dinner.setMenu04( "없음" );
            dinner.setMenu05( "없음" );
            dinner.setMenu06( "없음" );

            if ( temp.length > 6 ){
                for ( int j = 6 ; j < temp.length ; j++){
                    temp[5] = temp[5] + "/" +temp[j];
                }
            }
            if ( temp.length >= 6 ){
                dinner.setMenu01( temp[0].trim() );
                dinner.setMenu02( temp[1].trim() );
                dinner.setMenu03( temp[2].trim() );
                dinner.setMenu04( temp[3].trim() );
                dinner.setMenu05( temp[4].trim() );
                dinner.setMenu06( temp[5].trim() );
            } else if (temp.length == 5 ){
                dinner.setMenu01( temp[0].trim() );
                dinner.setMenu02( temp[1].trim() );
                dinner.setMenu03( temp[2].trim() );
                dinner.setMenu04( temp[3].trim() );
                dinner.setMenu05( temp[4].trim() );
            } else if (temp.length == 4 ){
                dinner.setMenu01( temp[0].trim() );
                dinner.setMenu02( temp[1].trim() );
                dinner.setMenu03( temp[2].trim() );
                dinner.setMenu04( temp[3].trim() );
            } else if (temp.length == 3 ){
                dinner.setMenu01( temp[0].trim() );
                dinner.setMenu02( temp[1].trim() );
                dinner.setMenu03( temp[2].trim() );
            } else if (temp.length == 2 ){
                dinner.setMenu01( temp[0].trim() );
                dinner.setMenu02( temp[1].trim() );
            } else if (temp.length == 1 ){
                dinner.setMenu01( temp[0].trim() );
            }

            menus.add(lunch);
            menus.add(dinner);

            menuRepository.save(lunch);
            menuRepository.save(dinner);
        }
        System.out.println(menus);
        return menus;
    }
}
