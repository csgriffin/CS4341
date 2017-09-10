import java.util.ArrayList;

public class Node {
	char state;
	ArrayList<Edge> connections;
	ArrayList<Node> children = new ArrayList<Node>();
	Node parent;
	private float hCost;
	boolean expanded;
	
	public Node(char state){
		this.state = state;
		connections = new ArrayList<Edge>();
		parent = null;
		expanded = false;
	}
	
	public void setHCost(float newHeuristic) {
		hCost = newHeuristic;
	}
	
	public void addEdge(Edge edge) {
		connections.add(edge);
		
	}
	
	public ArrayList<Path> expand(Path oldPath) {
		if(! expanded) {
			ArrayList<Path> expPath = new ArrayList<Path>();
			getChildren();
			for(int i = 0;i < children.size();i++) {
				if(!children.get(i).expanded) {
					Path child = new Path();
					child.addAll(oldPath.getPathNode());
					child.addOne(0 ,children.get(i));
					child.addGCost(connections.get(i).getWeight());
					expPath.add(child);
				}
			}
			return expPath;
		}
		return null;
	}

	private void getChildren() {
		for(int i = 0; i < connections.size(); i++) {
			children.add(i,connections.get(i).getNodeCon(state));
			
		}
		
	}


	public float getHCost() {
		return hCost;
	}
	public void addHCost(float hCost) {
		this.hCost = hCost;
	}
	public char getState() {
		return state;
	}
}
