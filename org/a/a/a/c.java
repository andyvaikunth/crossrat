/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a;

import java.io.File;
import java.io.FileFilter;

final class c
implements FileFilter {
    private /* synthetic */ File a;

    c(File file) {
        this.a = file;
    }

    @Override
    public final boolean accept(File file) {
        return file.equals(this.a);
    }
}
