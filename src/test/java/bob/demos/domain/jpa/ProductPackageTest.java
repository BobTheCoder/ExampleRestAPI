package bob.demos.domain.jpa;

import bob.demos.controller.transformer.ParentTransformerTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ProductPackageTest extends ParentTransformerTest {

    @Test
    public void testNoProductsGives0Price() {
        ProductPackage productPackage = new ProductPackage("A", "B", "C", Collections.emptyList());

        assertEquals("Package price should be 0", 0, productPackage.getPriceUSD());
    }

    @Test
    public void testSummedPriceOfTwoProducts() {
        Product product1 = ProductTestDataBuilder.aProduct().withUsdPrice(1000).build();
        Product product2 = ProductTestDataBuilder.aProduct().withUsdPrice(2000).build();

        ProductPackage productPackage = new ProductPackage("A", "B", "C", Arrays.asList(product1, product2));

        assertEquals("Package price should be 3000", 3000, productPackage.getPriceUSD());
    }
}