import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GreedySearchMethod extends SearchMethods{
	public ArrayList<Path> add(ArrayList<Path> opendNodes, ArrayList<Path> queue) {
		for(int i = 0; i<opendNodes.size(); i++) {
			queue.add(opendNodes.get(i));
		}
		
		// Sorting
		Collections.sort(queue, new Comparator<Path>() {
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
		return queue;
	}
}
