package bob.demos.controller.transformer;

import bob.demos.controller.ProductPackageDTO;
import bob.demos.domain.jpa.ProductPackage;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ProductPackageTransformerTest extends ParentTransformerTest {

//    private static final List<ProductDTO> TEST_PRODUCTDTO_LIST = Arrays.asList(TEST_PRODUCT_DTO, TEST_PRODUCT_DTO2);

    //    private static final ProductPackageDTO TEST_PACKAGE_DTO_LIST = new ProductPackageDTO(PACKAGE_ID, PACKAGE_DESC, PACKAGE_NAME, TEST_PRODUCTDTO_LIST);
    private static final ProductPackage TEST_PACKAGE = new ProductPackage(PACKAGE_ID, PACKAGE_DESC, PACKAGE_NAME, TEST_PRODUCT_LIST);

    @Test
    public void toProductPackageDTO() {
        ProductPackageDTO productPackageDTO = ProductPackageTransformer.toProductPackageDTO(TEST_PACKAGE);

        assertEquals("Wrong value for Id", PACKAGE_ID, productPackageDTO.getId());
        assertEquals("Wrong value for name", PACKAGE_NAME, productPackageDTO.getName());
        assertEquals("Wrong value for desc", PACKAGE_DESC, productPackageDTO.getDesc());

        assertCorrectProductDTOs(productPackageDTO.getProductList());
    }
}