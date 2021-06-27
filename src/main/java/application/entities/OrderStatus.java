package application.entities;

public enum OrderStatus {
	NEW, IN_PROCESS, DONE, CANCELED_BY_OWNER, CANCELED_BY_EX;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

}
