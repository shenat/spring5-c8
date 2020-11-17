package artemis.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Order implements Serializable{

	
	private static final long serialVersionUID = 5490215460530093505L;

	 private Long id;
	 
	 private String name;
	
	 private String street;
	
	 private String city;
	
	  private String state;
	
	  private String zip;
	
	  private String ccNumber;
	
	  private String ccExpiration;
	  
	  private String ccCVV;
	  
	  private Date placedAt;
	  
	  private List<Taco> tacos = new ArrayList<>();
	  
	  private User user;
	  
	  public void addDesign(Taco design) {
	    this.tacos.add(design);
	  }
	  
	  void placeAt() {
		  this.placedAt = new Date();
	  }


}