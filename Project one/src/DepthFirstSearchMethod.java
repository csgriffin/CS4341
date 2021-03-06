import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DepthFirstSearchMethod extends SearchMethods{
	public ArrayList<Path> add(ArrayList<Path> opendNodes, ArrayList<Path> queue) {
		// Sorting the children alphabetically
		Collections.sort(opendNodes, new Comparator<Path>() {
				@Override
				public int compare(Path o1, Path o2) {
					String first, second;
					first = Character.toString(o1.getLastNode().state);
					second = Character.toString(o2.getLastNode().state);
					return first.compareTo(second);
				}
		    });
		
		//Adding the queue to the children (this way the children are first on the list)
		opendNodes.addAll(queue);
		queue = opendNodes;
		return queue;
	}

}
