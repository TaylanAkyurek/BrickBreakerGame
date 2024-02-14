package ability;

import java.io.Serializable;

import domain.Player;

public class ChanceGiving extends Ability implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Player player = Player.player;

	@Override
	public void useAbility() {
		player.setRemLives(player.getRemLives() + 1);
		
	}

	@Override
	public void getAbility() {
		useAbility();
		
	}

}
