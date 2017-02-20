package evolution;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AnyRepository extends MongoRepository<AnyEntity, String> {
	public AnyEntity findOneByName(String name);
	
	@Query("{gender : ?0}")
	public List<AnyEntity> findListByGender(String gender);
}
