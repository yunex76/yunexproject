package examples.jms.queue;

public class Mail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 637426348732641L;
	
	private String mailId;
	private String country;
	private double weight;
	
	// --------------------------------

	public Mail() {
		
	}
	
	public Mail(String mailId, String country, double weight) {
		this.mailId = mailId;
		this.country = country;
		this.weight = weight;
	}
	// --------------------------------
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
