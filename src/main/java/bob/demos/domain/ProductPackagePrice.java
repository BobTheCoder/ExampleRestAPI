package bob.demos.domain;

import bob.demos.domain.jpa.ProductPackage;

import java.util.Objects;

public class ProductPackagePrice {
    private final ProductPackage productPackage;
    private final long price;
    private final String currencyCode;

    public ProductPackagePrice(ProductPackage productPackage, long price, String currencyCode) {
        this.productPackage = productPackage;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public long getPrice() {
        return price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPackagePrice)) return false;
        ProductPackagePrice that = (ProductPackagePrice) o;
        return price == that.price &&
                Objects.equals(productPackage, that.productPackage) &&
                Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPackage, price, currencyCode);
    }

    @Override
    public String toString() {
        return "ProductPackagePrice{" +
                "productPackage=" + productPackage +
                ", price=" + price +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
