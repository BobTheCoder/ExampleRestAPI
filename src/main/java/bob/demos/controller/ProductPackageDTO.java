package bob.demos.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(description = "Package object, describes a package of products")
public class ProductPackageDTO {
    @ApiModelProperty(notes = "Unique identifier of a package")
    private final String id;
    @ApiModelProperty(notes = "Description of a package")
    private final String desc;
    @ApiModelProperty(notes = "Name of this package")
    private final String name;
    @ApiModelProperty(notes = "A list of products within this package")
    private final List<ProductDTO> productList;
    @ApiModelProperty(notes = "Price information - the sum of the value of the products in the package")
    private final PriceDTO priceDTO;

    public ProductPackageDTO(String id, String desc, String name, List<ProductDTO> productList, PriceDTO priceDTO) {
        this.id = id;
        this.desc = desc;
        this.name = name;
        this.productList = productList;
        this.priceDTO = priceDTO;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public PriceDTO getPriceDTO() {
        return priceDTO;
    }

    @Override
    public String toString() {
        return "ProductPackageDTO{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                ", priceDTO=" + priceDTO +
                '}';
    }
}
