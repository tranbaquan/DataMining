package algorithms.apriori;
/**
 * 
 * @author TranBaQuan
 *
 */
public class Item {
	private String name;
	private int id;
	
	public Item(int id) {
		super();
		this.id = id;
	}

	public Item(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.id + "";
	}
}
