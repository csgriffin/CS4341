import java.util.ArrayList;

public class Node {
	char state;
	ArrayList<Edge> connections;
	ArrayList<Node> children;
	Node parent;
	private float hCost;
	boolean expanded;
	
	public Node(char state){
		this.state = state;
		connections = new ArrayList<Edge>();
		children = new ArrayList<Node>();
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
		
			ArrayList<Path> expPath = new ArrayList<Path>();

			getChildren();
			for(int i = 0;i < children.size();i++) {
				if(!oldPath.inPath(children.get(i))) {

					Path child = new Path();
					child.addAll(oldPath.getPathNode());
					child.addOne(0 ,children.get(i));

					child.addGCost(connections.get(i).getWeight()+ oldPath.gCost);
					child.depth = oldPath.depth +1;
					//System.out.println("Adding edge of length" + connections.get(i).getWeight() + );
					expPath.add(child);
				}
			}

			children = new ArrayList<Node>();
			return expPath;
	}

	private void getChildren() {
		for(int i = 0; i < connections.size(); i++) {
			children.add(i,connections.get(i).getNodeCon(state));
			
		}
		
	}


	public float getHCost() {
		return hCost;
	}
	
	public char getState() {
		return state;
	}
}

