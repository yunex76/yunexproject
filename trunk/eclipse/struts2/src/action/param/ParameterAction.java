package action.param;

public class ParameterAction {

	private String message;
	private String name;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String execute() {	// controller ·ÎÁ÷
		System.out.println("message = " + this.message + " / name = " + this.name);
		return "success";
	}
}
