package algorithms.apriori1;

import java.util.Comparator;

/**
 * Sort itemset by id of items in this
 * @author TranBaQuan
 *
 */
public class ItemSetComparator implements Comparator<ItemSet>{

	@Override
	public int compare(ItemSet o1, ItemSet o2) {
		if(o1.getItems().getFirst() > o2.getItems().getFirst()) return 1;
		if(o1.getItems().getFirst() < o2.getItems().getFirst()) return -1;
		return 0;
	}
	
}
