package application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends BasicEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6082577018428498519L;
	private String name;
	private String phone;
	private Integer rating;

}
