package bob.demos.Repository;

import bob.demos.domain.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
