package util;

/**
 * Created by yuchuan
 * DATE 2022/5/6
 * TIME 23:05
 */
public final class DirsUtil {

    public static String getDir() {
        String userDirectory = getUserDir();
        String sp = getFileSeparator();
        return userDirectory + sp;
    }

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

}
