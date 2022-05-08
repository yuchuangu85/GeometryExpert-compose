package wprover;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JComboBox;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2005-3-4
 * Time: 14:25:06
 * To change this template use File | Settings | File Templates.
 */
public class CCoBox extends JComboBox<Integer> {
    private static final Vector<CCoBox> instanceList = new Vector<>();
    int defaultIndex = 0;

    public static CCoBox CreateAInstance() {
        Integer[] intArray = new Integer[DrawData.getColorCounter() + 1];
        for (int i = 0; i <= DrawData.getColorCounter(); i++) {
            intArray[i] = i;
        }
        CCoBox cb = new CCoBox(intArray);

        cb.setMaximumRowCount(30);
        cb.setPreferredSize(new Dimension(40, 20));
        ColorComboRender render = new ColorComboRender(0, 100, 20);
        render.setPreferredSize(new Dimension(40, 20));
        cb.setRenderer(render);
        instanceList.add(cb);
        return cb;
    }

    private CCoBox(final Integer[] items) {
        super(items);
    }

    public void setSelectedIndex(int index) {
        ((ColorComboRender) super.getRenderer()).index = index;
        super.setSelectedIndex(index);
    }

    public void setDefaultIndex(int index) {
        defaultIndex = index;
    }

    public static void reGenerateAll() {
        for (CCoBox cCoBox : instanceList) {
            int co = DrawData.getColorCounter();
            int n = cCoBox.getItemCount();

            if (co >= n)
                for (int j = n; j <= co; j++) {
                    cCoBox.addItem(j);
                }
        }
    }

    public static void resetAll() {
        DrawData.reset();

        for (CCoBox cb : instanceList) {
            cb.setSelectedIndex(cb.defaultIndex);
            int num = DrawData.getColorCounter();
            for (int j = num + 1; j < cb.getItemCount(); j++)
                cb.removeItemAt(j);
        }
    }

}
