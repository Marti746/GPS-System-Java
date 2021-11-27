/**
 * 
 * @author David Martin
 *
 */
public class Vertex {
	private static int longestAddress = 1;
	
	public String symbol;
	public String address;
	
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
