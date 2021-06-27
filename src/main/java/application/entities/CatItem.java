package application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
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
@Table(name = "catitems")
public class CatItem extends BasicEntity implements Serializable {
	private String key;
	private String parentKey;
	private String addInfo;
	private Executor executor; // many to many
}
