package bob.demos.controller;

import bob.demos.Repository.ProductPackageRepository;
import bob.demos.Repository.ProductRepository;
import bob.demos.model.Product;
import bob.demos.model.ProductPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(value = "Product and Package Management System", description = "Operations to configure packages of products")
public class ProductPackageController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductPackageRepository productPackageRepository;

    @ApiOperation(value = "View a list of available employees", response = List.class, produces = "application/json")
    @GetMapping("/packages")
    public List<ProductPackage> getAllPackages() {
        return productPackageRepository.findAll();
    }

    @ApiOperation(value = "returns a listvpf all available products", response = List.class, produces = "application/json")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}

