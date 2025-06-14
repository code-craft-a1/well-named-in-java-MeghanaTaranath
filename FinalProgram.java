package colorcoder;

public final class FinalProgram {

    private static final int numberOfMajorColors = 5;
    private static final int numberOfMinorColors = 5;

    static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor = ColorUtil.fromIndex(MajorColor.class, zeroBasedPairNumber / numberOfMinorColors);
        MinorColor minorColor = ColorUtil.fromIndex(MinorColor.class, zeroBasedPairNumber % numberOfMinorColors);
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
    
    static void printReferenceManual() {
        final int totalPairs = numberOfMajorColors * numberOfMinorColors;
        System.out.println("Color Code Reference Manual:");
        System.out.println("-----------------------------");
        System.out.printf("%-5s | %-10s | %-10s%n", "Pair", "Major", "Minor");
        System.out.println("-----------------------------");

        for (int i = 1; i <= totalPairs; i++) {
            ColorPair colorPair = getColorFromPairNumber(i);
            System.out.printf("%-5d | %-10s | %-10s%n", i,
                    colorPair.getMajor().name(), colorPair.getMinor().name());
        }

        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        testNumberToPair(4, MajorColor.WHITE, MinorColor.BROWN);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);
        testPairToNumber(MajorColor.BLACK, MinorColor.ORANGE, 12);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);
        printReferenceManual();
    }
}