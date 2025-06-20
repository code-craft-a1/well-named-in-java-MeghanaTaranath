package colorcoder;

public class ColorPair {
    private final MajorColor majorColor;
    private final MinorColor minorColor;

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
        return majorColor.name() + " " + minorColor.name();
    }
}