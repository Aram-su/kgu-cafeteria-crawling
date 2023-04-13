package chat.crawling.repository;

public class Key {

    private String cafeteria;
    private String date;
    private String lunchOrDinner;

    public Key(String cafeteria, String date, String lunchOrDinner) {
        this.cafeteria = cafeteria;
        this.date = date;
        this.lunchOrDinner = lunchOrDinner;
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

    public String getLunchOrDinner() {
        return lunchOrDinner;
    }

    public void setLunchOrDinner(String lunchOrDinner) {
        this.lunchOrDinner = lunchOrDinner;
    }
}
