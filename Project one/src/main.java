import java.io.BufferedReader;
import java.io.FileReader;

public class main {
	
	static Problem problem;
	

	public static void main(String[] args) {
		
		
		// Create an empty problem.
		problem = new Problem();
		
		
		// Open file specified by user into a buffered stream.
		BufferedReader inputStream = new BufferedReader(new FileReader(args[1]));
		
		
		// Get the first line.
		String nextLine = inputStream.readLine();
		
		
		// Read lines until the line ##### is found.
		while(nextLine != "#####") {
			readNextLine(nextLine);
			nextLine = inputStream.readLine();
		}
		
		
		Search search = new Search();
		problem.initialNode = new Node("S");
		SearchMethods searchMeth;
		switch(args[1]) {
			case "Beam Search":
				searchMeth = SearchMethods.BEAM_SEARCH;
				break;
			default:
				searchMeth = SearchMethods.BEAM_SEARCH;
		}
		
		search.genSerch(problem, searchMeth);

	}
	
	private static String readNextLine(String nextLine) {
		
		// Get the node characters.
		char firstNodeChar = nextLine.charAt(0);
		char secondNodeChar = nextLine.charAt(2);
		
		
		// Get the connection length.
		float connectionLength = Float.parseFloat(nextLine.substring(4));
		
		
		// The actual nodes.
		Node firstNode = problem.getNode(firstNodeChar);
		Node secondNode = problem.getNode(secondNodeChar);
		
		
		// Check if the nodes exist in the problem, add them if they do not.
		if(firstNode == null) {
			firstNode = new Node(firstNodeChar);
			problem.nodes.add(firstNode);
		}
		
		if(secondNode == null) {
			secondNode = new Node(secondNodeChar);
			problem.nodes.add(secondNode);
		}
		
		
		// Add a connection between the nodes.
		problem.addEdge(firstNode, secondNode, connectionLength);
		
		
		return "";
	}

}
