package util;

import java.net.URL;

import wprover.GExpert;

/**
 * Created by yuchuan
 * DATE 2022/5/6
 * TIME 22:43
 */
public final class ResourceUtil {

   public static URL loadURLFromResource(String imgLocation) {
      return GExpert.class.getClassLoader().getResource(imgLocation);
   }


}
