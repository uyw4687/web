package survey;

import java.util.List;

public class Question {

	private String ask;
	private List<String> options;
	
	public Question(String ask, List<String> options) {
		this.ask = ask;
		this.options = options;
	}

	public String getAsk() {
		return ask;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isSelect() {
		return (options!=null) && !(options.isEmpty());
	}
}
