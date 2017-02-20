package evolution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AnyService {
	@Autowired
	AnyRepository anyRepository;
	
	MongoTemplate mongoTemplate;
	
	public AnyService() {
		
	}
	
	@Autowired
    public AnyService(MongoTemplate mongoTemplate) {// This constructor perfectly explains what inversion of control really is.
        this.mongoTemplate = mongoTemplate;
    }
	
	public void saveAndFindByMongoRepository() {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Cinderella");
		anyRepository.save(anyEntity);
		anyEntity = anyRepository.findOneByName("Cinderella");
		System.out.println(anyEntity);
		List<AnyEntity> anyEntities = anyRepository.findListByGender("F");
		System.out.println(anyEntities);
	}
	
	public void saveAndFindByMongoTemplate() {
		AnyEntity anyEntity = new AnyEntity();
		anyEntity.setName("Voldemort");
		mongoTemplate.save(anyEntity);
		anyEntity = mongoTemplate.findOne(new Query().addCriteria(new Criteria().and("name").is("Voldemort")), AnyEntity.class);
		System.out.println(anyEntity);
	}
}
