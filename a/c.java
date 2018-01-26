/*
 * Decompiled with CFR 0_124.
 */
package a;

import a.b.d;
import a.b.g;
import a.c.b;
import a.d.a;
import a.e;

public enum c {
    a("Windows", "win"),
    b("macOS", "mac"),
    c("Linux", "linux", "BSD", "Solaris", "solaris", "sunos"),
    d("Solaris", "solaris", "sunos"),
    e("BSD", new String[0]),
    f("unknown", "unknown");
    
    private static a.a g;
    private String h;
    private String[] i;

    private /* varargs */ c(String string2, String ... arrstring) {
        this.h = string2;
        this.i = arrstring;
    }

    public final String a() {
        return this.h;
    }

    public static a.a b() {
        boolean bl = true;
        a.a a2 = null;
        if (g == null) {
            boolean bl2;
            block16 : {
                boolean bl3;
                boolean bl4;
                a.a.b b2 = crossrat.e.a(true);
                if (b2 != null) {
                    a2 = new a.a.a(b2);
                }
                boolean bl5 = true;
                if (true) {
                    c c2 = c;
                    bl4 = System.getProperty("os.name").toLowerCase().contains(c2.i[0]);
                } else {
                    bl4 = false;
                }
                if (bl4) {
                    a2 = new g(crossrat.e.d());
                }
                if (a.c.a.a(true)) {
                    a2 = new b();
                }
                boolean bl6 = true;
                if (true) {
                    c c3 = a;
                    bl3 = System.getProperty("os.name").toLowerCase().contains(c3.i[0]);
                } else {
                    bl3 = false;
                }
                if (bl3) {
                    a2 = new a.e.a();
                }
                boolean bl7 = true;
                if (true) {
                    Object object = d;
                    String[] arrstring = object.i;
                    int n = arrstring.length;
                    int n2 = 0;
                    while (n2 < n) {
                        object = arrstring[n2];
                        if (System.getProperty("os.name").toLowerCase().contains((CharSequence)object)) {
                            bl2 = true;
                            break block16;
                        }
                        ++n2;
                    }
                }
                bl2 = false;
            }
            if (bl2) {
                a2 = new a();
            }
            if (a2 == null) {
                a2 = new e();
            }
            if (a2 instanceof a.d) {
                a.d d2 = (a.d)a2;
                d2.a(crossrat.e.c());
            }
            g = a2;
        } else {
            a2 = g;
        }
        return a2;
    }
}
