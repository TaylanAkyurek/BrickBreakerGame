package moveTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.MoveSphere;
import domain.Sphere;

class MoveTest {

	@Test
	void test1() {
		// if there is no object or wall
		MoveSphere ms = new MoveSphere(new Sphere(20,-20,200,200,20));
		ms.move(false, false);
		assertEquals(ms.getSphere().getX(),220);
		assertEquals(ms.getSphere().getY(),220);

		
	
	}

	
	@Test
	void test2() {
		// if there is wall 
		MoveSphere ms = new MoveSphere(new Sphere(20,-20,495,200,20));
		ms.move(false, false);
		assertEquals(ms.getSphere().getHorizontalSpeed(),-20);

		
	
	}
	
	@Test
	void test3() {
		// if there is wall and objectUp 
		MoveSphere ms = new MoveSphere(new Sphere(20,-20,495,200,20));
		ms.move(true, false);
		assertEquals(ms.getSphere().getHorizontalSpeed(),-20);
		assertEquals(ms.getSphere().getVerticalSpeed(),-20);

		
	
	}
	
	@Test
	void test4() {
		
		// if there is objects on both side
		MoveSphere ms = new MoveSphere(new Sphere(20,-20,200,200,20));
		ms.move(true, true);
		assertEquals(ms.getSphere().getHorizontalSpeed(),-20);
		assertEquals(ms.getSphere().getVerticalSpeed(),-20);

		
	
	}
	
	@Test
	void test5() {
		// nullPointer exception test
		MoveSphere ms = new MoveSphere(null);
		assertThrows(NullPointerException.class, ()->{
			ms.move(false, false);

		});

	}
	
	
}
