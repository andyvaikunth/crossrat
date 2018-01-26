/*
 * Decompiled with CFR 0_124.
 */
package a.a;

import a.b;
import a.c;
import a.d;
import java.io.Serializable;

public final class a
extends d
implements Serializable {
    private a.a.b a;

    private a(a.a.b b2, b b3) {
        super(c.e, b3);
        this.a = b2;
    }

    public a() {
        this(a.a.b.b(), b.a());
    }

    public a(a.a.b b2) {
        this(b2, b.a());
    }

    @Override
    public final String b() {
        return this.a.a();
    }
}
