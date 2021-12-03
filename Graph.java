import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author David Martin
 *
 */
public class Graph {
	public static boolean useDistCost = true;
	public static boolean returnAddress = false;
	public static boolean longestDist = false;
	
	public HashMap<String, Vertex> vertices;
	public ArrayList<Edge> edges;
	
	public Graph(String fileName) {
		vertices = new HashMap<String, Vertex>();
		edges = new ArrayList<Edge>();
		String[] parts;
		
		try(Scanner fin = new Scanner(new File(fileName))){
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				if(parts[0].equals("<Nodes>")) {
					fin.nextLine();
					while(true) {
						parts = fin.nextLine().split("\t");
						if(parts[0].equals("</Nodes>")) break;
						vertices.put(parts[0], new Vertex(parts[0], parts[1]));
					}
				} else if(parts[0].equals("<Edges>")) {
					fin.nextLine();
					while(true) {
						parts = fin.nextLine().split("\t");
						if(parts[0].equals("</Edges>")) break;
						edges.add(new Edge(
								vertices.get(parts[0]),
								vertices.get(parts[1]),
								Integer.parseInt(parts[2]),
								Integer.parseInt(parts[3])
								));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			for(Edge e : edges) 
				s.append(e).append("\n");
			return s.toString();
		}

	public Vertex getVertex(String name) {
		return vertices.get(name);
	}
	
	// Method that Display can call to get all the Vertex labels from the txt document
	public String[] getAddress() {
		String[] symbols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S"};
		return symbols;
	}
	
	public ArrayList<Edge> getEdges(Vertex key) {
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(int i = 0; i < edges.size(); i++ ) {
			if(edges.get(i).fromVertex.equals(key)) ret.add(edges.get(i));
		}
		return ret;
	}
	
	public ArrayList<Edge> getVertexKids(String vertex) {
		ArrayList<Edge> ret = new ArrayList<>();
		for(Edge e : edges)
			if(e.fromVertex.symbol.equals(vertex)) {
				ret.add(e);
			}
		return ret;
	}
}
