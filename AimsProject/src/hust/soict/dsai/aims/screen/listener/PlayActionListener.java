package hust.soict.dsai.aims.screen.listener;

import hust.soict.dsai.aims.media.Media;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayActionListener implements ActionListener {
    private final Media source;
    public PlayActionListener(Media source) {
        this.source = source;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        source.play();
    }
}
