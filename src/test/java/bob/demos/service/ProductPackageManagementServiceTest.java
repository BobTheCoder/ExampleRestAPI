package bob.demos.service;

import bob.demos.Repository.ProductPackageRepository;
import bob.demos.domain.ProductPackagePrice;
import bob.demos.domain.jpa.ProductPackage;
import bob.demos.domain.jpa.ProductPackageTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ProductPackageManagementServiceTest {

    private static final ProductPackage TEST_PACKAGE_1 = ProductPackageTestDataBuilder.aProductPackage().build();
    private static final ProductPackage TEST_PACKAGE_2 = ProductPackageTestDataBuilder
            .aProductPackage()
            .withId("Id2")
            .withName("Name2")
            .withDesc("Desc2")
            .withProductList(Collections.emptyList())
            .build();

    @Mock
    ProductPackageRepository productPackageRepository;
    @InjectMocks
    private ProductPackageManagementService underTest = new ProductPackageManagementService();

    @Test
    public void findAllPackages() {
        List<ProductPackage> mockPackageList = Arrays.asList(TEST_PACKAGE_1, TEST_PACKAGE_2);

        Mockito.when(productPackageRepository.findAll()).thenReturn(mockPackageList);

        List<ProductPackagePrice> returnedPackages = underTest.findAllPackages();

        assertTrue("Wrong number of packages returned", returnedPackages.size() == 2);

        ProductPackagePrice productPackagePrice1 = returnedPackages.get(0);
        assertEquals("Package1 is wrong", TEST_PACKAGE_1, productPackagePrice1.getProductPackage());
        assertEquals("Currency should be USD", "USD", productPackagePrice1.getCurrencyCode());
        assertEquals("Wrong price", 1000, productPackagePrice1.getPrice());

        ProductPackagePrice productPackagePrice2 = returnedPackages.get(1);
        assertEquals("Package1 is wrong", TEST_PACKAGE_2, productPackagePrice2.getProductPackage());
        assertEquals("Currency should be USD", "USD", productPackagePrice2.getCurrencyCode());
        assertEquals("Wrong price", 0, productPackagePrice2.getPrice());
    }
}