package bob.demos.domain.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_package")
public class ProductPackage {

    @Id
    private final String id;
    private final String desc;
    private final String name;
    @OneToMany(fetch = FetchType.EAGER)
    private final List<Product> productList;

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
