package bob.demos.domain.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String desc;
    private long usdPrice;

    public Product() {
    }

    public Product(String id, String desc, long usdPrice) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(desc, product.desc) &&
                Objects.equals(usdPrice, product.usdPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, usdPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", usdPrice=" + usdPrice +
                '}';
    }
}
