package uranusBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;

import domain.UranusBox;

class UranusBoxTest {

	@BeforeEach
	void setUp() {
		try {
			UranusBox ubox = new UranusBox(50, 50, 5, 50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Size must be greater than 0. Our first test is we set size to 0. 
	// With the assertFalse function, our test is successful if it is false.
	@Test
	void sizeTest1() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 0, 5);
		assertFalse(ubox.getSize() > 0);

	}
	
	// Size must be greater than 0. Our second test is we set size to 5. 
	// With the assertTrue function, our test is successful if it is true.
	@Test
	void sizeTest2() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 5, 5);
		assertTrue(ubox.getSize() > 0);

	}
	
	// Speed must be greater than 0. Our third test is we set speed to 0. 
	// With the assertFalse function, our test is successful if it is false.
	@Test
	void speedTest3() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 5, 0);
		assertFalse(ubox.getSpeed() > 0);
	}

	// Speed must be greater than 0. Our fourth test is we set speed to 5. 
	// With the assertTrue function, our test is successful if it is true.
	@Test
	void speedTest4() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 5, 5);
		assertTrue(ubox.getSpeed() > 0);

	}

	// Uranus Box's Y coordinate cannot be bigger than game map's Y coordinate.
	// Our fifth test is we set Y 400 
	// With the assertTrue function, our test is successful if it is true.
	@Test
	void yTest5() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 5, 5);
		ubox.setY(400);
		assertTrue(ubox.getY() < 500);

	}
	
	// Uranus Box's Y coordinate cannot be bigger than game map's Y coordinate.
	// Our sixth test is we set Y 600 
	// With the assertFalse function, our test is successful if it is false.
	@Test
	void yTest6() throws Exception {

		UranusBox ubox = new UranusBox(50, 50, 5, 5);
		ubox.setY(600);
		assertFalse(ubox.getY() < 500);

	}

}
