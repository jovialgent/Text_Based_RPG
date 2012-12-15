import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
	Class: Player
	
	Descritpion: This class contains information for a player 
	in the game. So far a Player contains Stats and Items.
	
	@author Doug Walter & John Qualls 
	@version 1.0
	
	Date: December 2012
*/
public class Player extends Person {
	private String playername;
	private Map<String, Stat> stats;
	private Map<String, Item> items;
	
	/**
		This constructor assigns default values to the instance
		fields.
	*/
	public Player() 
	{
		this.playername = "Hiro Protagonist";
		this.stats = new HashMap<String, Stat>();
		this.items = new HashMap<String, Item>();
	}
	
	/**
		This constructor assigns a user specified name to the name
		instance field and assigns default values to the remaing 
		fields.
		@param inn The players new name.
	*/
	public Player(String name) 
	{
		this.setPlayerName(name);
		this.stats = new HashMap<String, Stat>();
		this.items = new HashMap<String, Item>();
	}
	
	/**
		This method gets the current Stat list
		@return stats All of the player's current stats.
	*/
	public Map<String, Stat> getStatList() 
	{
		return this.stats;
	}
	
	/**
		This method gets the current Item list
		@return items All of the player's items.
	*/
	public Map<String, Item> getItemList() 
	{
		return this.items;
	}
	
	/**
		This method adds a stat with a default size.
		@param name The name of the stat.
	*/
	public void addQuickStat(String name)
	{
		stats.put(name, new Stat());
	}
	
	/**
		This method adds a new stat to the player.
		@param name The name of the stat.
		@param min The stats minimum number.
		@param max The stats maximum number.
		@param current The stats current value.
	*/
	public void addStat(String name, int min, 
							  int max, int current)
	{
		stats.put(name, new Stat(min, max, current));
	}
	
	/**
		This method adds an item with a default hp.
		@param name The name of the item.
	*/
	public void addQuickItem(String name)
	{
		items.put(name, new Item(name));
	}
	
	/**
		This method adds a new Item to the player.
		@param name The name of the stat.
		@param hp The items health points.
	*/
	public void addItem(String name, int hp) 
	{
		items.put(name, new Item(name, hp));
	}
	
	/**
		This method removes a stat from the stat list.
		@param name The name of the stat to remove.
	*/
	public void removeStat(String name) 
	{
		stats.remove(name);
	}
	
	/**
		This method removes an item from the item list.
		@param name The name of the item to remove.
	*/
	public void removeItem(String name) 
	{
		items.remove(name);
	}
	
	/**
		This method searches for a specified stat.
		@param name The name of the stat to search for.
		@return The stat that is found.
	*/
	public Stat findStat(String name)
	{
		return stats.get(name);
	}
	
	/**
		This method searches for a specified item.
		@param name The name of the item to search for.
		@return The item that is found.
	*/
	public Item findItem(String name)
	{
		return items.get(name);
	}
	
	/**
		This method sets the players name.
		@param name The players new name.
	*/
	public void setPlayerName(String name) 
	{
		this.playername = name;
	}
	
	/**
	 This method gets the players name.
	 @return playername The player's current name.
	*/
	public String getPlayerName() 
	{
		return this.playername;
	}
}
