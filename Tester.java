public class Tester {
	
	public static void main(String[] args) {
		Graph.returnAddress = true;
		//Graph.useDistCost = false;
		Graph g = new Graph("MapInformation.txt");
		System.out.println(g);
	}
}
