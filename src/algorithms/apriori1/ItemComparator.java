package algorithms.apriori1;

import java.util.Comparator;
/**
 * Sort item by id ascendant
 * @author TranBaQuan
 *
 */
public class ItemComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2) return 1;
		if(o1 < o2) return -1;
		return 0;
	}

}
