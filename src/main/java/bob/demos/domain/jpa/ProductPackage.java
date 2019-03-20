package bob.demos.domain.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_package")
public class ProductPackage {

    @Id
    private String id;
    private String desc;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Product> productList;

    public ProductPackage() {
    }

    public ProductPackage(String id, String desc, String name, List<Product> productList) {
        this.id = id;
        this.desc = desc;
        this.name = name;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Method returns the sum of all the product prices in USD
     */
    public long getPriceUSD() {
        return productList.stream().map(Product::getUsdPrice).mapToInt(Long::intValue).sum();
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
