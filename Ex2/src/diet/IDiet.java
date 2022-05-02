package diet;

import food.*;
import animals.*;
/**
 * 
 * @author tomer handali 206751489
 *
 */
public interface IDiet {
	public boolean canEat(EFoodType food);
	public double eat(Animal animal, IEdible food);
}
