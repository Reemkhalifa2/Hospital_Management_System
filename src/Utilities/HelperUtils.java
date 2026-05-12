package Utilities;

public class HelperUtils {
    public static Boolean isNull(Object obj){
        return obj == null;
    }

    public static Boolean isNull(String str){
        return str == null || str.isEmpty() ;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }


}
