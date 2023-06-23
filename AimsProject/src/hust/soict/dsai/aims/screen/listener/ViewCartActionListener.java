package hust.soict.dsai.aims.screen.listener;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.cart.CartScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCartActionListener implements ActionListener {
    private final Cart cart;
    public ViewCartActionListener(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CartScreen cartScreen = new CartScreen(cart);
        cartScreen.setSize(1024, 720);
    }
}
