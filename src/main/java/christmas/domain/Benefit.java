package christmas.domain;

public class Benefit {
    private final String title;
    private final int price;

    public Benefit(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public boolean isEqualTitle(String title) {
        return this.title.equals(title);
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
