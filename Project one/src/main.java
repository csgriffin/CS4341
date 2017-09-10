
public class main {

	public static void main(String[] args) {

		Problem problem = new Problem();
		Search search = new Search();
		problem.initialNode = new Node("S");
		SearchMethods searchMeth;
		switch(args[1]) {
			case "Beam Search":
				searchMeth = SearchMethods.BEAM_SEARCH;
				break;
			default:
				searchMeth = SearchMethods.BEAM_SEARCH;
		}
		
		search.genSerch(problem, searchMeth);

	}

}
