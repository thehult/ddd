package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;

public class MenuButton extends Button {

    public MenuButton(UI parentUI, String label) throws SlickException{
        super(parentUI, label,
                (Image)GlobalResources.getResource("buttonImages", "menuStandard"),
                (Image)GlobalResources.getResource("buttonImages", "menuHover"),
                (Image)GlobalResources.getResource("buttonImages", "menuClicked"));
    }
}
