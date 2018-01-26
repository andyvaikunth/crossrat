/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.a.a.a.a.a;

public final class e {
    public static /* varargs */ void a(Closeable ... arrcloseable) {
        for (int i = 0; i < 4; ++i) {
            Closeable closeable = arrcloseable[i];
            try {
                if (closeable == null) continue;
                closeable.close();
                continue;
            }
            catch (IOException iOException) {}
        }
    }

    static {
        Writer writer = new a(4);
        writer = new PrintWriter(writer);
        writer.println();
        writer.close();
    }
}
