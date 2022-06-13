package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Product;

/**Now we can use JpaRepository’s methods: 
 * save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… 
 * without implementing these methods. **/
public interface ProductRepository extends JpaRepository<Product, Long> {
	  List<Product> findByDescriptionContaining(String description);
}
