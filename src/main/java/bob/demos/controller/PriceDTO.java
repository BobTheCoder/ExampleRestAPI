package bob.demos.controller;

public class PriceDTO {

    private final String currency;
    private final long price;

    public PriceDTO(String currency, long price) {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }
}
