/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook;

import java.util.concurrent.ThreadFactory;

final class b
implements ThreadFactory {
    b() {
    }

    public final Thread newThread(Runnable runnable) {
        runnable = new Thread(runnable);
        runnable.setName("JNativeHook Dispatch Thread");
        runnable.setDaemon(true);
        return runnable;
    }
}
