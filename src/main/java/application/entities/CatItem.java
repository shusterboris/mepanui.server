package application.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author innai справочик всего. содержит категории заказов, опции заказов, и
 *         прочее
 */
@Getter
@Setter
@Entity
@Table(name = "catitem")
public class CatItem extends BasicEntity implements Serializable {
	private static final long serialVersionUID = 9189138282757350232L;
	@Column(name = "`key`", nullable = false, length = 20)
	private String key;
	private long parentKey;
	@Column(name = "`addInfo`", nullable = false, length = 100)
	private String addInfo;
	private String valueRu;
	private String valueHe;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "catitem")

	private Set<Executor> executors = new HashSet<>(); // many to many

}
