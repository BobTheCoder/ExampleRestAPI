package bob.demos.controller.transformer;

import bob.demos.controller.ProductDTO;
import bob.demos.controller.ProductPackageDTO;
import bob.demos.domain.jpa.Product;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ParentTransformerTest {

    protected static final String TEST_PRODUCT_ID = "abC123";
    protected static final String TEST_PROD_DESC = "A new test product";
    protected static final long TEST_USD_PRICE_CENTS = 123;

    protected static final Product TEST_PRODUCT = new Product(TEST_PRODUCT_ID, TEST_PROD_DESC, TEST_USD_PRICE_CENTS);
    protected static final ProductDTO TEST_PRODUCT_DTO = new ProductDTO(TEST_PRODUCT_ID, TEST_PROD_DESC, TEST_USD_PRICE_CENTS);

    protected static final String TEST_PRODUCT_ID2 = "Xyz987";
    protected static final String TEST_PROD_DESC2 = "A 2 product";
    protected static final long TEST_USD_PRICE_CENTS2 = 456;

    protected static final Product TEST_PRODUCT2 = new Product(TEST_PRODUCT_ID2, TEST_PROD_DESC2, TEST_USD_PRICE_CENTS2);
    protected static final ProductDTO TEST_PRODUCT_DTO2 = new ProductDTO(TEST_PRODUCT_ID2, TEST_PROD_DESC2, TEST_USD_PRICE_CENTS2);
    protected static final List<Product> TEST_PRODUCT_LIST = Arrays.asList(TEST_PRODUCT, TEST_PRODUCT2);
    protected static final List<ProductDTO> TEST_PRODUCTDTO_LIST = Arrays.asList(TEST_PRODUCT_DTO, TEST_PRODUCT_DTO2);

    protected static final String PACKAGE_ID = "ZX23sds";
    protected static final String PACKAGE_DESC = "A test package containing products";
    protected static final String PACKAGE_NAME = "Test 1";

    protected static final ProductPackageDTO TEST_PACKAGE_DTO = new ProductPackageDTO(PACKAGE_ID, PACKAGE_DESC, PACKAGE_NAME, Arrays.asList(TEST_PRODUCT_DTO2), null);

    protected void assertCorrectProductDTOs(Collection<ProductDTO> productDTOS) {
        assertEquals("Wrong number of products returned", 2, productDTOS.size());
        assertTrue("Missing Product 1", productDTOS.contains(TEST_PRODUCT_DTO));
        assertTrue("Missing Product 2", productDTOS.contains(TEST_PRODUCT_DTO2));
    }

    protected void assertCorrectProducts(Collection<Product> products) {
        assertEquals("Wrong number of products returned", 2, products.size());
        assertTrue("Missing Product 1", products.contains(TEST_PRODUCT));
        assertTrue("Missing Product 2", products.contains(TEST_PRODUCT2));
    }
}
