package bob.demos.Repository;

import bob.demos.model.ProductPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPackageRepository extends JpaRepository<ProductPackage, Long> {
}
