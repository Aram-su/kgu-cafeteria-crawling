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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Transactional
public class GamcoService {
    private final String gamcoURL = "http://www.kyonggi.ac.kr/webRestMenu.kgu?mzcode=K00M04038500&restGb=suwon";

    private final MenuRepository menuRepository;

    public GamcoService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //@Scheduled(fixedDelay = 10000)
    //매주 월~금 오전 09시 30분 에 테이블에 감성코어의 메뉴 정보를 저장함
    @Scheduled(cron="0 30 9 ? * MON-FRI")
    public List<Menu> getGamcoMenus() throws IOException {
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
            menu.setLunch_or_dinner("점심");

            String[] temp = content.select("td:last-child").text().split("\\|");

            menu.setMenu01( "없음" );
            menu.setMenu02( "없음" );
            menu.setMenu03( "없음" );
            menu.setMenu04( "없음" );
            menu.setMenu05( "없음" );
            menu.setMenu06( "없음" );

            if ( temp.length > 6 ){
                for ( int i = 6 ; i < temp.length ; i++){
                    temp[5] = temp[5] + "/" +temp[i];
                }
            }
            if ( temp.length >= 6 ){
                menu.setMenu01( temp[0].trim() );
                menu.setMenu02( temp[1].trim() );
                menu.setMenu03( temp[2].trim() );
                menu.setMenu04( temp[3].trim() );
                menu.setMenu05( temp[4].trim() );
                menu.setMenu06( temp[5].trim() );
            } else if (temp.length == 5 ){
                menu.setMenu01( temp[0].trim() );
                menu.setMenu02( temp[1].trim() );
                menu.setMenu03( temp[2].trim() );
                menu.setMenu04( temp[3].trim() );
                menu.setMenu05( temp[4].trim() );
            } else if (temp.length == 4 ){
                menu.setMenu01( temp[0].trim() );
                menu.setMenu02( temp[1].trim() );
                menu.setMenu03( temp[2].trim() );
                menu.setMenu04( temp[3].trim() );
            } else if (temp.length == 3 ){
                menu.setMenu01( temp[0].trim() );
                menu.setMenu02( temp[1].trim() );
                menu.setMenu03( temp[2].trim() );
            } else if (temp.length == 2 ){
                menu.setMenu01( temp[0].trim() );
                menu.setMenu02( temp[1].trim() );
            } else if (temp.length == 1 ){
                menu.setMenu01( temp[0].trim() );
            }

            menus.add( menu );
            menuRepository.save( menu );
        }
        System.out.println(menus);
        return menus;
    }
}
