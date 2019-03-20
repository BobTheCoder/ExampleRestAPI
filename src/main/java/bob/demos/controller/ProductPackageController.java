package bob.demos.controller;

import bob.demos.controller.transformer.ProductPackageTransformer;
import bob.demos.controller.transformer.ProductTransformer;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.Product;
import bob.demos.domain.jpa.ProductPackage;
import bob.demos.service.ProductPackageManagementService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@RestController
@RequestMapping("/v1")
@Api(value = "Product and Package Management System", description = "Operations to configure packages of products")
public class ProductPackageController {

    private final ProductPackageManagementService productPackageManagementService;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPackageController.class);

    public ProductPackageController(ProductPackageManagementService productPackageManagementService) {
        this.productPackageManagementService = productPackageManagementService;
    }

    @ApiOperation(value = "List of available packages of products", response = ProductPackageDTO.class,
            responseContainer = "List", produces = "application/json")
    @GetMapping("/packages")
    public List<ProductPackageDTO> getAllPackages() {
        List<ProductPackagePrice> allPackages = productPackageManagementService.findAllPackages();

        LOGGER.info("Returning {} packages", allPackages.size());
        return allPackages.stream().map(ProductPackageTransformer::toProductPackageDTO).collect(Collectors.toList());
    }

    @ApiOperation(value = "List a specific package of products. The price will be returned in the requested currency " +
            "or if not supplied will default to USD",
            response = ProductPackageDTO.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK, message = "Success"),
            @ApiResponse(code = HTTP_NOT_FOUND, message = "Could not find product package")
    })
    @GetMapping("/packages/{packageId}/{currency}")
    public ProductPackageDTO getPackage(
            @ApiParam(required = true, name = "packageId")
            @PathVariable String packageId,
            @ApiParam(name = "currency",
                    required = false,
                    value = "Optional parameter - the 3 letter ISO currency code you would like the package price returned with",
                    allowEmptyValue = true)
            @PathVariable Optional<String> currency) throws ProductPackageNotFoundRestException {
        Optional<ProductPackagePrice> optionalPackage = productPackageManagementService.findPackageWithCurrency(packageId, currency);

        if (optionalPackage.isPresent()) {
            return ProductPackageTransformer.toProductPackageDTO(optionalPackage.get());
        }

        LOGGER.error("Product packageId={} can't be found", packageId);
        throw new ProductPackageNotFoundRestException("Product package can't be found");
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

    @ApiOperation(value = "Returns a list of all available products", response = ProductDTO.class, responseContainer = "List", produces = "application/json")
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productPackageManagementService.getAllProducts();
        LOGGER.info("Returning list of products={}", products);
        return ProductTransformer.toProductDTOCollection(products);
    }
}

