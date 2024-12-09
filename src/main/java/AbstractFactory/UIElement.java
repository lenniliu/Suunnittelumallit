package AbstractFactory;

// Abstract base class for UI Elements
abstract class UIElement {
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}

// Button abstract class
abstract class Button extends UIElement {
    public Button(String text) {
        super(text);
    }
}

// TextField abstract class
abstract class TextField extends UIElement {
    public TextField(String text) {
        super(text);
    }
}

// Checkbox abstract class
abstract class Checkbox extends UIElement {
    public Checkbox(String text) {
        super(text);
    }
}

