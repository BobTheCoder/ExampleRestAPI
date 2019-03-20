package bob.demos.service;

import bob.demos.Repository.ProductPackageRepository;
import bob.demos.Repository.ProductRepository;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.Product;
import bob.demos.domain.jpa.ProductPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductPackageManagementService {
    public static final String DEFAULT_CURRENCY_CODE = "USD";
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductPackageManagementService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductPackageRepository productPackageRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductPackagePrice> findAllPackages() {
        List<ProductPackage> allDBPackages = productPackageRepository.findAll();

        LOGGER.info("Found {} product packages from DB", allDBPackages.size());

        List<ProductPackagePrice> packagesWithPrices = allDBPackages
                .stream()
                .map(pp -> new ProductPackagePrice(pp, pp.getPriceUSD(), DEFAULT_CURRENCY_CODE))
                .collect(Collectors.toList());

        return packagesWithPrices;
    }

    public Optional<ProductPackage> findPackageWithCurrency(String packageId, Optional<String> currencyCode) {
        return null;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateProductPackage(ProductPackage productPackage) throws EntityNotFoundException {
        productPackageRepository.save(productPackage);
    }
}
