import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BeamSearchMethod extends SearchMethods{
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
		
		//Adding the children to the queue
		queue.addAll(opendNodes);
		if(queue.get(0).newRow && queue.size() > 1) {
			
			Collections.sort(queue, new Comparator<Path>() {
				@Override
				public int compare(Path o1, Path o2) {
					int a;
					return Float.compare(o1.getLastNode().getHCost(), o2.getLastNode().getHCost());
				}
		    });
			
			ArrayList<Path> newQueue = new ArrayList<Path>();
			newQueue.add(0, queue.get(0));
			newQueue.add(1, queue.get(1));
			newQueue.get(0).newRow = false;
			newQueue.get(1).newRow = false;
			Collections.sort(newQueue, new Comparator<Path>() {
				@Override
				public int compare(Path o1, Path o2) {
					String first, second;
					first = Character.toString(o1.getLastNode().state);
					second = Character.toString(o2.getLastNode().state);
					return first.compareTo(second);
				}
		    });
			return newQueue;
		}
		return queue;
	}

}