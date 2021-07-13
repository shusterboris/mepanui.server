package application.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Address extends BasicEntity {
	
	@Column(name = "`place`", nullable = true, length = 255)
	protected String place;
	
	protected Float latitude;
	protected Float altitude;


}
