package AbstractFactory;

// Abstract Factory for UI Elements
abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}

// Factory for Style A
class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}

// Factory for Style B
class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}
