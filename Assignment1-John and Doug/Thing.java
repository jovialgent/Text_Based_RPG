import java.util.Random;

public class Thing {
	private int hitpoints;
	
	public Thing() {
		this.hitpoints = 100;
	}
	
	public Thing(int inhp) {
		this.hitpoints = inhp;
	}
	
	public int getHP() {
		return this.hitpoints;
	}
	
	public void setHP(int inhp) {
		this.hitpoints = inhp;
	}
	
	public boolean isDead() {
		return (this.hitpoints <= 0);
	}
	
	public boolean dealDamage(int dam) {
		this.hitpoints -= dam;
		return this.isDead();
	}
	
	public boolean dealRandomDamage(int lower, int upper) { // uniform distribution damage
		if (upper < lower) 
			return false;
		if (upper == lower) {
			this.hitpoints -= lower;
			return this.isDead();
		}
		this.hitpoints -= new Random().nextInt(upper-lower) + lower;
		return this.isDead();
	}
	
	public void heal(int healing) {
		if (!this.isDead())
			this.hitpoints += healing;
	}
}
