package colorcoder;

public class ColorUtil {
    // Generic method to get enum from index
    public static <T extends Enum<T> & Color> T fromIndex(Class<T> enumType, int index) {
        for (T color : enumType.getEnumConstants()) {
            if (color.getIndex() == index) {
                return color;
            }
        }
        return null;
    }
}