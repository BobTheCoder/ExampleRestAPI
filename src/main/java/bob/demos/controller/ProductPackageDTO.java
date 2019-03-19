package bob.demos.controller;

import java.util.List;

public class ProductPackageDTO {

    private final String id;
    private final String desc;
    private final String name;
    private final List<ProductDTO> productList;
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
