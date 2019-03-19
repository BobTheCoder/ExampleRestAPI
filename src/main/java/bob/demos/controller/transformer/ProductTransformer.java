package bob.demos.controller.transformer;

import bob.demos.controller.ProductDTO;
import bob.demos.domain.jpa.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class ProductTransformer {
    private ProductTransformer() {
    }

    public static Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getDesc(), productDTO.getUsdPrice());
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getDesc(), product.getUsdPrice());
    }

    public static List<ProductDTO> toProductDTOCollection(Collection<Product> products) {
        return products.stream().map(ProductTransformer::toProductDTO).collect(Collectors.toList());
    }
}
