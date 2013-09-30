package se.sebpa096.tobhu543.ddd.ui.components;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.sebpa096.tobhu543.ddd.resources.GlobalResources;
import se.sebpa096.tobhu543.ddd.ui.UI;
import se.sebpa096.tobhu543.ddd.ui.listeners.ButtonMouseEvent;
import se.sebpa096.tobhu543.ddd.ui.listeners.IMouseListener;
import se.sebpa096.tobhu543.ddd.ui.listeners.MouseEvent;

public class Button extends Component implements IMouseListener {
    private Image standardImage = null;
    private Image hoverImage = null;
    private Image clickedImage = null;
    private Image currentImage = null;
    private String label;
    private MouseEvent mouseEvent;

    public Button(String label, Image standardImage) {
        super();
        this.label = label;
        this.standardImage = standardImage;
        this.currentImage = standardImage;
        this.setWidth(standardImage.getWidth());
        this.setHeight(standardImage.getHeight());
        this.mouseEvent = new ButtonMouseEvent(this);
    }

    public Button(String label, Image standardImage, Image hoverImage, Image clickedImage) {
        this(label, standardImage);
        this.hoverImage = hoverImage;
        this.clickedImage = clickedImage;
    }

    public Button( String label) throws SlickException {
        this(label, (Image)GlobalResources.getResource("buttonImage", "defaultStandard"));
        this.hoverImage = (Image)GlobalResources.getResource("buttonImage", "defaultHover");
        this.clickedImage = (Image)GlobalResources.getResource("buttonImage", "defaultClicked");
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Image getStandardImage() {
        return standardImage;
    }

    public void setStandardImage(Image standardImage) {
        this.standardImage = standardImage;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    public void setHoverImage(Image hoverImage) {
        this.hoverImage = hoverImage;
    }

    public Image getClickedImage() {
        return clickedImage;
    }

    public void setClickedImage(Image clickedImage) {
        this.clickedImage = clickedImage;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    @Override
    public void mouseEvent(int x, int y, boolean leftClick, boolean rightClick) {
        this.mouseEvent.mouseEvent(this, x - this.getWidth(), y - this.getHeight(), leftClick, rightClick);
    }

    public MouseEvent getMouseEvent() {
        return mouseEvent;
    }

    public void setMouseEvent(MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
    }
}
