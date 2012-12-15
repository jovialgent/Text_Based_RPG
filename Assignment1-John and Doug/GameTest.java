public class GameTest
{
	public static void main(String[] args)
	{
		Player player = new Player("Bob");
		
		// Add some stats and items to the player
	   player.addQuickItem("Potion");
		player.addStat("Health", 0, 10, 5);
		
		Stat health = player.findStat("Health");
		
		Item potion = player.findItem("Potion");
		
		// Search and print results
		System.out.println("min value is: " + health.getMin() + 
					"\nmax value is: " + health.getMax());
					
		System.out.println("\n\nItem is: " + potion.getType());
					
	}
}