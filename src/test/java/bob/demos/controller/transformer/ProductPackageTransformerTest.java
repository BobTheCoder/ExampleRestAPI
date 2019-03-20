package bob.demos.controller.transformer;

import bob.demos.controller.ProductPackageDTO;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.ProductPackage;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ProductPackageTransformerTest extends ParentTransformerTest {
    private static final ProductPackage TEST_PACKAGE = new ProductPackage(PACKAGE_ID, PACKAGE_DESC, PACKAGE_NAME, TEST_PRODUCT_LIST);
    public static final long TEST_PRICE = 1000;
    private static final ProductPackagePrice TEST_PPP = new ProductPackagePrice(TEST_PACKAGE, TEST_PRICE, "GBP");

    @Test
    public void toProductPackageDTO() {
        ProductPackageDTO productPackageDTO = ProductPackageTransformer.toProductPackageDTO(TEST_PPP);

        assertEquals("Wrong value for Id", PACKAGE_ID, productPackageDTO.getId());
        assertEquals("Wrong value for name", PACKAGE_NAME, productPackageDTO.getName());
        assertEquals("Wrong value for desc", PACKAGE_DESC, productPackageDTO.getDesc());

        assertCorrectProductDTOs(productPackageDTO.getProductList());
        assertEquals("Wrong price", TEST_PRICE, productPackageDTO.getPriceDTO().getPrice());
        assertEquals("Wrong currency", "GBP", productPackageDTO.getPriceDTO().getCurrency());
    }
}