package bob.demos.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "Product object, describes the attributes of a product")
public class ProductDTO {
    @ApiModelProperty(notes = "Unique identifier for a product")
    private final String id;
    @ApiModelProperty(notes = "Description of the product")
    private final String desc;
    @ApiModelProperty(notes = "Price in USD")
    private final long usdPrice;

    public ProductDTO(String id, String desc, long usdPrice) {
        this.id = id;
        this.desc = desc;
        this.usdPrice = usdPrice;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public long getUsdPrice() {
        return usdPrice;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", usdPrice=" + usdPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(usdPrice, that.usdPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, usdPrice);
    }
}
