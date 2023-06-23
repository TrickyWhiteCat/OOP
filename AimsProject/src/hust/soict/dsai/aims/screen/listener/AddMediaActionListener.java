package hust.soict.dsai.aims.screen.listener;

import hust.soict.dsai.aims.screen.addMedia.AddMediaToStoreScreen;
import hust.soict.dsai.aims.store.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMediaActionListener implements ActionListener {
    private Store store;
    public AddMediaActionListener(Store store) {
        this.store = store;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String type = e.getActionCommand().toLowerCase().substring(4);
        new AddMediaToStoreScreen(type, store);
    }
}
