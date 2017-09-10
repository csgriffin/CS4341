import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HillClimbingSearchMethod extends SearchMethods{
	public ArrayList<Path> add(ArrayList<Path> opendNodes, ArrayList<Path> queue) {
		// Sorting the children alphabetically
		Collections.sort(opendNodes, new Comparator<Path>() {
			@Override
			public int compare(Path o1, Path o2) {
				int a;
				a = Float.compare(o1.getLastNode().getHCost(), o2.getLastNode().getHCost());
				
				//If are the same, sort by alphabetical order
				if (a == 0) {
					String first, second;
					first = Character.toString(o1.getLastNode().state);
					second = Character.toString(o2.getLastNode().state);
					a = first.compareTo(second);
				}
				return a;
			}
	    });
		Collections.reverse(opendNodes);
		
		//Adding the queue to the children (this way the children are first on the list)
		opendNodes.addAll(queue);
		queue = opendNodes;
		return queue;
	}
}
