package AbstractFactory;

// Concrete Button for Style B
class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("/*******\\");
        System.out.println("* " + text + " *");
        System.out.println("\\*******/");
    }
}

// Concrete TextField for Style B
class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("/----------------\\");
        System.out.println("| " + text + "            |");
        System.out.println("\\----------------/");
    }
}

// Concrete Checkbox for Style B
class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("< > " + text);
    }
}

