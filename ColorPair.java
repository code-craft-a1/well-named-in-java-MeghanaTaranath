package colorcoder;

public class ColorPair {
    private final MajorColor majorColor;
    private final MinorColor minorColor;

    private static final String[] MajorColorNames = {
        "White", "Red", "Black", "Yellow", "Violet"
    };
    private static final String[] MinorColorNames = {
        "Blue", "Orange", "Green", "Brown", "Slate"
    };

    public ColorPair(MajorColor major, MinorColor minor) {
        this.majorColor = major;
        this.minorColor = minor;
    }

    public MajorColor getMajor() {
        return majorColor;
    }

    public MinorColor getMinor() {
        return minorColor;
    }

    @Override
    public String toString() {
        return MajorColorNames[majorColor.getIndex()] + " " + MinorColorNames[minorColor.getIndex()];
    }
}
