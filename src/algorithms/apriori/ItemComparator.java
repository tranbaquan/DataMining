package algorithms.apriori;

import java.util.Comparator;
/**
 * Sort item by id ascendant
 * @author TranBaQuan
 *
 */
public class ItemComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getId() > o2.getId()) return 1;
		if(o1.getId() < o2.getId()) return -1;
		return 0;
	}

}
