package application.entities;

public enum AnswerState {
	NEW, APPRUVED;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}
}
