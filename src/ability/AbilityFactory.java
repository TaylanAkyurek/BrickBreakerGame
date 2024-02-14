package ability;

import java.util.ArrayList; 
import java.util.Random;

public class AbilityFactory {
	
	private static ArrayList<Integer> abilities = new ArrayList<Integer>();
	

	public static ArrayList<Integer> getAbilities() {
		return abilities;
	}


	public static void setAbilities(ArrayList<Integer> abilities) {
		AbilityFactory.abilities = abilities;
	}
	


	public static Ability getAbility() throws NullPointerException {
		//Effects: This method returns a random ability to be assigned to the uranus box falling from a gift obstacle.
		// It ensures that each 4 ability is returned once through the first 4 calls to this method.
		// After 4 calls, one of the abilities is returned randomly.
		
		MagicalHex magicalHex;
		UnstoppableSphere unstoppableSphere;
		PhantasmExpansion phantasmExpansion;
		ChanceGiving chanceGiving;

		while (abilities.size() < 4) {
			Random random = new Random();
			int x = random.nextInt(4);
			if (x == 0 && !abilities.contains(0)){
				magicalHex = new MagicalHex();
				abilities.add(0);
				return magicalHex;
			}else if (x == 1 && !abilities.contains(1)) {
				unstoppableSphere = new UnstoppableSphere();
				abilities.add(1);
				return unstoppableSphere;
			}else if (x == 2 && !abilities.contains(2)) {
				phantasmExpansion = new PhantasmExpansion();
				abilities.add(2);
				return phantasmExpansion;
			}else if (x == 3 && !abilities.contains(3)) {
				chanceGiving = new ChanceGiving();
				abilities.add(3);
				return chanceGiving;
			}
		}
		
		if (abilities.size() >= 4) {
			Random random = new Random();
			int x = random.nextInt(4);
			if (x == 0){
				magicalHex = new MagicalHex();
				abilities.add(0);
				return magicalHex;
			}else if (x == 1) {
				unstoppableSphere = new UnstoppableSphere();
				abilities.add(1);
				return unstoppableSphere;
			}else if (x == 2) {
				phantasmExpansion = new PhantasmExpansion();
				abilities.add(2);
				return phantasmExpansion;
			}else if (x == 3) {
				chanceGiving = new ChanceGiving();
				abilities.add(3);
				return chanceGiving;
			}
		}

		throw new NullPointerException();
	}
}
