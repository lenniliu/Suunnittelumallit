package AbstractFactory;

// Concrete Button for Style A
class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("+-------+");
        System.out.println("| " + text + " |");
        System.out.println("+-------+");
    }
}

// Concrete TextField for Style A
class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("+----------------+");
        System.out.println("| " + text + "          |");
        System.out.println("+----------------+");
    }
}

// Concrete Checkbox for Style A
class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ ] " + text);
    }
}

