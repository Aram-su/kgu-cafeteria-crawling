package chat.crawling.menu;

public class Menu {

    private String cafeteria;
    private String date;
    private String day;
    private String price;
    private String lunchOrDinner;
    private String menu01;
    private String menu02;
    private String menu03;
    private String menu04;
    private String menu05;
    private String menu06;

    @Override
    public String toString() {
        return "Menu{" +
                "cafeteria='" + cafeteria + '\'' +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", price='" + price + '\'' +
                ", lunchOrDinner='" + lunchOrDinner + '\'' +
                ", menu01='" + menu01 + '\'' +
                ", menu02='" + menu02 + '\'' +
                ", menu03='" + menu03 + '\'' +
                ", menu04='" + menu04 + '\'' +
                ", menu05='" + menu05 + '\'' +
                ", menu06='" + menu06 + '\'' +
                '}';
    }

    public String getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(String cafeteria) {
        this.cafeteria = cafeteria;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLunchOrDinner() {
        return lunchOrDinner;
    }

    public void setLunchOrDinner(String lunchOrDinner) {
        this.lunchOrDinner = lunchOrDinner;
    }

    public String getMenu01() {
        return menu01;
    }

    public void setMenu01(String menu01) {
        this.menu01 = menu01;
    }

    public String getMenu02() {
        return menu02;
    }

    public void setMenu02(String menu02) {
        this.menu02 = menu02;
    }

    public String getMenu03() {
        return menu03;
    }

    public void setMenu03(String menu03) {
        this.menu03 = menu03;
    }

    public String getMenu04() {
        return menu04;
    }

    public void setMenu04(String menu04) {
        this.menu04 = menu04;
    }

    public String getMenu05() {
        return menu05;
    }

    public void setMenu05(String menu05) {
        this.menu05 = menu05;
    }

    public String getMenu06() {
        return menu06;
    }

    public void setMenu06(String menu06) {
        this.menu06 = menu06;
    }
}
