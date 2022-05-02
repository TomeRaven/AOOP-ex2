package diet;

import food.*;
import animals.*;
/**
 * 
 * @author tomer handali 206751489
 *
 */
public class Omnivore implements IDiet {
	
	public boolean canEat(EFoodType food)
	{
		Carnivore c = new Carnivore();
		Herbivore h = new Herbivore();
		
		if(c.canEat(food)|| h.canEat(food)) 
			return true;
		return false;
	}
		
	public double eat(Animal animal, IEdible food)
	{
		Carnivore c=new Carnivore();
		Herbivore h = new Herbivore();
		
		if(c.canEat(food.getFoodtype()))
			return c.eat(animal, food);
		else if(h.canEat(food.getFoodtype()))
			return h.eat(animal, food);
		
		return 0;
	}
	
	public String toString()
	{
		return "[Omnivore]";
		
	}

}
