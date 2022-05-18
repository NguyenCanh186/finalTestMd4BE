package canhnguyen.testmd4.repository;

import canhnguyen.testmd4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {
}
