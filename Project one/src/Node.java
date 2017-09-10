import java.util.ArrayList;

public class Node {
	char state;
	ArrayList<Edge> connections;
	Path path;
	Node parent;
	int depth;
	float gCost;
	float hCost;
	float fCost;
	boolean expanded;
	
	public Node(char state){
		this.state = state;
		connections = new ArrayList<Edge>();
		path = null;
		parent = null;
		expanded = false;
	}
	
	public void setHCost(float newHeuristic) {
		hCost = newHeuristic;
	}
	
	/*public void addChild(Node child) {
		children.add(child);
		
	}
	
	public ArrayList<Node> expand() {
		if(! expanded) {
			for(int i = 0;i < children.size();i++) {
				if(!children.get(i).expanded) {
					children.get(i).getPath().addAll(path.getPathNode());
					children.get(i).getPath().addOne(0 ,children.get(i));
			}
		}
		return children;
		}
		return null;
	}*/

	public Path getPath() {
		// TODO Auto-generated method stub
		return path;
	}
}
