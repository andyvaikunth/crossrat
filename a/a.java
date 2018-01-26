/*
 * Decompiled with CFR 0_124.
 */
package a;

import a.b;
import a.c;
import java.io.Serializable;

public abstract class a
implements Serializable {
    private c a;

    public a(c c2, b b2) {
        this.a = c2;
    }

    public final c a() {
        return this.a;
    }

    public abstract String b();

    public abstract String c();

    public final boolean d() {
        if (this.a != c.e && this.a != c.b && this.a != c.c && this.a != c.d) {
            return false;
        }
        return true;
    }
}
