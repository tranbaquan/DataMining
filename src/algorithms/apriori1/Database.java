package algorithms.apriori1;

import java.io.*;
/**
 * 
 * @author TranBaQuan
 *
 */
public class Database {
	/**
	 * Read data from file
	 * @param sf
	 * @return
	 * @throws IOException
	 */
	public Transaction[] loadData(String sf) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(sf);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			int i = 0;
			int size = Integer.parseInt(br.readLine());
			Transaction[] transactions = new Transaction[size];
			while ((line = br.readLine()) != null) {
				Transaction transaction = new Transaction(i);
				String[] value = line.split(" ");
				for (int j = 0; j < value.length; j++) {
					transaction.addItem(Integer.parseInt(value[j]));
				}
				transactions[i] = transaction;
				i++;
			}
			br.close();
			return transactions;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not exists!");
		}
		return null;
	}
}
