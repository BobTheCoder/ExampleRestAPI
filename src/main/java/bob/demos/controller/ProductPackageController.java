package bob.demos.controller;

import bob.demos.controller.transformer.ProductTransformer;
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

@RestController
@RequestMapping("/v1")
@Api(value = "Product and Package Management System", description = "Operations to configure packages of products")
public class ProductPackageController {

    private final ProductPackageManagementService productPackageManagementService;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPackageController.class);

    public ProductPackageController(ProductPackageManagementService productPackageManagementService) {
        this.productPackageManagementService = productPackageManagementService;
    }

    @ApiOperation(value = "View a list of available employees", response = List.class, produces = "application/json")
    @GetMapping("/packages")
    public List<ProductPackageDTO> getAllPackages() {
//        List<ProductPackage> allPackages = productPackageManagementService.findAllPackages();
        return null;
    }

    @ApiOperation(value = "View a list of available employees", response = List.class, produces = "application/json")
    @GetMapping({"/packages/{packageId}", "/packages/{packageId}/{currency}"})
    public ProductPackageDTO getPackage(@PathVariable String packageId, @PathVariable Optional<String> currency) {
        Optional<ProductPackage> optionalPackage = productPackageManagementService.findPackageWithCurrency(packageId, "USD");
        // throws NoSuchElementException
        return null;
    }

    @ApiOperation(value = "Adds a new ProductPackage or modifies an existing one")
    @PutMapping("/packages")
    public void updateProductPackage(@RequestBody ProductPackageDTO productPackageDTO) {

    }

    @ApiOperation(value = "Adds a new ProductPackage")
    @PostMapping("/packages")
    public void addProductPackage(@RequestBody ProductPackageDTO productPackageDTO) {

    }

    @ApiOperation(value = "Deletes an existing ProductPackage")
    @DeleteMapping("/packages/{packageId}")
    public void deleteProductPackage(@RequestBody String packageId) {

    }

    @ApiOperation(value = "Returns a list of all available products", response = List.class, produces = "application/json")
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productPackageManagementService.getAllProducts();
        LOGGER.info("Returning list of products={}", products);
        return ProductTransformer.toProductDTOCollection(products);
    }
}

