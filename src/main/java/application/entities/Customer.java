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
	private String name;
	private String phone;
	private Integer rating;

}
