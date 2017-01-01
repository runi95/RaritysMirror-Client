package backend;

public class ClientInformation {
	private static final String version = "v0.0.1";
	private String name;
	private long lastUpdated;
	
	public String getName() { return name; }
	public String getVersion() { return version; }
	public long getLastUpdated() { return lastUpdated; }
	
	public void setName(String name) { this.name = name; }
	public void setLastUpdated(long newTime) { lastUpdated = newTime; }	
}
