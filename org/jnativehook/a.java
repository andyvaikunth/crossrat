/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jnativehook.b;

public final class a
extends ThreadPoolExecutor {
    public a() {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new b());
    }
}
