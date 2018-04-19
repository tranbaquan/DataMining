package algorithms.apriori;

/**
 * LargeItemSet extend ItemSets
 * @author TranBaQuan
 *
 */
public class LItemSets extends ItemSets{
	
	public LItemSets() {
	}
	public LItemSets(int k) {
		super(k);
	}
	/**
	 * generate C (k+1)-itemsets
	 * @return
	 */
	public CItemSets generateCItemSets() {
		CItemSets result = new CItemSets(k+1);
		for (int i = 0; i < itemsets.size()-1; i++) {
			for (int j = i+1; j < itemsets.size(); j++) {
				if(itemsets.get(i).isSameHead(itemsets.get(j))) {
					ItemSet itemSet = new ItemSet(this.k + 1);
					for (Item item : itemsets.get(i).getItems()) {
						itemSet.addItem(item);
					}
					itemSet.addItem(itemsets.get(j).getItems().getLast());
					result.addItemset(itemSet);
				}
			}
		}
		return result;
	}
}
