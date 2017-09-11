import java.util.ArrayList;


public class Path {
	ArrayList<Node> nodes = new ArrayList<Node>();
	float gCost;
	float fCost;
	int depth;
	boolean newRow;
	
	public Path() {
		depth = 0;
		newRow = false;
	}
	
	public Path(Node initialNode) {
		nodes.add(initialNode);
	}
	
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
	public void addGCost(float newG) {
		gCost += newG;
		//System.out.println(gCost);
	}
	public boolean inPath(Node n) {
		if(nodes.indexOf(n) != -1) {
			return true;
		}
		return false;
	}
}

