package artemis.bean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Taco implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(这个变量表示什么)
	 */
	private static final long serialVersionUID = -979152663883946697L;

	private Long id;
	
  private String name;
  
  private List<Ingredient> ingredients;
  
  private Date createdAt;
  
  void createdAt() {
	  this.createdAt = new Date();
  }
	
	

}
