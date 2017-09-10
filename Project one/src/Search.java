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
		ArrayList<Path> opendNodes;
		ArrayList<Path> queue = new ArrayList<Node>();
		     
		queue.add(problem.initialNode);
		while(true) {
			if(queue.get(0).getLastNode() == null) {
				return null;
			}
			Node curNode = queue.get(0).getLastNode();
			
			if(curNode.state.equals(problem.solution)){
				return curNode;
			}
			
			opendNodes = curNode.expand(queue.get(0));
			
			queue = searchMeth.add(opendNodes, queue);
		
		}
	}
}
