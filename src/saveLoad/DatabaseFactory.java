package saveLoad;

public class DatabaseFactory {

	private static DatabaseFactory instance;
		
		private DatabaseFactory() {}
			
		public static DatabaseFactory getInstance() {
			if (instance == null) {
				instance = new DatabaseFactory();
			}
			return instance;
		}
		
		public IDatabaseAdapter getDatabaseAdapter(String databaseSelected)  {
			IDatabaseAdapter database = null;
			if (databaseSelected == "Database")
				database = new DatabaseAdapter();
		
			return database;
		}
	
}
