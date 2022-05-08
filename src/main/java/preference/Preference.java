package preference;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import util.DirsUtil;

/**
 * Created by yuchuan
 * DATE 2022/5/8
 * TIME 19:06
 */
public final class Preference {

   public static void loadPreference() {
      if (CMisc.isApplet())
         return;

      String u = DirsUtil.getUserDir();
      try {
         InputStreamReader read = new InputStreamReader(new FileInputStream(u + "/Property.x"), "UTF-8");//
         BufferedReader reader = new BufferedReader(read);
         CMisc.LoadProperty(reader);
      } catch (IOException ee) {
         CMisc.print(ee.getMessage());
      }

   }

}
