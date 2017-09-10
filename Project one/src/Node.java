import java.util.ArrayList;

public class Node {
	char state;
	ArrayList<Edge> connections;
	Path path = null;
	Node parent;
	int depth;
	int gCost;
	int hCost;
	int fCost;
	boolean expanded = false;
	
	public Node(char state){
		this.state = state;
		
	}
	
	public void addChild(Node child) {
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
	}

	public Path getPath() {
		// TODO Auto-generated method stub
		return path;
	}
}
