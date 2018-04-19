package algorithms.apriori;

import java.util.LinkedList;
/**
 * Candidate Itemsets extend ItemSets
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
				LinkedList<Item> tr = new LinkedList<>(transaction.getTransItem());
				LinkedList<Item> it = new LinkedList<>(itemSet.getItems());
				for (Item item : tr) {
					for (Item item1 : it) {
						if (item.getId() == item1.getId()) {
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
