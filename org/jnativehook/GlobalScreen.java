/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook;

import java.io.File;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
import org.jnativehook.GlobalScreen$NativeHookThread;
import org.jnativehook.a;
import org.jnativehook.b.b;
import org.jnativehook.b.c;
import org.jnativehook.b.d;

public final class GlobalScreen {
    private static Logger a = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    private static GlobalScreen$NativeHookThread b;
    private static ExecutorService c;
    private static EventListenerList d;

    private GlobalScreen() {
    }

    public static void a(org.jnativehook.a.a a2) {
        if (a2 != null) {
            d.add(org.jnativehook.a.a.class, a2);
        }
    }

    public static void b(org.jnativehook.a.a a2) {
        if (a2 != null) {
            d.remove(org.jnativehook.a.a.class, a2);
        }
    }

    public static void a(b b2) {
        if (b2 != null) {
            d.add(b.class, b2);
        }
    }

    public static void b(b b2) {
        if (b2 != null) {
            d.remove(b.class, b2);
        }
    }

    public static void a(c c2) {
        if (c2 != null) {
            d.add(c.class, c2);
        }
    }

    public static void b(c c2) {
        if (c2 != null) {
            d.remove(c.class, c2);
        }
    }

    public static void a(d d2) {
        if (d2 != null) {
            d.add(d.class, d2);
        }
    }

    public static void b(d d2) {
        if (d2 != null) {
            d.remove(d.class, d2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a() {
        if (b == null || !b.isAlive()) {
            GlobalScreen$NativeHookThread globalScreen$NativeHookThread = GlobalScreen.b = new GlobalScreen$NativeHookThread();
            synchronized (b) {
                b.start();
                try {
                    b.wait();
                }
                catch (InterruptedException interruptedException) {
                    throw new org.jnativehook.c(interruptedException);
                }
                org.jnativehook.c c2 = b.a();
                if (c2 != null) {
                    throw c2;
                }
                // ** MonitorExit[var0] (shouldn't be in output)
                return;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void b() {
        if (GlobalScreen.c()) {
            GlobalScreen$NativeHookThread globalScreen$NativeHookThread = b;
            synchronized (globalScreen$NativeHookThread) {
                b.disable();
                try {
                    b.join();
                }
                catch (InterruptedException interruptedException) {
                    throw new org.jnativehook.c(interruptedException.getCause());
                }
                return;
            }
        }
    }

    public static boolean c() {
        if (b != null && b.isAlive()) {
            return true;
        }
        return false;
    }

    public static void a(ExecutorService executorService) {
        if (c != null) {
            c.shutdown();
        }
        c = executorService;
    }

    static {
        c = new a();
        d = new EventListenerList();
        Object object = System.getProperty("jnativehook.lib.name", "JNativeHook");
        try {
            System.loadLibrary((String)object);
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            object = System.getProperty("jnativehook.lib.locator", "org.jnativehook.DefaultLibraryLocator");
            try {
                object = Class.forName((String)object).asSubclass(org.jnativehook.d.class).newInstance();
                object = object.a();
                while (object.hasNext()) {
                    File file = (File)object.next();
                    if (!file.exists() || !file.isFile() || !file.canRead()) continue;
                    System.load(file.getPath());
                }
                return;
            }
            catch (Exception exception) {
                a.severe(exception.getMessage());
                throw new UnsatisfiedLinkError(exception.getMessage());
            }
        }
    }
}
