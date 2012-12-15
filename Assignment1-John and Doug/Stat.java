/**
	Class: Stat
	
	Description: This class contains information on a stat bar.
	
		Stat Bar: A bar that has a min value, max value, and
		current value. 

		Current Value: The current value can be added or 
		subtracted. For example a player takes damage, then
		the players health stat bar's current value is
		subtracted.

		Max/Min Value: The max and min values can also be
		adjusted similarly to the current value. This is 
		useful, for example, when the player levels up and 
		gains an increase in health.
		

		@aurthor Doug Walter & John Qualls
*/
public class Stat 
{
	private int currentValue;
	private int maxValue;
	private int minValue;
	
	/**
		This constructor assigns default values to the instance 
		variables.
	*/
	public Stat() 
	{
		this.currentValue = 100;
		this.maxValue = 100;
		this.minValue = 0;
	}
	
	/**
		This constructor will only make changes to the
		instance variables if the new min and max values 
		are in the correct order. If the values are not in 
		the correct order, the default values will be applied
		to the instance variables.
		@param min minimum value of stat bar.
		@param max maximum value of stat bar.
		@param current current value in stat bar.
	*/
	public Stat(int min, int max, int current) 
	{
		if (!(max <= min)) 
		{
			this.currentValue = current;
			this.maxValue = max;
			this.minValue = min;
		}
		else 
		{
			this.currentValue = 100;
			this.maxValue = 100;
			this.minValue = 0;
		}
	}
	
	/**
		This method adjusts the current value if it is 
		outside the range of the stat bar. Also 
	*/
	private void checkCurrent() 
	{
		if (this.currentValue <= this.minValue) 
			this.currentValue = this.minValue;
		if (this.currentValue >= this.maxValue)
			this.currentValue = this.maxValue;
	}
	
	/**
		This method subtracts the current value of the stat bar
		by a specific integer value that is passed through
		the parameters.
		@param thisMuch The value that wil be subtracted.
	*/
	public void minusCurrent(int thisMuch) 
	{
		this.currentValue -= thisMuch;
		this.checkCurrent();
	}
	
	/**
		This method adds to the current value of the stat bar
		by a specific integer value that is passed through the
		parameters.
		@param thisMuch The value that wil be added.
	*/
	public void addCurrent(int thisMuch) 
	{
		this.currentValue += thisMuch;
		this.checkCurrent();
	}
	
	/**
		This method subtracts the max value of the stat bar by
      a specific integer value that is passed thorugh the
		parameters only if the max value is greater than the
		min value.
		@param thisMuch The value that wil be subtracted.
	*/
	public void minusMax(int thisMuch)
	{
		if (this.maxValue > this.minValue) 
		{
			this.maxValue -= thisMuch;
		}
	}
	
	/**
		This method adds to the max value of the stat bar
		by a specific integer value that is passed thorugh the
		parameters.
		@param thisMuch The value that wil be added.
	*/
	public void addMax(int thisMuch)
	{
		this.maxValue += thisMuch;
	}
	
	/**
		This method adds to the min value of the stat bar by
      a specific integer value that is passed thorugh the
		parameters only if the min value is less than the
		max value.
		@param thisMuch The value that wil be added.
	*/
	public void addMin(int thisMuch)
	{
		if (this.maxValue > this.minValue) 
		{
			this.minValue += thisMuch;
		}
	}
	
	/**
		This method subtracts the min value of the stat bar
		by a specific integer value that is passed thorugh the
		parameters.
		@param thisMuch The value that wil be subtracted.
	*/
	public void minusMin(int thisMuch)
	{
		this.minValue -= thisMuch;
	}
	
	/**
		This method gets the current value.
		@return current the stat bar's current value
	*/
	public int getCurrent()
	{
		checkCurrent();
		return this.currentValue;
	}
	
	/**
		This method gets the min value.
		@return min the stat bar's minimum value
	*/
	public int getMin()
	{
		return this.minValue;
	}
	
	/**
		This method gets the max value.
		@return max the stat bar's minimum value
	*/
	public int getMax()
	{
		return this.maxValue;
	}
}
