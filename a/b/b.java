/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.h;
import crossrat.e;

public final class b
extends h {
    private String a;

    public b(String string) {
        this.a = string;
    }

    @Override
    public final boolean a() {
        try {
            e.a(new String[]{this.a});
            return true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return false;
        }
    }
}
