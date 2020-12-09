package game.cards;

import java.io.Serializable;

public class DemoCard extends Card{

    @Override
    public int getAttack() {
        return 10;
    }

    @Override
    public int getHealth() {
        return 10;
    }

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}
