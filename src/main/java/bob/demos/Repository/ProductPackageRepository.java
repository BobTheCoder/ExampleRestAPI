package bob.demos.Repository;

import bob.demos.domain.jpa.ProductPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPackageRepository extends JpaRepository<ProductPackage, String> {
}
