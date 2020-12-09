package game.cards;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class CardRegistery {
	public static List<Class> registry;
	
	private static void init()
	{
		registry = new ArrayList<>();
		
		registry.add(DemoCard.class);
		registry.add(DemoCard2.class);

	}

	public static int get(Class<? extends Card> class1) {
		if(registry == null)init();
		int a = registry.indexOf(class1);
		return a != -1 ? a : 0;
	}
	
	
}
