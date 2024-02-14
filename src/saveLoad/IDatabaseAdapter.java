package saveLoad;

import java.io.IOException;

public interface IDatabaseAdapter {
	
	public void save() throws IOException;
	public Object load() throws Exception;
	
}
