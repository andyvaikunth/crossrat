/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.h;
import java.io.File;

public final class f
extends h {
    private File a;

    public f(String string) {
        this(new File(string));
    }

    private f(File file) {
        this.a = file;
    }

    @Override
    public final boolean a() {
        return this.a.exists();
    }
}
