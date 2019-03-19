package bob.demos.controller.transformer;

import bob.demos.controller.PriceDTO;
import bob.demos.controller.ProductPackageDTO;
import bob.demos.domain.jpa.ProductPackage;

import java.util.stream.Collectors;

public class ProductPackageTransformer {
    private ProductPackageTransformer() {
    }

    public static ProductPackageDTO toProductPackageDTO(ProductPackage productPackage) {

        return new ProductPackageDTO(productPackage.getId(),
                productPackage.getDesc(),
                productPackage.getName(),
                productPackage.getProductList().stream().map(ProductTransformer::toProductDTO).collect(Collectors.toList()),
                new PriceDTO("", 8));
    }
}
