package se.sebpa096.tobhu543.ddd.ui.listeners;

import se.sebpa096.tobhu543.ddd.ui.components.Button;
import se.sebpa096.tobhu543.ddd.ui.components.Component;

public class ButtonMouseEvent extends MouseEvent {
    private Button button;

    public ButtonMouseEvent(Button button) {
        this.button = button;
    }

    @Override
    public void mouseDownLeft(Component sender, int x, int y) {
        if(button.getClickedImage() != null)
            button.setCurrentImage(button.getClickedImage());
    }

    @Override
    public void mouseUpLeft(Component sender, int x, int y) {
        button.setCurrentImage(button.getStandardImage());
    }

    @Override
    public void mouseIn(Component sender, int x, int y) {
        if(button.getHoverImage() != null)
            button.setCurrentImage(button.getHoverImage());
    }

    @Override
    public void mouseOut(Component sender, int x, int y) {
        super.mouseOut(sender, x, y);
        button.setCurrentImage(button.getStandardImage());
    }
}
