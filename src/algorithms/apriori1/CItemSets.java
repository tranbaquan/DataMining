/**
 * 
 */
package algorithms.apriori1;

import java.util.LinkedList;

/**
 * @author TranBaQuan
 *
 */
public class CItemSets extends ItemSets {
	public CItemSets(int k) {
		super(k);
	}
	
	/**
	 * Return L k-itemset from C k-itemset
	 * @param minSup is minimum support
	 * @return LItemSets
	 */
	public LItemSets findLagreItemSets(int minSup) {
		LItemSets lItemSets = new LItemSets(k);
		boolean isEmpty = true;
		for (ItemSet itemSet : itemsets) {
			if (itemSet.getSupport() >= minSup) {
				lItemSets.addItemset(itemSet);
				isEmpty = false;
			}
		}
		if (isEmpty)
			return null;
		return lItemSets;
	}
	
	/**
	 * update support of itemset from database
	 * @param transactions
	 */
	public void updateSupport(Transaction[] transactions) {
		for (ItemSet itemSet : itemsets) {
			for (Transaction transaction : transactions) {
				int count = 0;
				LinkedList<Integer> tr = new LinkedList<>(transaction.getTransItem());
				LinkedList<Integer> it = new LinkedList<>(itemSet.getItems());
				for (Integer item : tr) {
					for (Integer item1 : it) {
						if (item == item1) {
							count++;
						}
					}
				}
				if (count == it.size()) {
					itemSet.increaseSupport();
				}
			}
		}
	}

}
