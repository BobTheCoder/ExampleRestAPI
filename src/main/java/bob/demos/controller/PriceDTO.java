package bob.demos.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Price object, currency and amount")
public class PriceDTO {

    @ApiModelProperty(notes = "Currency - 3 character ISO format")
    private final String currency;
    @ApiModelProperty(notes = "Price - value of the sum of the products in a package - in specified currency")
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
