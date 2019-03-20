package bob.demos.controller.transformer;

import bob.demos.controller.ProductDTO;
import bob.demos.domain.jpa.Product;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ProductTransformerTest extends ParentTransformerTest {

    @Test
    public void toProduct() {
        Product product = ProductTransformer.toProduct(TEST_PRODUCT_DTO);

        assertEquals("Wrong ID returned", TEST_PRODUCT_ID, product.getId());
        assertEquals("Wrong description returned", TEST_PROD_DESC, product.getDesc());
        assertEquals("Wrong price returned", TEST_USD_PRICE_CENTS, product.getUsdPrice());
    }

    @Test
    public void testToCollectionOfProduct() {
        Collection<Product> products = ProductTransformer.toProductCollection(TEST_PRODUCTDTO_LIST);

        assertCorrectProducts(products);
    }

    @Test
    public void toDto() {
        ProductDTO productDTO = ProductTransformer.toProductDTO(TEST_PRODUCT);

        assertEquals("Wrong ID returned", TEST_PRODUCT_ID, productDTO.getId());
        assertEquals("Wrong description returned", TEST_PROD_DESC, productDTO.getDesc());
        assertEquals("Wrong price returned", TEST_USD_PRICE_CENTS, productDTO.getUsdPrice());
    }

    @Test
    public void testToCollectionOfDTO() {
        Collection<ProductDTO> productDTOS = ProductTransformer.toProductDTOCollection(TEST_PRODUCT_LIST);

        assertCorrectProductDTOs(productDTOS);
    }
}