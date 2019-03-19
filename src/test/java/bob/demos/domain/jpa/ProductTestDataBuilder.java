package bob.demos.domain.jpa;

public final class ProductTestDataBuilder {
    private String id = "TestId1";
    private String desc = "TestDesc1";
    private Integer usdPrice = 1000;

    private ProductTestDataBuilder() {
    }

    public static ProductTestDataBuilder aProduct() {
        return new ProductTestDataBuilder();
    }

    public ProductTestDataBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ProductTestDataBuilder withDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public ProductTestDataBuilder withUsdPrice(Integer usdPrice) {
        this.usdPrice = usdPrice;
        return this;
    }

    public Product build() {
        return new Product(id, desc, usdPrice);
    }
}
