package application.proxies;

public class CatProxy {
	private Long id;
	private String name;
	private String addInfo;

	public Long getId() {
		return id;
	}

	public CatProxy(Long id) {
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


	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}


}
