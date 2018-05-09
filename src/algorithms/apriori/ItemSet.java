package algorithms.apriori;

import java.util.*;
/**
 * Contain k item with k is length parameter
 * @author TranBaQuan
 *
 */
public class ItemSet implements Cloneable {
	// length of itemset
	private int length;
	// list item
	private LinkedList<Item> items;
	// support of item. default is zero
	private int support;

	public ItemSet() {
		this.support = 0;
		this.length = 0;
		items = new LinkedList<>();
	}

	public ItemSet(int length) {
		this.support = 0;
		this.length = length;
		items = new LinkedList<>();
	}


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
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
	public void addItem(Item item) {
		if (items.size() < length)
			items.add(item);
		items.sort(new ItemComparator());
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
		for (int i = 0; i < this.items.size() - 1; i++) {
			Item item1 = this.items.get(i);
			Item item2 = orther.items.get(i);
			if (item1.getId() != item2.getId())
				return false;
		}
		return true;
	}
	
	/**
	 * check itemset is same
	 * @param itemSet
	 * @return true if this like itemSet
	 */
	public boolean isSameItemSet(ItemSet itemSet) {
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getId() != itemSet.items.get(i).getId()) return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return items.toString();
	}

}
