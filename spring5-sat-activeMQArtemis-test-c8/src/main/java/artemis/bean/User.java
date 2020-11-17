package artemis.bean;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE,force=true)
@RequiredArgsConstructor
public class User implements Serializable{

	
	/**
	 * @Fields serialVersionUID : TODO(这个变量表示什么)
	 */
	private static final long serialVersionUID = -5000901759169632042L;

	private Long id;
	
	private final String username;
	private final String password;
	private final String fullname;
	private final String street;
	private final String city;
	private final String state;
	private final String zip;
	private final String phoneNumber;
	



}
