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

	public Node genSearch(Problem problem, SearchMethods searchMeth){
		ArrayList<Path> opendNodes;
		ArrayList<Path> queue = new ArrayList<Path>();
		     
		queue.add(new Path(problem.getNode('S')));
		while(true) {
			if(queue.size() == 0) {
				return null;
			}
			Node curNode = queue.get(0).getLastNode();
			System.out.print("   "+curNode.state);
			printQueue(queue, problem);
			if(curNode.state == problem.solution){
				System.out.println("goal reached!");
				return curNode;
			}
			

			opendNodes = curNode.expand(queue.get(0));
			queue.remove(0);
			queue = searchMeth.add(opendNodes, queue);
		
		}
	}
	
	private void printQueue(ArrayList<Path> queue, Problem problem) {
		System.out.print("\t\t[");
		for (int i = 0; i< queue.size(); i++) {
			if(problem.printF) {System.out.print(queue.get(i).getFCost());}
			if(problem.printH) {System.out.print(queue.get(i).getLastNode().getHCost());}
			if(problem.printG) {System.out.print(queue.get(i).gCost);}
			System.out.print("<");
			
			for (int j=0; j<queue.get(i).nodes.size();j++) {
				System.out.print(queue.get(i).nodes.get(j).state);
				if(j < queue.get(i).nodes.size()-1)
					System.out.print(",");
			}
			System.out.print(">");
		}
		System.out.print("]\n");
	}
}
