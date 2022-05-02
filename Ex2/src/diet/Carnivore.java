package diet;

import food.*;
import animals.*;

/**
 * 
 * @author tomer handali 206751489
 *
 */
public class Carnivore implements IDiet {
	public boolean canEat(EFoodType food)
	{
		
		if(food == EFoodType.MEAT )
			return true;
		return false;
		
	}
	public double eat(Animal animal, IEdible food)
	{
		
		if(!canEat(food.getFoodtype()))
			return 0;
				
		
		return animal.getWeight()*0.1;
		
	}
	
	public String toString()
	{
		return "[Carnivore]";
		
	}
	
	
}
