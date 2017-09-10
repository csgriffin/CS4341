import java.util.ArrayList;

public class Path {
	ArrayList<Node> nodes = new ArrayList<Node>();
	float gCost;
	float fCost;
	int depth;
	
	public void addAll(ArrayList<Node> path) {
		// TODO Auto-generated method stub
		nodes.addAll(path);
	}
	
	public void addOne(int index, Node node) {
		nodes.add(index, node);
	}
	
	public ArrayList<Node> getPathNode(){
		return nodes;
	}
	public Node getLastNode(){
		return nodes.get(0);
	}
	
	public float getFCost() {
		fCost = gCost + nodes.get(0).getHCost();
		return fCost;
	}
	public void addGCost(int newG) {
		gCost += newG;
	}
}
