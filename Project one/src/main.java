import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
	
	static Problem problem;
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		// Create an empty problem.
		problem = new Problem();
		
		
		// Open file specified by user into a buffered stream.
		String nextLine = null;
		BufferedReader inputStream = null;
		FileReader graphFile = new FileReader("graph.txt");
		try {
		inputStream = new BufferedReader(graphFile);
		
		
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
		
		
		// Create a Search.
		Search search = new Search();
		
		
		// Initiate an A* search.
		AStarSearchMethod aStar = new AStarSearchMethod();
		// Initiate a DFS
		DepthFirstSearchMethod depthFirst = new DepthFirstSearchMethod();
		BreadthFirstSearchMethod breadthFirst = new BreadthFirstSearchMethod();
		GreedySearchMethod greedy = new GreedySearchMethod();
		UniformCostSearchMethod uniform = new UniformCostSearchMethod();
		BeamSearchMethod beam = new BeamSearchMethod();
		DepthLimitedSearchMethod depthLimited = new DepthLimitedSearchMethod();
		IterativeDeepeningSearch iterativeDeepening = new IterativeDeepeningSearch();
		
		System.out.println("Depth first search");
		System.out.println("Expanded\tQueue");
		search.genSearch(problem, depthFirst);
		System.out.println("\nBreadth first search");
		System.out.println("Expanded\tQueue");
		search.genSearch(problem, breadthFirst);
		System.out.println("\nDepth limited search method");
		System.out.println("Expanded\tQueue");
		search.genSearch(problem, depthLimited);
		
		System.out.println("\nIterative deepening search");
		System.out.println("L=0");
		System.out.println("Expanded\tQueue");
		
		// Do iterativeDeepening until a solution is found.
		while(search.genSearch(problem, iterativeDeepening) == null) {
			System.out.println("L=" + iterativeDeepening.incrementCount());
			System.out.println("Expanded\tQueue");
		}
		
		System.out.println("\nUniform search method");
		System.out.println("Expanded\tQueue");
		problem.printG = true;
		search.genSearch(problem, uniform);
		problem.printG = false;
		System.out.println("\nGreedy search method");
		System.out.println("Expanded\tQueue");
		problem.printH = true;
		search.genSearch(problem, greedy);
		problem.printH = false;
		System.out.println("\nA* search method");
		System.out.println("Expanded\tQueue");
		problem.printF = true;
		search.genSearch(problem, aStar);
		problem.printF = false;
		System.out.println("\nBeam search method (w=2)");
		System.out.println("Expanded\tQueue");
		problem.printH = true;
		search.genSearch(problem, beam);
		problem.printH = false;
		
		
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
	}
	
	private static void readNextHeuristic(String nextLine) {
		
		// Get the node character.
		char nodeChar = nextLine.charAt(0);
		
		// Get the heuristic.
		float heuristic = Float.parseFloat(nextLine.substring(2));
		
		// The actual node.
		Node node = problem.getNode(nodeChar);
		
		// Add the heuristic.
		node.setHCost(heuristic);
	}

}
