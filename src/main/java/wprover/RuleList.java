package wprover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import gprover.gib;
import gprover.rulers;

/**
 * Created by IntelliJ IDEA.
 * User: ye
 * Date: 2007-5-9
 * Time: 15:28:50
 * To change this template use File | Settings | File Templates.
 */
public class RuleList {

    private RuleList() {

    }

    final public static Vector<GddRule> sGddList = new Vector<>();
    final public static Vector<GddRule> sFullList = new Vector<>();

    public static Vector<GddRule> getAllGDDRules() {
        return new Vector<>(sGddList);
    }

    public static Vector<GddRule> getAllFullRules() {
        return new Vector<>(sFullList);
    }

    public static GddRule getGddRule(int n) {
        n--;
        if (n < 0 || n > sGddList.size())
            return null;
        return sGddList.get(n);
    }

    public static GddRule getFullRule(int n) {
        n--;
        if (n < 0 || n > sFullList.size())
            return null;
        return sFullList.get(n);
    }

    private static void loadRulersURL(URL base) {
//        try {
//            DataInputStream in = getStream(base, "fullrule");
//
//
//
//        } catch (IOException e) {
//        }
    }

    private static DataInputStream getStream(URL base, String file) {
        try {
            URL ul = new URL(base, file);
            URLConnection connection = ul.openConnection();
            connection.connect();
            InputStream inStream = connection.getInputStream();
            return new DataInputStream(inStream);
        } catch (IOException e) {
        }
        return null;
    }

    private static void loadRulers(String[] src, Vector<GddRule> vs, int type) {

        String s, s1, s2;
        s = s1 = s2 = null;

        int i = 0;
        int len = src.length;

        String t = src[i]; //reader.readLine().trim();

        int id = 1;

        while (t != null) {
            t = t.trim();
            if (t.length() != 0) {
                if (s != null && t.startsWith("*")) {
                    GddRule r = new GddRule(id++, s, s1, s2, type);
                    vs.add(r);
                    s = t;
                    s1 = s2 = null;
                } else {
                    if (s == null)
                        s = t;
                    else if (s1 == null)
                        s1 = t;
                    else s2 = t;
                }
            }
            if (i >= len - 1)
                break;

            t = src[++i];
        }
    }

    public static void loadRulers() {
        loadRulers(rulers.GDD, sGddList, 0);
        loadRulers(rulers.FULL, sFullList, 1);
    }

    public static void writeRulers(File file, File file2) {
        try {
            file2.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

            String t = reader.readLine();
            writer.write("package gprover\n");
            writer.write("public class fullrule{\n");

            while (t != null) {
                if (t.length() != 0)
                    writer.write('"' + t + '"' + ",\n");

                t = reader.readLine();
            }
            writer.write("}");
            writer.flush();
            writer.close();
            reader.close();

        } catch (IOException ee) {
        }

    }

    public static boolean getValue(int n) {
        return gib.RValue[n - 1];
    }

    public static void setValue(int n, boolean v) {
        gib.RValue[n - 1] = v;
    }

}
