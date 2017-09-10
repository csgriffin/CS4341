import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BreadthFirstSearchMethod extends SearchMethods{
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
		Collections.reverse(opendNodes);
		
		//Adding the children to the queue
		queue.addAll(opendNodes);
		return queue;
	}

}
