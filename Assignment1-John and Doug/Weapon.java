
public class Weapon extends Item {
	private String name;
	private int damage;
	
	public Weapon() {
		this.damage = 10;
	}
	
	public Weapon(int indam) {
		this.damage = indam;
	}
	
	public Weapon(int indam, String inn, String intype, int inhp) {
		this.damage = indam;
		this.name = inn;
		this.setType(intype);
		this.setHP(inhp);
	}

	public void dealDamageTo(Thing target) {
		target.dealDamage(damage);
	}
	
	public String getTitle() {
		return this.getTitle();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int indam) {
		this.damage = indam;
	}
}
