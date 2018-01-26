/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook.example;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.jnativehook.example.NativeHookDemo;

final class b
extends Formatter {
    private b(NativeHookDemo nativeHookDemo) {
    }

    public final String format(LogRecord logRecord) {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append(new Date(logRecord.getMillis())).append(" ").append(logRecord.getLevel().getLocalizedName()).append(":\t").append(this.formatMessage(logRecord));
        if (logRecord.getThrown() != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                logRecord.getThrown().printStackTrace(printWriter);
                printWriter.close();
                stringBuilder.append(stringWriter.toString());
                stringWriter.close();
            }
            catch (Exception exception) {}
        }
        return stringBuilder.toString();
    }

    /* synthetic */ b(NativeHookDemo nativeHookDemo, byte by) {
        this(nativeHookDemo);
    }
}
