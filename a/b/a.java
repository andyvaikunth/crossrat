/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.h;
import crossrat.e;
import java.util.Iterator;

public final class a
extends h {
    private String[] a;
    private String b;

    public a(String[] arrstring, String string) {
        this.a = arrstring;
        this.b = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean a() {
        try {
            Object object = e.a(this.a);
            Iterator iterator = object.iterator();
            do {
                if (iterator.hasNext()) continue;
                return false;
            } while (!(object = (String)iterator.next()).toLowerCase().contains(this.b.toLowerCase()));
            return true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        return false;
    }
}
