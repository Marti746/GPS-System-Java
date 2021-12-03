/**
 * 
 * @author David Martin
 * extends Rectangle 
 */

public class Vertex {
	private static int longestAddress = 1;
	public String symbol;
	public String address;
	//HashMap<String, int> edge;
//	public final static int SIZE = 28;
//	public enum enuState {
//		UNSELECTED, START, END
//	}
//	public enuState state = enuState.UNSELECTED;
//	
//	public Vertex(String symbol, String address, int x, int y) {
//		super(x, y, SIZE, SIZE);
//		this.symbol = symbol;
//		this.address = address;
//		longestAddress = Math.max(longestAddress, address.length());
//	}
	
//	public void setSize(int size) {
//		width = size;
//		height = size;
//	}
	
	public Vertex(String symbol, String address) {
		this.symbol = symbol;
		this.address = address;
		longestAddress = Math.max(longestAddress, address.length());
	}
	
	@Override
	public String toString() {
		return String.format("%-" + (Graph.returnAddress ? longestAddress : 1) + "s", 
				Graph.returnAddress ? address : symbol);
	}
} // end Vertex class
