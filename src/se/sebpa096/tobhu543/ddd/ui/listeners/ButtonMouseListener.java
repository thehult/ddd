package se.sebpa096.tobhu543.ddd.ui.listeners;

import se.sebpa096.tobhu543.ddd.ui.components.Button;
import se.sebpa096.tobhu543.ddd.ui.components.Component;

public class ButtonMouseListener extends MouseListener {
    Button button;

    public ButtonMouseListener(Component sender) {
        super(sender);
        button = (Button)sender;
    }

    @Override
    public void mouseDownLeft(Component sender, float x, float y) {
        if(button.getClickedImage() != null)
            button.setCurrentImage(button.getClickedImage());
    }

    @Override
    public void mouseUpLeft(Component sender, float x, float y) {
        button.setCurrentImage(button.getStandardImage());
    }

    @Override
    public void mouseIn(Component sender, float x, float y) {
        if(button.getHoverImage() != null)
            button.setCurrentImage(button.getHoverImage());
    }

    @Override
    public void mouseOut(Component sender, float x, float y) {
        button.setCurrentImage(button.getStandardImage());
    }
}
