/**
 * Path Class to help show and direct to the right path for the ShortestPath
 * @author David Martin
 * implements Comparable<Path>
 */
public class Path implements Comparable<Path> {
	//public String vertex;
	public String vertex;
	public Vertex toVertex;
	public String pathStr;
	public int cost;

	public Path(String vertex, int cost, String pathStr) {
		this.vertex = vertex;
		this.cost = cost;
		this.pathStr = pathStr;
	}

	public int compareTo(Path other) {
		if(Graph.longestDist == true)	return other.cost - cost;
		else							return cost - other.cost;
		//return cost - other.cost;    // lower cost goes first
	}
	
	@Override
	public String toString() {
		return Dijkstra.pathStr;
	}
//	public String path = "";
//	public int totalCost = 0;
//	public ArrayList<String> symbols;
//	
//	public String getLast() {
//		return (path.length() == 0) ? "" : path.charAt(path.length() - 1) + "";
//	}
}
