package se.sebpa096.tobhu543.ddd.ui.components;

import se.sebpa096.tobhu543.ddd.ui.UI;

public class Label extends Component {
    private String text;

    public Label(String text) {
        this(text, 0, 0);
    }

    public Label(String text, int x, int y) {
        super();
        this.setText(text);
        this.setX(x);
        this.setY(y);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
