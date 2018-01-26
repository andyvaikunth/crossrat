/*
 * Decompiled with CFR 0_124.
 */
package a.c;

public enum c {
    a("Cheetah", "10.0", true),
    b("Puma", "10.1", true),
    c("Jaguar", "10.2", true),
    d("Panther", "10.3", true),
    e("Tiger", "10.4", true),
    f("Leopard", "10.5", true),
    g("Snow Leopard", "10.6", true),
    h("Lion", "10.7", true),
    i("Mountain Lion", "10.8", true),
    j("Mavericks", "10.9", true),
    k("Yosemite", "10.10", true),
    l("El Capitan", "10.11", true),
    m("Sierra", "10.12");
    
    private String n;
    private String o;
    private boolean p;

    private c(String string2, String string3) {
        this(string2, string3, false);
    }

    private c(String string2, String string3, boolean bl) {
        this.n = string2;
        this.o = string3;
        this.p = bl;
    }

    public final String a() {
        return this.n;
    }

    public final String b() {
        return this.o;
    }

    public final boolean c() {
        return this.p;
    }

    public static c d() {
        String string = System.getProperty("os.version");
        c[] arrc = c.values();
        int n = arrc.length;
        int n2 = 0;
        while (n2 < n) {
            block4 : {
                c c2;
                block3 : {
                    c c3 = c2 = arrc[n2];
                    if (string.startsWith(c3.o)) break block3;
                    c3 = c2;
                    if (!c3.n.toLowerCase().contains(string.toLowerCase())) break block4;
                }
                return c2;
            }
            ++n2;
        }
        return null;
    }
}
