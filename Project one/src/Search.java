import java.util.ArrayList;

/**
 * 
 */

/**
 * @author vojta
 *
 */
public class Search {
	
	public Search() {
	}

	public Node genSerch(Problem problem, SearchMethods searchMeth){
		ArrayList<Node> opendNodes;
		ArrayList<Node> queue = new ArrayList<Node>();
		     
		queue.add(problem.initialNode);
		while(true) {
			if(queue.get(0) == null) {
				return null;
			}
			Node curNode = queue.get(0);
			if(curNode.state.equals(problem.solution)){
				return queue.get(0);
				//or return curNode.state;
				//or return path
			}
			
			opendNodes = curNode.expand();
			
			queue = searchMeth.add(opendNodes, queue);
		
		}
	}
}
