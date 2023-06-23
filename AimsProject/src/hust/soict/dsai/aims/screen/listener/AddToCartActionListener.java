package hust.soict.dsai.aims.screen.listener;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToCartActionListener implements ActionListener {
    private final Cart cart;
    private final Media item;

    public AddToCartActionListener(Cart cart, Media item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cart.addMedia(item);
    }
}
