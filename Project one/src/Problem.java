import java.util.ArrayList;

public class Problem {

	public ArrayList<Node> nodes;
	public char solution;
	public int numExpanded;
	public boolean iterative;
	
	
	public Problem() {
		nodes = new ArrayList<Node>();
		solution = 'G';
		numExpanded = 0;
		iterative = false;
	}
	
	
	public Node getNode(char nodeName) {
		
		// Search for the node and return it.
		for(int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).state == nodeName) {
				return nodes.get(i);
			}
		}
		
		
		// If the node does not exist, return null.
		return null;
	}
	
	
	public void addEdge(char node1, char node2, float edgeWeight) {
		
		
		// Get the nodes.
		Node firstNode = getNode(node1);
		Node secondNode = getNode(node2);
		
		
		// Create the edge and add it to the nodes.
		Edge edge = new Edge(firstNode, secondNode, edgeWeight);
		
		//i add the children  in the node this is why there was a overflow
		firstNode.connections.add(edge);
		//firstNode.children.add(secondNode);
		secondNode.connections.add(edge);
		//secondNode.children.add(firstNode);
		
		
	}
	
	
	public void addEdge(Node node1, Node node2, float edgeWeight) {
		// Get the nodes.
		Node firstNode = getNode(node1.state);
		Node secondNode = getNode(node2.state);
				
				
		// Create the edge and add it to the nodes.
		Edge edge = new Edge(firstNode, secondNode, edgeWeight);
		
		
		firstNode.connections.add(edge);
		secondNode.connections.add(edge);
	}

}
