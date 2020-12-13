package hw1;

public class Location {
	
	public static final double RELATIVE_COST_OF_POSTCARD = 0.05;
	private String givenName;
	private int lodgingCost;
	private int cost;
	public Location(String givenName, int givenLodgingCost) {
		this.givenName = givenName;
		lodgingCost = givenLodgingCost;
	}
	
	public String getName() {
		return givenName;
	}
	 
	public int lodgingCost() {
		return lodgingCost;
	}
	
	public int costToSendPostcard() {
		cost = (int) Math.round(lodgingCost*RELATIVE_COST_OF_POSTCARD);
		return cost;
	}
	
	public int maxLengthOfStay(int funds) {
		int length =0;
		if(funds >= lodgingCost) {
			length = funds / lodgingCost;
		}else {
			return 0;
		}
		return length;
	}
	
	public int maxNumberOfPostcards(int funds) {
		return funds/costToSendPostcard();
	}
}		

