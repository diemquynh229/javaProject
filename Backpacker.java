package hw1;

public class Backpacker {
	public static final int SYMPATHY_FACTOR = 30;
	private String currentLocation;
	private int currentFund;
	private int numNightsinTrainStation;
	private String journal;
	private int count;
	private int cost;
	private boolean isSOL=false;
	private int maxPostcard;

	
	public Backpacker(int initialFunds, Location initialLocation) {
		currentLocation = initialLocation.getName();
		currentFund = initialFunds;
		journal = initialLocation.getName() + "(start)";
		cost = initialLocation.costToSendPostcard();		
	}
	
		
	public String getCurrentLocation() {
		return currentLocation;
	}
	
	public int getCurrentFunds() {
		return currentFund;
	}
	
	public String getJournal() {
		return journal;
	}
	
	public boolean isSOL() {
		if(currentFund < cost) {
			isSOL = true;
		}else {
			isSOL = false;
		}
		return isSOL;
	}
	
	public int getTotalNightsInTrainStation() {
		
		return numNightsinTrainStation;
	}
	
	public void visit(Location c, int numNights) {
		cost = c.costToSendPostcard();
		currentLocation = c.getName();
		numNightsinTrainStation += numNights - Math.min(currentFund/c.lodgingCost(), numNights);
		currentFund -= c.lodgingCost() * Math.min(currentFund/c.lodgingCost(), numNights);
		journal += ", " + c.getName() + "(" +numNights+ ")";
	}
	
	public void sendPostcardsHome(int howMany) {	
		maxPostcard = currentFund / cost;
		count += Math.min(maxPostcard, howMany);
		currentFund -= cost * Math.min(maxPostcard, howMany);	
		
	}
	
	public void callHomeForMoney() {		
		currentFund += count * SYMPATHY_FACTOR;	
		count=0;
	}
	
}
