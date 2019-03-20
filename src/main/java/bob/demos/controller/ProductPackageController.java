package bob.demos.controller;

import bob.demos.controller.transformer.ProductPackageTransformer;
import bob.demos.controller.transformer.ProductTransformer;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.Product;
import bob.demos.domain.jpa.ProductPackage;
import bob.demos.service.ProductPackageManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@Api(value = "Product and Package Management System", description = "Operations to configure packages of products")
public class ProductPackageController {

    private final ProductPackageManagementService productPackageManagementService;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPackageController.class);

    public ProductPackageController(ProductPackageManagementService productPackageManagementService) {
        this.productPackageManagementService = productPackageManagementService;
    }

    @ApiOperation(value = "List of available packages of products", response = List.class, produces = "application/json")
    @GetMapping("/packages")
    public List<ProductPackageDTO> getAllPackages() {
        List<ProductPackagePrice> allPackages = productPackageManagementService.findAllPackages();

        LOGGER.info("Returning {} packages", allPackages.size());
        return allPackages.stream().map(ProductPackageTransformer::toProductPackageDTO).collect(Collectors.toList());
    }

    @ApiOperation(value = "List a specific packages of products with price in a specified currency",
            response = List.class, produces = "application/json")
    @GetMapping("/packages/{packageId}/{currency}")
    public ProductPackageDTO getPackage(@PathVariable String packageId, @PathVariable Optional<String> currency) {
        Optional<ProductPackagePrice> optionalPackage = productPackageManagementService.findPackageWithCurrency(packageId, currency);
        // throws NoSuchElementException
        if (optionalPackage.isPresent()) {
            return ProductPackageTransformer.toProductPackageDTO(optionalPackage.get());
        }
        return null;
    }

    @ApiOperation(value = "Adds a new ProductPackage or modifies an existing one")
    @PutMapping("/packages")
    public void updateProductPackage(@RequestBody ProductPackageDTO productPackageDTO) {
        ProductPackage productPackage = ProductPackageTransformer.toPackageProduct(productPackageDTO);
        LOGGER.info("Saving package={} to DB", productPackage);
        productPackageManagementService.updateProductPackage(productPackage);
    }

    @ApiOperation(value = "Deletes an existing ProductPackage")
    @DeleteMapping("/packages/{packageId}")
    public void deleteProductPackage(@PathVariable String packageId) {
        LOGGER.info("Received request to delete packageId={}", packageId);
        productPackageManagementService.deletePackage(packageId);
    }

    @ApiOperation(value = "Returns a list of all available products", response = List.class, produces = "application/json")
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productPackageManagementService.getAllProducts();
        LOGGER.info("Returning list of products={}", products);
        return ProductTransformer.toProductDTOCollection(products);
    }
}

