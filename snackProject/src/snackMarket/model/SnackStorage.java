package snackMarket.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SnackStorage {
	ArrayList<Snack> snackList = new ArrayList<>();
	final int MAX_QUANTITY = 10;
	private String snackFilename = "snacklist.txt";
	private int lastId;
	private boolean isSaved;
	
	public SnackStorage() throws IOException {
		loadSnackListFromFile();
		generateLastId();
		isSaved = true;
	}
	
	private void generateLastId() {
		lastId = 0;
		for (Snack snack : snackList) {
			int id = snack.getSnackId();
			if (id > lastId) lastId = id;
		}
	}

	private void loadSnackListFromFile() throws IOException {
		FileReader fr;
		try {
			fr = new FileReader(snackFilename);
			BufferedReader br = new BufferedReader(fr);
			String idStr;
			while ((idStr = br.readLine()) != null && !idStr.equals("")) {
				int id = Integer.parseInt(idStr);
				String title = br.readLine();
				String author = br.readLine();
				String publisher = br.readLine();
				int price = Integer.parseInt(br.readLine());
				snackList.add(new Snack(id, title, author, publisher, price));
			}
			fr.close();
			br.close();

		} catch (FileNotFoundException |  NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getNumSnacks() {
		return snackList.size();
	}

	public String getSnackInfo(int i) {
		return snackList.get(i).toString();
	}

	public boolean isValidSnack(int snackId) {
		for (Snack snack : snackList) {
			if (snack.getSnackId() == snackId) return true;
		}
		return false;
	}

	public Snack getSnackById(int snackId) {
		for (Snack snack : snackList) {
			if (snack.getSnackId() == snackId)
				return snack;
		}
		return null;
	}

	public int getMaxQuantity() {
		return MAX_QUANTITY;
	}

	public boolean isEmpty() {
		return snackList.size() == 0;
	}

	public void deleteItem(int snackId) {
		snackList.remove(getSnackById(snackId));
		isSaved = false;
	}

	public void addSnack(String title, String author, String publisher, int price) {
		
		Snack snack = new Snack(++lastId, title, author, publisher, price);
		snackList.add(snack);
		isSaved = false;
	}

	public boolean isSaved() {
		return isSaved;
	}

	public void saveSnackList2File() {

		try {
			FileWriter fw = new FileWriter(snackFilename);
			for (Snack snack : snackList) {
				fw.write(snack.getSnackId() + "\n");
				fw.write(snack.getTitle() + "\n");
				fw.write(snack.getAuthor() + "\n");
				fw.write(snack.getPublisher() + "\n");
				fw.write(snack.getPrice() + "\n");
			}
			fw.close();
			isSaved = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}