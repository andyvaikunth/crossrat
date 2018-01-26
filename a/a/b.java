/*
 * Decompiled with CFR 0_124.
 */
package a.a;

import crossrat.e;

public enum b {
    a("FreeBSD", new String[0]),
    b("OpenBSD", new String[0]),
    c("NetBSD", new String[0]),
    d("DragonFlyBSD", "DragonFly"),
    e("Unknown BSD", "BSD");
    
    private String f;
    private String[] g;

    private /* varargs */ b(String string2, String ... arrstring) {
        this.f = string2;
        this.g = arrstring;
    }

    public final String a() {
        return this.f;
    }

    public static b a(String string) {
        b[] arrb = b.values();
        int n = arrb.length;
        int n2 = 0;
        while (n2 < n) {
            b b2 = arrb[n2];
            Object object = b2;
            if (b2.f.toLowerCase().contains(string.toLowerCase())) {
                return b2;
            }
            object = b2;
            String[] arrstring = object.g;
            int n3 = arrstring.length;
            int n4 = 0;
            while (n4 < n3) {
                object = arrstring[n4];
                if (object.toLowerCase().contains(string.toLowerCase())) {
                    return b2;
                }
                ++n4;
            }
            ++n2;
        }
        return null;
    }

    public static b b() {
        return e.a(true);
    }
}
