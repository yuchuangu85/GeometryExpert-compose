package util;

/**
 * Created by yuchuan
 * DATE 2022/5/6
 * TIME 23:05
 */
public final class DirsUtil {

    public static String getDir() {
        String user_directory = getUserDir();
        String sp = getFileSeparator();
        return user_directory + sp;
    }

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

}
