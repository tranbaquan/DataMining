/**
 * 
 */
package algorithms.apriori1;

import java.util.LinkedList;

/**
 * @author TranBaQuan
 *
 */
public class LItemSets extends ItemSets {
	public LItemSets() {
	}

	public LItemSets(int k) {
		super(k);
	}

	/**
	 * generate C (k+1)-itemsets
	 * 
	 * @return
	 */
	public CItemSets generateCItemSets() {
		CItemSets result = new CItemSets(k + 1);
		for (int i = 0; i < itemsets.size() - 1; i++) {
			for (int j = i + 1; j < itemsets.size(); j++) {
				if (itemsets.get(i).isSameHead(itemsets.get(j))) {
					ItemSet itemSet = new ItemSet(this.k + 1);
					itemSet.setHead(itemsets.get(i));
					itemSet.setLast(itemsets.get(j));
					if (!hasInfrequentSub(itemSet)) {
						result.addItemset(itemSet);
					}
				}
			}
		}
		return result;
	}

	private boolean hasInfrequentSub(ItemSet itemSet) {
		LinkedList<ItemSet> subSets = itemSet.genSubsets();
		for (ItemSet sub : subSets) {
			if (!this.isContain(sub))
				return true;
		}
		return false;
	}
}
