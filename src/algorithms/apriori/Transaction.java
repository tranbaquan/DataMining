package algorithms.apriori;

import java.util.*;
/**
 * Transaction of user
 * @author TranBaQuan
 *
 */
public class Transaction {
	private int id;
	private LinkedList<Item> transItem;
	public Transaction(int id) {
		super();
		this.id = id;
		this.transItem = new LinkedList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkedList<Item> getTransItem() {
		return transItem;
	}
	public void setTransItem(LinkedList<Item> transItem) {
		this.transItem = transItem;
	}
	
	public void addItem(Item item) {
		this.transItem.add(item);
	}
	@Override
	public String toString() {
		return transItem.toString();
	}
}
