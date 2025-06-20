package colorcoder;

public class ColorUtils {
    public static <T extends Enum<T> & IndexedColor> T fromIndex(T[] values, int index) {
        for (T color : values) {
            if (color.getIndex() == index) {
                return color;
            }
        }
        throw new IllegalArgumentException("Invalid color index: " + index);
    }
}