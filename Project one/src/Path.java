import java.util.ArrayList;

public class Path {
	ArrayList<Node> nodes = new ArrayList<Node>();
	

	public void addAll(ArrayList<Node> path) {
		// TODO Auto-generated method stub
		nodes.addAll(path);
	}
	
	public void addOne(Node node) {
		nodes.add(node);
	}
	
	public ArrayList<Node> getPathNode(){
		return nodes;
	}
}
