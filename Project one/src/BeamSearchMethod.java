import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BeamSearchMethod extends SearchMethods{
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
		
		//Adding the children to the queue
		queue.addAll(opendNodes);
		queue.subList(2, queue.size());
		
		return queue;
	}

}
