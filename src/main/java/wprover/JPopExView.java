package wprover;

import java.io.IOException;

import util.DirsUtil;

/**
 * Created by IntelliJ IDEA.
 * User: Ye
 * Date: 2005-11-6
 * Time: 20:57:00
 * To change this template use File | Settings | File Templates.
 */
public class JPopExView extends JBaseDialog
{
    GExpert gxInstance;
    JExPanel panel;

    public JPopExView(GExpert exp)
    {
        super(exp.getFrame());
        gxInstance = exp;
        this.setSize(600, 400);
        panel = new JExPanel();
        this.add(panel);
    }

    public boolean loadRule(String s)
    {
        this.setTitle(s);

        String f = DirsUtil.getUserDir();
        String sp = DirsUtil.getFileSeparator();

        DrawProcess dp = new DrawProcess();
        dp.clearAll();
        try
        {
            boolean ss = dp.Load(f + sp +"rules" + sp + s);
            panel.setdrawP(dp);
        } catch (IOException ee)
        {
            CMisc.eprint(panel, "can not load rule: " + sp);
            return false;
        }
        return true;
    }


}
