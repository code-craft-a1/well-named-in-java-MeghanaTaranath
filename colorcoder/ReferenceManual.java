package colorcoder;

public class ReferenceManual {
    public static void printManual() {
        int pairNumber = 1;
        for (MajorColor major : MajorColor.values()) {
            for (MinorColor minor : MinorColor.values()) {
                ColorPair pair = new ColorPair(major, minor);
                System.out.printf("%2d - %s\n", pairNumber++, pair);
            }
        }
    }
}
