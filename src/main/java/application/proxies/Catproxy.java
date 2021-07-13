package application.proxies;

public class Catproxy {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public Catproxy(Long id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
