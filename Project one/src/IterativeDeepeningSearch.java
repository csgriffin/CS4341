import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IterativeDeepeningSearch extends SearchMethods{
	
	static int count = 0;
	
	
	@Override
	public ArrayList<Path> add(ArrayList<Path> opendNodes, ArrayList<Path> queue) {
		
		
		// Check if we are at depth 5, if so return queue. We are not searching.
		if(count == 5) {
			return queue;
		}
		
		
		// Perform the search.
		DepthLimitedSearchMethod depthSearch = new DepthLimitedSearchMethod();
		ArrayList<Path> newqueue = depthSearch.add(opendNodes, queue, count);
		
		
		// Return the new queue.
		return newqueue;
	}	
	
	
	public int incrementCount() {
		count++;
		return count;
	}
	
}
