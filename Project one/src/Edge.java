
public class Edge {

	public Node firstNode;
	public Node secondNode;
	
	public float edgeWeight;
	

	public Edge(Node firstNode, Node secondNode, float edgeWeight) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.edgeWeight = edgeWeight;
	}
		
	public Node getNodeCon(String state) {
		if(firstNode.getState().equals(state)) {
			return secondNode;
		}else {
			return firstNode;
		}
	}
	
	public int getWeight() {
		return edgeWeight;
	}
}
