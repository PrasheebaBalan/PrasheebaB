
interface Text {
    String getText();
}


class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    public String getText() {
        return decoratedText.getText();
    }
}

class BoldText extends TextDecorator {
    public BoldText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<b>" + decoratedText.getText() + "</b>";
    }
}

class ItalicText extends TextDecorator {
    public ItalicText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<i>" + decoratedText.getText() + "</i>";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, world!");
        Text boldText = new BoldText(text);
        Text italicText = new ItalicText(text);
        Text boldItalicText = new BoldText(new ItalicText(text));

        System.out.println("Plain Text: " + text.getText());
        System.out.println("Bold Text: " + boldText.getText());
        System.out.println("Italic Text: " + italicText.getText());
        System.out.println("Bold and Italic Text: " + boldItalicText.getText());
    }
}
