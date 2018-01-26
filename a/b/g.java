/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b;
import a.c;
import a.d;
import java.io.Serializable;

public final class g
extends d
implements Serializable {
    private a.b.d a;

    private g(a.b.d d2, b b2) {
        super(c.c, b2);
        this.a = d2;
    }

    public g() {
        this(a.b.c.d(), b.a());
    }

    public g(a.b.d d2) {
        this(d2, b.a());
    }

    @Override
    public final String b() {
        Object object = this.a.a();
        object = object.c();
        if (this.a.b() != null) {
            object = String.valueOf(object) + " " + this.a.b();
        }
        return object;
    }
}
