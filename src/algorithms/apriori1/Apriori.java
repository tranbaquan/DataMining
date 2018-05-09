package algorithms.apriori1;

import java.io.*;
import java.util.Arrays;
/**
 * 
 * @author TranBaQuan
 *
 */
public class Apriori {
	Transaction[] database;
	int minSup;
	int minConf;

	public Apriori() {
	}

	/**
	 * read data file from source to list transaction. If can't read or sf is not
	 * found throw IOException
	 * 
	 * @param sf
	 * @throws IOException
	 */
	public void getInstances(String sf) throws IOException {
		Database db = new Database();
		this.database = db.loadData(sf);
	}

	/**
	 * set minimum support for algorithm
	 * 
	 * @param minSup
	 */
	public void setMinSup(int minSup) {
		this.minSup = minSup;
	}

	/**
	 * set minimum confidence for algorithm
	 * 
	 * @param minConf
	 */
	public void setMinConf(int minConf) {
		this.minConf = minConf;
	}

	/**
	 * run apriori algorithm
	 * 
	 * @return ItemSets
	 */
	public ItemSets apriori() {
		LItemSets result = new LItemSets();
		LItemSets lk;
		// create unique candidate 1-itemset
		CItemSets ck = new CItemSets(1);
		// read database
		for (int i = 0; i < database.length; i++) {
			for (Integer item : database[i].getTransItem()) {
				ItemSet is = new ItemSet(ck.getK());
				is.addItem(item);
				ck.addItemset(is);
			}
		}
		// sort candidate 1-itemset with condition is Class ItemSetComparator (implement
		// interface Comparator)
		ck.itemsets.sort(new ItemSetComparator());
		// update support for itemsets in candidate list
		ck.updateSupport(database);
		while (true) {
			// find L k-itemset from C k-itemset
			lk = ck.findLagreItemSets(minSup);
			if (lk == null)
				break;
			// Add all itemset in L k-itemset to result 
			for (ItemSet is : lk.itemsets) {
				result.addItemset(is);
			}
			// generate C (k+1)-Itemset from L k-itemset
			ck = lk.generateCItemSets();
			// update support for ck
			ck.updateSupport(database);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\Document\\[2017-2018]\\DataMining\\data.txt";
		Apriori apriori = new Apriori();
		apriori.getInstances(path);
		apriori.setMinSup(2);
		apriori.setMinConf(2);

		System.out.println("Database:" + Arrays.toString(apriori.database));
		ItemSets itemSets = apriori.apriori();
		System.out.println(itemSets);
	}
}
