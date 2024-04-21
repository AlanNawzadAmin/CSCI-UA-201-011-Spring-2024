package Graphs_final;

import LinkedList_final.ArrayList;
import LinkedList_final.GoodList;



public class knapsack {
	private static GoodList<Integer> copyWithoutIndex(GoodList<Integer> list, int index) {
//		copy list
		GoodList<Integer> newList = new ArrayList<Integer>();
		for (int j=0; j<list.size(); j++) {
			if (j != index) {
				newList.addLast(list.getAtIndex(j));
			}
		}
		return newList;
	}
	
	public static boolean ks(GoodList<Integer> list, int target) {
//		Can improve by checking target at intermediate nodes
//		and removing obviously bad branches
		if (list.size() == 0) {
			return target == 0;
		}
		boolean targetReached = false;
		for (int i=0; i<list.size(); i++) {
			GoodList<Integer> newList = copyWithoutIndex(list, i);
			targetReached = targetReached || ks(newList, target - list.getAtIndex(i)) || ks(newList, target);
		}
		return targetReached;
	}
}
