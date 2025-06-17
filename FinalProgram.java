package colorcoder;

public class FinalProgram {
    private static final int majorCount = 5, minorCount = 5;

    static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBased = pairNumber - 1;
        return new ColorPair(
            ColorUtil.fromIndex(MajorColor.class, zeroBased / minorCount),
            ColorUtil.fromIndex(MinorColor.class, zeroBased % minorCount)
        );
    }

    static int getPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * minorCount + minor.getIndex() + 1;
    }

    public static void main(String[] args) {
        System.out.println(getColorFromPairNumber(4));  // WHITE-BROWN
        System.out.println(getColorFromPairNumber(5));  // WHITE-SLATE
        System.out.println(getPairNumberFromColor(MajorColor.BLACK, MinorColor.ORANGE));  // 12
        System.out.println(getPairNumberFromColor(MajorColor.VIOLET, MinorColor.SLATE));  // 25

        System.out.printf("%-5s | %-10s | %-10s%n", "Pair", "Major", "Minor");
        for (int i = 1; i <= majorCount * minorCount; i++) {
            ColorPair pair = getColorFromPairNumber(i);
            System.out.printf("%-5d | %-10s | %-10s%n", i, pair.getMajor(), pair.getMinor());
        }
    }
}
