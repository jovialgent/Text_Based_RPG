
public class Item extends Thing {
	private String type = "I don't know";
	private int IDNum = 0; // for value comparison
	
	public Item() {
		this.setHP(10);
	}
	
	public Item(String intitle) {
		this.type = intitle;
		this.setHP(10);
	}
	
	public Item(String intype, int inhp) {
		this.type = intype;
		this.setHP(inhp);
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String intype) {
		this.type = intype;
	}
}
