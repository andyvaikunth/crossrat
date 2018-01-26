/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public final class e
extends AbstractExecutorService {
    private boolean a = true;

    public final void shutdown() {
        this.a = false;
    }

    public final List shutdownNow() {
        this.a = false;
        return new ArrayList(0);
    }

    public final boolean isShutdown() {
        if (!this.a) {
            return true;
        }
        return false;
    }

    public final boolean isTerminated() {
        if (!this.a) {
            return true;
        }
        return false;
    }

    public final boolean awaitTermination(long l, TimeUnit timeUnit) {
        return true;
    }

    public final void execute(Runnable runnable) {
        EventQueue.invokeLater(runnable);
    }
}
