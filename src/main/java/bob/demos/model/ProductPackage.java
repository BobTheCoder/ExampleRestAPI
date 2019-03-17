package bob.demos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product_package")
public class ProductPackage {

    @Id
    private final int id;
    private final String desc;
    private final String name;
    @OneToMany
    private final List<Product> productList;
    private Integer pricePence;

    public ProductPackage(int id, String desc, String name, List<Product> productList) {
        this.id = id;
        this.desc = desc;
        this.name = name;
        this.productList = productList;

        this.pricePence = productList.stream().map(Product::getUsdPrice).mapToInt(Integer::intValue).sum();
    }

    public int getId() {
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

    public void setPricePence(Integer pricePence) {
        this.pricePence = pricePence;
    }

    public Integer getPricePence() {
        return pricePence;
    }

//    public addProduct(Product ) {

//    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                ", pricePence=" + pricePence +
                '}';
    }
}
