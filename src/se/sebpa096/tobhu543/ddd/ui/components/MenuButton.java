package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;

public class MenuButton extends Button {

    public MenuButton(String label) throws SlickException{
        super(label,
                (Image)GlobalResources.getResource("buttonImage", "menuStandard"),
                (Image)GlobalResources.getResource("buttonImage", "menuHover"),
                (Image)GlobalResources.getResource("buttonImage", "menuClicked"));
    }
}
