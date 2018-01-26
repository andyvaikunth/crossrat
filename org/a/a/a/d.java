/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a;

import java.io.File;

public final class d {
    private static final char a;

    static boolean a() {
        if (a == '\\') {
            return true;
        }
        return false;
    }

    static {
        Character.toString('.');
        a = File.separatorChar;
    }
}
