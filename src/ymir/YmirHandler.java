package ymir;

import java.io.IOException;

public class YmirHandler {

	public boolean isActive() {
		return YmirFactory.isActive();
	}
	public void useYmir() throws IOException {
		YmirFactory.useYmir();
	}
}
