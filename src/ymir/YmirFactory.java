package ymir;

import java.io.IOException;
import java.util.Random;

public class YmirFactory {

	private static boolean active = false;

	public static void useYmir() throws IOException {
		Random random = new Random();
		int x = random.nextInt(2);
		System.out.println("no");
		if (x == 1) {
			System.out.println("yes");
			int y = random.nextInt(3);
			if(y == 0) {
				InfiniteVoid infVoid = new InfiniteVoid();
				infVoid.useAbility();
			}else if (y == 1) {
				DoubleAccel doubleAccel = new DoubleAccel();
				doubleAccel.useAbility();
			}else if (y == 2) {
				HollowPurple hollowPurple = new HollowPurple();
				hollowPurple.useAbility();
			}
		}
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		YmirFactory.active = active;
	}
}
