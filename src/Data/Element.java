package Data;

public record Element(int row, int column, int number) {

    public Element {
        if (row < 0 || row > 8 || column < 0 || column > 8 || number < 1 || number > 9) {
            throw new IllegalArgumentException("Invalid element values");
        }
    }

    public Element getElement() {
        return new Element(row, column, number);
    }


}
