/**
 * 
 * @author David Martin
 * Can make this a path and add Comparable here to be used
 * Path would be a node to a node
 */

public class Edge {
	public Vertex fromVertex;
	public Vertex toVertex;
	public int timeCost;
	public int distCost;
	public int longDistCost;
	
	public Edge(Vertex fromVertex, Vertex toVertex, int timeCost, int distCost) {
		super();
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.timeCost = timeCost;
		this.distCost = distCost;
	}

	@Override
	public String toString() {
		return String.format("%s -> %s(%d %s)", 
				fromVertex, toVertex, 
				Graph.useDistCost ? distCost : timeCost, 
				Graph.useDistCost ? "miles" : "minutes");
	}
	
	public int getCost() {
		if(Graph.useDistCost) 
			return distCost;
		else 
			return timeCost;
	}
}
