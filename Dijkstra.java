import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Dijkstra Algorithm implementation for the GPS System
 * @author David Martin
 *
 */
public class Dijkstra {       
	private static int totalCost;
	public static String pathStr = "";

	public static Path shortestPath(Graph graph, String startVertex, String endVertex) {
		PriorityQueue<Path> list = new PriorityQueue<Path>();
		//ArrayList<Vertex> visited = new ArrayList<Vertex>();
		ArrayList<String> visited = new ArrayList<String>();
		list.add(new Path(startVertex, 0, ""));

		while(!list.isEmpty()) {
			Path nextEntry = list.remove();
			if (nextEntry.vertex.equals(endVertex)) {
				pathStr = nextEntry.pathStr;
				System.out.println(pathStr);
				return nextEntry;
			} 
			if (!visited.contains(nextEntry.vertex)) {
				visited.add(nextEntry.vertex);

				//ArrayList<Edge> next = graph.getEdges(nextEntry.vertex);
				ArrayList<Edge> next = graph.getVertexKids(nextEntry.vertex);
				for(Edge e : next) {
					if(!visited.contains(e.toVertex.symbol)) {
						// good for adding a new Path of inputs(String, int, String);
						list.add(new Path(e.toVertex.symbol, nextEntry.cost + (Graph.useDistCost ? e.distCost : e.timeCost), nextEntry.pathStr));
						// good for adding a new Path of inputs(Vertex, int, String);
						//list.add(new Path(e.toVertex, nextEntry.cost + (Graph.useDistCost ? e.distCost : e.timeCost), nextEntry.pathStr));
					}
				}
			} // end of 1st else
		} // end of while loop
		return null;
	}
}