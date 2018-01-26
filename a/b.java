/*
 * Decompiled with CFR 0_124.
 */
package a;

public enum b {
    a("x86", "i386", "i486", "i586", "i686"),
    b("x86_64", "amd64", "k8"),
    c("ARM"),
    d("Unknown");
    
    private String[] e;

    private /* varargs */ b(String ... arrstring) {
        this.e = arrstring;
    }

    public static b a() {
        String string = System.getProperty("os.arch");
        b[] arrb = b.values();
        int n = arrb.length;
        int n2 = 0;
        while (n2 < n) {
            b b2 = arrb[n2];
            Object object = b2;
            String[] arrstring = b2.e;
            int n3 = arrstring.length;
            int n4 = 0;
            while (n4 < n3) {
                object = arrstring[n4];
                if (string.equalsIgnoreCase((String)object)) {
                    return b2;
                }
                ++n4;
            }
            ++n2;
        }
        return d;
    }
}
