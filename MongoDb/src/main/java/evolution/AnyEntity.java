package evolution;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "any_entity")
public class AnyEntity {
	@Id
	private String id;// Don't forget to provide an ID property, otherwise it will throw out an mapping exception.
	private String name;
	private String gender;
}
