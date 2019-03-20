package bob.demos.controller.transformer;

import bob.demos.controller.PriceDTO;
import bob.demos.controller.ProductPackageDTO;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.ProductPackage;

import java.util.stream.Collectors;

public class ProductPackageTransformer {
    private ProductPackageTransformer() {
    }

    public static ProductPackageDTO toProductPackageDTO(ProductPackagePrice productPackagePrice) {

        ProductPackage productPackage = productPackagePrice.getProductPackage();
        return new ProductPackageDTO(productPackage.getId(),
                productPackage.getDesc(),
                productPackage.getName(),
                productPackage.getProductList().stream().map(ProductTransformer::toProductDTO).collect(Collectors.toList()),
                new PriceDTO(productPackagePrice.getCurrencyCode(), productPackagePrice.getPrice()));
    }

    public static ProductPackage toPackageProduct(ProductPackageDTO productPackageDTO) {
        return new ProductPackage(productPackageDTO.getId(),
                productPackageDTO.getDesc(),
                productPackageDTO.getName(),
                ProductTransformer.toProductCollection(productPackageDTO.getProductList()));
    }
}
