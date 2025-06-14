package colorcoder;

public enum MinorColor implements Color {
    BLUE(0), ORANGE(1), GREEN(2), BROWN(3), SLATE(4);

    private final int index;

    MinorColor(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}