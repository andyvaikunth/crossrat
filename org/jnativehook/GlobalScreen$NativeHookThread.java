/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook;

import org.jnativehook.c;

class GlobalScreen$NativeHookThread
extends Thread {
    private c a;

    public GlobalScreen$NativeHookThread() {
        this.setName("JNativeHook Hook Thread");
        this.setDaemon(false);
        this.setPriority(10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        this.a = null;
        try {
            this.enable();
        }
        catch (c c2) {
            this.a = c2;
        }
        GlobalScreen$NativeHookThread globalScreen$NativeHookThread = this;
        synchronized (globalScreen$NativeHookThread) {
            this.notifyAll();
            return;
        }
    }

    public final c a() {
        return this.a;
    }

    private native void enable();

    public native void disable();
}
