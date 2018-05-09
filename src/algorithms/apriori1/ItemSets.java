/**
 * 
 */
package algorithms.apriori1;

import java.util.LinkedList;

/**
 * @author TranBaQuan
 *
 */
public abstract class ItemSets {
	// list of itemset
	protected LinkedList<ItemSet> itemsets;
	// length of all itemset in list
	protected int k;

	public ItemSets() {
		itemsets = new LinkedList<>();
	}

	public ItemSets(int k) {
		this.k = k;
		itemsets = new LinkedList<>();
	}

	public LinkedList<ItemSet> getItemsets() {
		return itemsets;
	}

	public void setItemsets(LinkedList<ItemSet> itemsets) {
		this.itemsets = itemsets;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	/**
	 * Add item to itemsets
	 * 
	 * @param itemSet
	 */
	public void addItemset(ItemSet itemSet) {
		if (!isContain(itemSet)) {
			itemsets.add(itemSet);
		}
	}

	/**
	 * check itemset is contain itemSet
	 * 
	 * @param itemSet
	 * @return boolean
	 */
	public boolean isContain(ItemSet itemSet) {
		for (ItemSet is : itemsets) {
			if (is.getK() == itemSet.getK()) {
				if (is.isSame(itemSet)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return itemsets.toString();
	}

}
