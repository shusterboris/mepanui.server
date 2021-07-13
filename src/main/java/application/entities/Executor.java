package application.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "executor")
public class Executor extends Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2804393364419535123L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	@JoinTable(name = "service_ex", joinColumns = { @JoinColumn(name = "executor_id") }, inverseJoinColumns = {

			@JoinColumn(name = "catitem_id") })
	private Set<CatItem> catitem = new HashSet<>(); // many to many

	private String name;
	private String phone;
	private Integer rating;


}
