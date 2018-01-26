/*
 * Decompiled with CFR 0_124.
 */
package a.c;

import a.c;
import a.d;
import java.io.Serializable;

public final class b
extends d
implements Serializable {
    private a.c.c a;

    public b() {
        this(a.c.c.d());
    }

    private b(a.c.c c2, a.b b2) {
        super(c.b, b2);
        this.a = c2;
    }

    private b(a.c.c c2) {
        this(c2, a.b.a());
    }

    @Override
    public final String b() {
        String string = this.a.c() ? "Mac OS X" : "macOS";
        if (this.a != null) {
            if (this.a.a() != null) {
                string = String.valueOf(string) + " " + this.a.a();
            }
            if (this.a.b() != null) {
                string = String.valueOf(string) + " " + this.a.b();
            }
        }
        return string;
    }

    @Override
    public final String c() {
        return this.b();
    }
}
