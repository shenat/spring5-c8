package artemis.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Ingredient implements Serializable{
	
	/**
	 * @Fields serialVersionUID : TODO(这个变量表示什么)
	 */
	private static final long serialVersionUID = -1542224408223267309L;
	private String id;
	private String name;
	private Type type;
  
 	public static enum Type {
 		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
 	}

 	

 	
 	
  
  
}
