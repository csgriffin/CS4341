import java.util.ArrayList;

public class Node {
	String state;
	ArrayList<Node> children;
	Path path = null;
	
	public Node(String state){
		this.state = state;
	}
	
	public ArrayList<Node> expand() {
		for(int i = 1;i <= children.size();i++) {
			children.get(i).path().addall() 
		}
		return children;
	}
}
