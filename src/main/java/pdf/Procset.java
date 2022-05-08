package pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/**
 * Created by yuchuan
 * DATE 2022/5/8
 * TIME 21:00
 */
public class Procset extends PDFObject {
    private final Vector<String> set;

    /**
     * Creates a new procset object.
     */
    public Procset() {
        super(null);
        set = new Vector<>();

        // Our default procset (use addElement not add, as we dont want a
        // leading space)
        set.addElement("/PDF");
    }

    /**
     * @param proc Entry to add to the procset
     */
    public void add(String proc) {
        set.addElement(" " + proc);
    }

    /**
     * @param os OutputStream to send the object to
     * @throws IOException on error
     */
    public void write(OutputStream os) throws IOException {
        // Write the object header
        //writeStart(os);

        os.write(Integer.toString(objser).getBytes());
        os.write(" 0 obj\n".getBytes());

        // now the objects body
        os.write("[".getBytes());
        for (String str : set)
            os.write(str.getBytes());
        os.write("]\n".getBytes());

        // finish off with its footer
        //writeEnd(os);
        os.write("endobj\n".getBytes());
    }
}
