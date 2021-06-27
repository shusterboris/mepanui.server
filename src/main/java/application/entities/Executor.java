package application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "executor")
public class Executor extends BasicEntity implements Serializable {
	private CatItem services; // many to many
	private String name;
	private String phone;
	private Integer raiting;
	private Address address;
}
