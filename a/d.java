/*
 * Decompiled with CFR 0_124.
 */
package a;

import a.a;
import a.b;
import a.c;

public abstract class d
extends a {
    private String a;

    public d(c c2, b b2) {
        super(c2, b2);
    }

    @Override
    public String c() {
        if (this.a == null) {
            return this.b();
        }
        return this.a;
    }

    public final void a(String string) {
        this.a = string;
    }
}
