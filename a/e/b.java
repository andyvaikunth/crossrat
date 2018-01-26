/*
 * Decompiled with CFR 0_124.
 */
package a.e;

public enum b {
    a("Unknown Windows"),
    b("Windows 2000"),
    c("Windows XP"),
    d("Windows 2003"),
    e("Windows Vista"),
    f("Windows Server 2008"),
    g("Windows 7"),
    h("Windows 8.1"),
    i("Windows 8"),
    j("Windows Server 2012"),
    k("Windows 10");
    
    private String l;

    private b(String string2) {
        this.l = string2;
    }

    public final String a() {
        return this.l;
    }

    public static b b() {
        String string = System.getProperty("os.name");
        b[] arrb = b.values();
        int n = arrb.length;
        int n2 = 0;
        while (n2 < n) {
            b b2 = arrb[n2];
            if (b2 != a) {
                b b3 = b2;
                if (b3.l.equalsIgnoreCase(string)) {
                    return b2;
                }
            }
            ++n2;
        }
        return a;
    }
}
