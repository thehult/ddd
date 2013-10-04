package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.resources.ButtonImageResources;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;

public class MenuButton extends Button {

    public MenuButton(String label) throws SlickException{
        super(label,
                (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.MENU_STANDARD),
                (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.MENU_HOVER),
                (Image)GlobalResources.getResource(GlobalResources.BUTTON_RESOURCES, ButtonImageResources.MENU_CLICKED));
    }
}
