/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f {
    private static final boolean a;
    private static Method b;
    private static Method c;
    private static Object d;
    private static Object e;

    public static boolean a(File object) {
        try {
            object = c.invoke(object, new Object[0]);
            object = (Boolean)b.invoke(null, object);
            return object.booleanValue();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
    }

    public static boolean a() {
        return a;
    }

    static {
        boolean bl = true;
        try {
            Object object = Thread.currentThread().getContextClassLoader();
            Class class_ = object.loadClass("java.nio.file.Files");
            Class class_2 = object.loadClass("java.nio.file.Path");
            Class class_3 = object.loadClass("java.nio.file.attribute.FileAttribute");
            object = object.loadClass("java.nio.file.LinkOption");
            b = class_.getMethod("isSymbolicLink", class_2);
            class_.getMethod("delete", class_2);
            class_.getMethod("readSymbolicLink", class_2);
            e = Array.newInstance(class_3, 0);
            class_.getMethod("createSymbolicLink", class_2, class_2, e.getClass());
            d = Array.newInstance(object, 0);
            class_.getMethod("exists", class_2, d.getClass());
            c = File.class.getMethod("toPath", new Class[0]);
            class_2.getMethod("toFile", new Class[0]);
        }
        catch (ClassNotFoundException classNotFoundException) {
            bl = false;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            bl = false;
        }
        a = bl;
    }
}
