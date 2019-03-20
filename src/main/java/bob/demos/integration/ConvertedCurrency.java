package bob.demos.integration;

import java.util.Map;

public class ConvertedCurrency {
    private long amount;
    private String base;
    private String date;
    private Map<String, Long> rates;

    public ConvertedCurrency(long amount, String base, String date, Map<String, Long> rates) {
        this.amount = amount;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Long> getRates() {
        return rates;
    }

    public void setRates(Map<String, Long> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ConvertedCurrency{" +
                "amount=" + amount +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates='" + rates + '\'' +
                '}';
    }
}
