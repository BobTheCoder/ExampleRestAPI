package bob.demos.service;

import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.Product;
import bob.demos.domain.jpa.ProductPackage;
import bob.demos.integration.ConvertedCurrency;
import bob.demos.integration.CurrencyConversionClient;
import bob.demos.repository.ProductPackageRepository;
import bob.demos.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private CurrencyConversionClient currencyConversionClient;

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

    public Optional<ProductPackagePrice> findPackageWithCurrency(String packageId, Optional<String> currencyCode) {
        Optional<ProductPackage> optionalProd = productPackageRepository.findById(packageId);

        if (!optionalProd.isPresent()) return Optional.empty();

        ProductPackage productPackage = optionalProd.get();
        String currency;
        long price;

        if (currencyCode.isPresent()) {
            currency = currencyCode.get();
            ConvertedCurrency currencyConversion = currencyConversionClient.getCurrencyConversion(productPackage.getPriceUSD(),
                    DEFAULT_CURRENCY_CODE,
                    currency);

            Map<String, Long> rates = currencyConversion.getRates();
            price = rates.get(currency);
        } else {
            currency = DEFAULT_CURRENCY_CODE;
            price = productPackage.getPriceUSD();
        }

        return Optional.of(new ProductPackagePrice(productPackage, price, currency));
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateProductPackage(ProductPackage productPackage) throws EntityNotFoundException {
        productPackageRepository.save(productPackage);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deletePackage(String packageId) {
        List<ProductPackage> allDBPackages = productPackageRepository.findAll();

        productPackageRepository.deleteById(packageId);
    }
}
