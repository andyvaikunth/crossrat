/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.c;
import java.io.Serializable;

public final class d
implements Serializable {
    private c a;
    private String b;

    public d(c c2) {
        this.a = c2;
    }

    public final c a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
    }
}
