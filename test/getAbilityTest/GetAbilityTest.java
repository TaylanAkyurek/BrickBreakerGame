package getAbilityTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ability.Ability;
import ability.AbilityFactory;
import ability.ChanceGiving;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.UnstoppableSphere;

class GetAbilityTest {
	
	@Test
	// while loop one or more iterations (cannot know the exact number of iterations
	// as it depends on the random number generated in the method)
	// tests whether one of the ability types is added to the abilities list
	// tests whether an ability is returned
	void oneIterationTest() {
		ArrayList<Integer> abilities = AbilityFactory.getAbilities();
		abilities.clear();
		Ability ability = AbilityFactory.getAbility();
		assertTrue(abilities.contains(0) || abilities.contains(1) || abilities.contains(2) || abilities.contains(3));
		assertEquals(ability.getClass().getSuperclass(), Ability.class);
	}
	
	@Test
	// while loop zero iteration
	// each type of four abilities already created
	// at the fifth call, one of the abilities becomes duplicate in the abilities list
	// tests whether the abilities list have duplicate elements by creating a set
	void zeroIterationTest() {
		ArrayList<Integer> abilities = AbilityFactory.getAbilities();
		abilities.clear();
		AbilityFactory.getAbility();
		AbilityFactory.getAbility();
		AbilityFactory.getAbility();
		AbilityFactory.getAbility();
		AbilityFactory.getAbility();
		Set<Integer> set = new HashSet<Integer>(abilities);
		assertTrue(set.size() < abilities.size());
	}
	
	@Test
	// null pointer exception
	// if abilities list contains an unknown ability type (e.g. 4), null pointer exception is thrown
	void nullPointerTest() {
		ArrayList<Integer> abilities = AbilityFactory.getAbilities();
		abilities.clear();
		abilities.add(0);
		abilities.add(1);
		abilities.add(2);
		abilities.add(3);
		abilities.add(4);
		assertThrows(NullPointerException.class, ()->{
			AbilityFactory.getAbility();

		});
	}
	
	@Test
	// first four calls
	// tests whether first four calls return unique ability types
	// for that purpose, tests the size of the abilities list and whether it has duplicates or not for each call
	void firstFourCallTest() {
		ArrayList<Integer> abilities = AbilityFactory.getAbilities();
		abilities.clear();
		Ability ability = AbilityFactory.getAbility();
		Set<Integer> set = new HashSet<Integer>(abilities);
		assertTrue(set.size() == abilities.size());
		assertEquals(abilities.size(), 1);
		ability = AbilityFactory.getAbility();
		set = new HashSet<Integer>(abilities);
		assertTrue(set.size() == abilities.size());
		assertEquals(abilities.size(), 2);
		ability = AbilityFactory.getAbility();
		set = new HashSet<Integer>(abilities);
		assertTrue(set.size() == abilities.size());
		assertEquals(abilities.size(), 3);
		ability = AbilityFactory.getAbility();
		set = new HashSet<Integer>(abilities);
		assertTrue(set.size() == abilities.size());
		assertEquals(abilities.size(), 4);
	}
	
	@Test
	// correct ability type
	// tests whether the correct ability type is returned according to the random numbers generated
	void abilityTypeTest() {
		ArrayList<Integer> abilities = AbilityFactory.getAbilities();
		abilities.clear();
		Ability ability = AbilityFactory.getAbility();
		if (abilities.contains(0)){
			assertEquals(ability.getClass(), MagicalHex.class);
		}
		else if (abilities.contains(1)){
			assertEquals(ability.getClass(), UnstoppableSphere.class);
		}
		else if (abilities.contains(2)){
			assertEquals(ability.getClass(), PhantasmExpansion.class);
		}
		else if (abilities.contains(3)){
			assertEquals(ability.getClass(), ChanceGiving.class);
		}
	}
	

}
