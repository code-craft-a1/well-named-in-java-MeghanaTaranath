package colorcoder;
//Code that has no duplication
public final class NoDuplication {

    // Common interface for color enums
    interface Color {
        int getIndex();
    }

    // MajorColor enum implementing Color interface
    enum MajorColor implements Color {
        WHITE(0), RED(1), BLACK(2), YELLOW(3), VIOLET(4);

        private final int index;

        MajorColor(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    // MinorColor enum implementing Color interface
    enum MinorColor implements Color {
        BLUE(0), ORANGE(1), GREEN(2), BROWN(3), SLATE(4);

        private final int index;

        MinorColor(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    // Generic utility to convert index to enum
    static <T extends Enum<T> & Color> T fromIndex(Class<T> enumType, int index) {
        for (T color : enumType.getEnumConstants()) {
            if (color.getIndex() == index) {
                return color;
            }
        }
        return null;
    }

    final static String[] MajorColorNames = {
        "White", "Red", "Black", "Yellow", "Violet"
    };
    final static int numberOfMajorColors = MajorColorNames.length;

    final static String[] MinorColorNames = {
        "Blue", "Orange", "Green", "Brown", "Slate"
    };
    final static int numberOfMinorColors = MinorColorNames.length;

    static class ColorPair {
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

        // Note: fixed method name toString() for override
        @Override
        public String toString() {
            return MajorColorNames[majorColor.getIndex()] + " " + MinorColorNames[minorColor.getIndex()];
        }
    }

    static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor = fromIndex(MajorColor.class, zeroBasedPairNumber / numberOfMinorColors);
        MinorColor minorColor = fromIndex(MinorColor.class, zeroBasedPairNumber % numberOfMinorColors);
        return new ColorPair(majorColor, minorColor);
    }

    static int getPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * numberOfMinorColors + minor.getIndex() + 1;
    }

    static void testNumberToPair(int pairNumber, MajorColor expectedMajor, MinorColor expectedMinor) {
        ColorPair colorPair = getColorFromPairNumber(pairNumber);
        System.out.println("Got pair: " + colorPair);
        assert colorPair.getMajor() == expectedMajor;
        assert colorPair.getMinor() == expectedMinor;
    }

    static void testPairToNumber(MajorColor major, MinorColor minor, int expectedPairNumber) {
        int pairNumber = getPairNumberFromColor(major, minor);
        System.out.println("Got pair number: " + pairNumber);
        assert pairNumber == expectedPairNumber;
    }

    public static void main(String[] args) {
        testNumberToPair(4, MajorColor.WHITE, MinorColor.BROWN);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);

        testPairToNumber(MajorColor.BLACK, MinorColor.ORANGE, 12);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);
    }
}