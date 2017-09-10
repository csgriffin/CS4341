import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class main {
	
	static Problem problem;
	

	public static void main(String[] args) {
		
		
		// Create an empty problem.
		problem = new Problem();
		
		
		// Open file specified by user into a buffered stream.
		String nextLine = null;
		BufferedReader inputStream = null;
		try {
		inputStream = new BufferedReader(new FileReader(args[0]));
		
		
		// Get the first line.
		nextLine = inputStream.readLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// Read lines until the line ##### is found.
		while(!nextLine.equals("#####")) {
			readNextLine(nextLine);
			try {
				nextLine = inputStream.readLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// Skip #####
		try {
			nextLine = inputStream.readLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Read lines until the end of file.
		while(!nextLine.equals("")) {
			readNextHeuristic(nextLine);
			try {
				nextLine = inputStream.readLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		Search search = new Search();
		/*SearchMethods searchMeth;
		switch(args[1]) {
			case "Beam Search":
				searchMeth = SearchMethods.BEAM_SEARCH;
				break;
			default:
				searchMeth = SearchMethods.BEAM_SEARCH;
		}
		
		search.genSerch(problem, searchMeth);*/

	}
	
	private static void readNextLine(String nextLine) {
		
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
		
		System.out.println("First node: " + firstNodeChar + " Second node: " + secondNodeChar + " Edge weight: " + connectionLength + "\n");
	}
	//hello 
	private static void readNextHeuristic(String nextLine) {
		
		// Get the node character.
		char nodeChar = nextLine.charAt(0);
		
		// Get the heuristic.
		float heuristic = Float.parseFloat(nextLine.substring(2));
		
		// The actual node.
		Node node = problem.getNode(nodeChar);
		
		// Add the heuristic.
		node.setHCost(heuristic);
		
		System.out.println("Node is: " + nodeChar + " Heuristic is: " + heuristic + "\n");
	}

}
