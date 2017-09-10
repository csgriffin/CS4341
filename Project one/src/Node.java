import java.util.ArrayList;

public class Node {
	String state;
	ArrayList<Node> children;
	Path path = null;
	Node parent;
	int depth;
	int gCost;
	int hCost;
	int fCost;
	boolean expanded = false;
	
	public Node(String state){
		this.state = state;
		
	}
	
	public void addChild(Node child) {
		children.add(child);
		
	}
	
	public ArrayList<Node> expand() {
		if(! expanded) {
		for(int i = 1;i <= children.size();i++) {
			children.get(i).path().addall(path);
		}
		return children;
		}
		return null;
	}
}
