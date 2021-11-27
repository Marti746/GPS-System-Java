public class Tester {
	
	public static void main(String[] args) {
		Graph.returnAddress = true;
		//Graph.useDistCost = false;
		Graph g = new Graph("MapInformation.txt");
		System.out.println(g);
	}
}
/**
private static int totalCost;
public static Path shortestPath(Graph graph, String startVertexName, String endVertexName) {}
**/
