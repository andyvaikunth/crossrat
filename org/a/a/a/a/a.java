/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a.a;

import java.io.Serializable;
import java.io.Writer;

public final class a
extends Writer
implements Serializable {
    private final StringBuilder a;

    public a() {
        this.a = new StringBuilder();
    }

    public a(int n) {
        this.a = new StringBuilder(4);
    }

    @Override
    public final Writer append(char c) {
        this.a.append(c);
        return this;
    }

    @Override
    public final Writer append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    @Override
    public final Writer append(CharSequence charSequence, int n, int n2) {
        this.a.append(charSequence, n, n2);
        return this;
    }

    @Override
    public final void close() {
    }

    @Override
    public final void flush() {
    }

    @Override
    public final void write(String string) {
        if (string != null) {
            this.a.append(string);
        }
    }

    @Override
    public final void write(char[] arrc, int n, int n2) {
        if (arrc != null) {
            this.a.append(arrc, n, n2);
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
