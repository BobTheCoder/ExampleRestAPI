package bob.demos.domain.jpa;

import java.util.Arrays;
import java.util.List;

public final class ProductPackageTestDataBuilder {
    private String id = "PackageId1";
    private String desc = "PackageDesc1";
    private String name = "PackageName1";
    private List<Product> productList = Arrays.asList(ProductTestDataBuilder.aProduct().build());

    private ProductPackageTestDataBuilder() {
    }

    public static ProductPackageTestDataBuilder aProductPackage() {
        return new ProductPackageTestDataBuilder();
    }

    public ProductPackageTestDataBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ProductPackageTestDataBuilder withDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public ProductPackageTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductPackageTestDataBuilder withProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public ProductPackage build() {
        return new ProductPackage(id, desc, name, productList);
    }
}
