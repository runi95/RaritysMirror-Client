package backend;

public class ClientInformation {
	private static final String version = "v0.0.1";
	private long lastUpdated;
	
	public String getVersion() { return version; }
	public long getLastUpdated() { return lastUpdated; }
	
	public void setLastUpdated(long newTime) { lastUpdated = newTime; }	
}
