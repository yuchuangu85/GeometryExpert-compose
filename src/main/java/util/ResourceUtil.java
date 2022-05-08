package util;

import java.net.URL;

import javax.swing.ImageIcon;

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

   public static ImageIcon createImageIcon(String path) {
      URL imgURL = loadURLFromResource(path);
      if (imgURL == null) {
         return null;
      }
      return new ImageIcon(imgURL);
   }

}
