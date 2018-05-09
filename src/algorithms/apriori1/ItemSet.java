/**
 * 
 */
package algorithms.apriori1;

import java.util.LinkedList;

/**
 * @author TranBaQuan
 *
 */
public class ItemSet implements Cloneable {
	// length of itemset
	private int k;
	// list item
	private LinkedList<Integer> items;
	// support of item. default is zero
	private int support;

	public ItemSet() {
		this.support = 0;
		this.k = 0;
		items = new LinkedList<>();
	}

	public ItemSet(int length) {
		this.support = 0;
		this.k = length;
		items = new LinkedList<>();
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public LinkedList<Integer> getItems() {
		return items;
	}

	public void setItems(LinkedList<Integer> items) {
		this.items = items;
	}

	public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}

	/**
	 * Add item to itemset. If length of itemset equal length do nothing
	 * 
	 * @param item
	 * @return void
	 */
	public void addItem(int item) {
		if (items.size() < k)
			items.add(item);
		items.sort(new ItemComparator());
	}

	public void removeItem(int index) {
		if (index < k) {
			items.remove(index);
			k--;
			support = 0;
		}
	}

	/**
	 * increase support 1 unit. Apply with support is quantity counter
	 * 
	 * @return void
	 */
	public void increaseSupport() {
		this.support++;
	}

	/**
	 * @param orther
	 * @return true if both of head two itemset is same. Ortherwise, return false
	 */
	public boolean isSameHead(ItemSet orther) {
		for (int i = 0; i < items.size() - 1; i++) {
			if (items.get(i) != orther.items.get(i))
				return false;
		}
		return true;
	}

	/**
	 * check two itemset is same
	 * 
	 * @param itemSet
	 * @return true if this like orther
	 */
	public boolean isSame(ItemSet orther) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) != orther.items.get(i))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return items.toString() + ": " + support;
	}

	/**
	 * @return list sub itemset with length is k-1
	 * @throws CloneNotSupportedException
	 */
	public LinkedList<ItemSet> genSubsets() {
		LinkedList<ItemSet> subSets = new LinkedList<>();
		for (int i = 0; i < items.size(); i++) {
			ItemSet is = new ItemSet();
			is.setK(k);
			for (int j = 0; j < items.size(); j++) {
				is.addItem(items.get(j));
			}
			subSets.add(is);
		}
		for (int i = 0; i < subSets.size(); i++) {
			subSets.get(i).removeItem(i);
		}
		return subSets;
	}

	/**
	 * add all elements of itemSet to header
	 * 
	 * @param itemSet
	 */
	public void setHead(ItemSet itemSet) {
		for (int i = 0; i < itemSet.getItems().size(); i++) {
			items.addLast(itemSet.getItems().get(i));
		}
	}

	/**
	 * add last elements of itemSet to list item
	 * 
	 * @param itemSet
	 */
	public void setLast(ItemSet itemSet) {
		items.addLast(itemSet.getItems().getLast());
	}
}
