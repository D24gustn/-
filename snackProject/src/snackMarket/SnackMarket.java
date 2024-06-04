package snackMarket;

import java.io.IOException;

import snackMarket.controller.SnackMarketController;
import snackMarket.model.SnackStorage;
import snackMarket.model.Cart;
import snackMarket.view.ConsoleView;

public class SnackMarket {

	public static void main(String[] args) throws IOException {
		// model 생성
		SnackStorage snackStorage = new SnackStorage();
		Cart cart = new Cart();
		
		// view 생성
		ConsoleView view = new ConsoleView();
		
		// controller 생성 (model, view)
		SnackMarketController controller = new SnackMarketController(snackStorage, cart, view);
		controller.start();
		
		
	}

}