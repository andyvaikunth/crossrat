/*
 * Decompiled with CFR 0_124.
 */
package org.a.a.a;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.a.a.a.a;
import org.a.a.a.c;
import org.a.a.a.d;
import org.a.a.a.e;
import org.a.a.a.f;

public final class b {
    private static BigInteger a = BigInteger.valueOf(1024L);
    private static BigInteger b = a.multiply(a);
    private static BigInteger c = a.multiply(b);
    private static BigInteger d = a.multiply(c);
    private static BigInteger e = a.multiply(d);
    private static BigInteger f;

    public static void a(File file, File file2) {
        boolean bl = true;
        File file3 = file;
        b.d(file3, file2);
        if (file3.isDirectory()) {
            throw new IOException("Source '" + file3 + "' exists but is a directory");
        }
        if (file3.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file3 + "' and destination '" + file2 + "' are the same");
        }
        File file4 = file2.getParentFile();
        if (file4 != null && !file4.mkdirs() && !file4.isDirectory()) {
            throw new IOException("Destination '" + file4 + "' directory cannot be created");
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        b.a(file3, file2, true);
    }

    private static void a(File file, File file2, boolean bl) {
        long l;
        long l2;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        try {
            long l3;
            long l4;
            long l5;
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            fileChannel = fileInputStream.getChannel();
            fileChannel2 = fileOutputStream.getChannel();
            l = fileChannel.size();
            for (l2 = 0L; l2 < l && (l4 = fileChannel2.transferFrom(fileChannel, l2, l5 = (l3 = l - l2) > 31457280L ? 31457280L : l3)) != 0L; l2 += l4) {
            }
        }
        catch (Throwable throwable) {
            e.a(fileChannel2, fileOutputStream, fileChannel, fileInputStream);
            throw throwable;
        }
        e.a(fileChannel2, fileOutputStream, fileChannel, fileInputStream);
        l = file.length();
        l2 = file2.length();
        if (l != l2) {
            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + l + " Actual: " + l2);
        }
        if (bl) {
            file2.setLastModified(file.lastModified());
        }
    }

    private static void c(File file, File file2) {
        File[] arrfile;
        File file3 = file;
        boolean bl = true;
        File file4 = file3;
        boolean bl2 = true;
        file4 = null;
        file4 = file3;
        b.d(file3, file2);
        if (!file4.isDirectory()) {
            throw new IOException("Source '" + file4 + "' exists but is not a directory");
        }
        if (file4.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file4 + "' and destination '" + file2 + "' are the same");
        }
        ArrayList<String> arrayList = null;
        if (file2.getCanonicalPath().startsWith(file4.getCanonicalPath()) && (arrfile = file4.listFiles()) != null && arrfile.length > 0) {
            arrayList = new ArrayList<String>(arrfile.length);
            for (File file5 : arrfile) {
                file5 = new File(file2, file5.getName());
                arrayList.add(file5.getCanonicalPath());
            }
        }
        b.a(file4, file2, null, bl2, arrayList);
    }

    private static void d(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean bl, List list) {
        File[] arrfile = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (arrfile == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : arrfile) {
            File file4 = new File(file2, file3.getName());
            if (list != null && list.contains(file3.getCanonicalPath())) continue;
            if (file3.isDirectory()) {
                b.a(file3, file4, fileFilter, bl, list);
                continue;
            }
            b.a(file3, file4, bl);
        }
        if (bl) {
            file2.setLastModified(file.lastModified());
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void b(File var0) {
        block10 : {
            block12 : {
                block11 : {
                    block9 : {
                        if (!var0.exists()) {
                            return;
                        }
                        var1_1 = var0;
                        if (!f.a()) break block9;
                        v0 = f.a((File)var1_1);
                        break block10;
                    }
                    if (var1_1 == null) {
                        throw new NullPointerException("File must not be null");
                    }
                    if (!d.a()) break block11;
                    v0 = false;
                    break block10;
                }
                if (var1_1.getParent() == null) {
                    var2_2 = var1_1;
                } else {
                    var2_2 = var1_1.getParentFile().getCanonicalFile();
                    var2_2 = new File((File)var2_2, var1_1.getName());
                }
                if (!var2_2.getCanonicalFile().equals(var2_2.getAbsoluteFile())) break block12;
                if (var1_1.exists()) ** GOTO lbl-1000
                var2_2 = (var1_1 = var1_1.getCanonicalFile()).getParentFile();
                if (var2_2 == null || !var2_2.exists()) {
                    v0 = false;
                } else if ((var1_1 = var2_2.listFiles(new c((File)var1_1))) != null && var1_1.length > 0) {
                    v0 = true;
                } else lbl-1000: // 2 sources:
                {
                    v0 = false;
                }
                break block10;
            }
            v0 = true;
        }
        if (!v0) {
            b.c((File)var0);
        }
        if (var0.delete() != false) return;
        var0 = "Unable to delete directory " + var0 + ".";
        throw new IOException((String)var0);
    }

    public static boolean a(File file) {
        try {
            if (file.isDirectory()) {
                b.c(file);
            }
        }
        catch (Exception exception) {}
        try {
            return file.delete();
        }
        catch (Exception exception) {
            return false;
        }
    }

    private static void c(File arrfile) {
        File[] arrfile22 = arrfile;
        if (!arrfile22.exists()) {
            String string = arrfile22 + " does not exist";
            throw new IllegalArgumentException(string);
        }
        if (!arrfile22.isDirectory()) {
            String string = arrfile22 + " is not a directory";
            throw new IllegalArgumentException(string);
        }
        File[] arrfile2 = arrfile22.listFiles();
        if (arrfile2 == null) {
            throw new IOException("Failed to list contents of " + arrfile22);
        }
        arrfile = arrfile2;
        Object object = null;
        for (File file : arrfile) {
            try {
                File file2 = file;
                if (file2.isDirectory()) {
                    b.b(file2);
                    continue;
                }
                boolean bl = file2.exists();
                if (file2.delete()) continue;
                if (!bl) {
                    throw new FileNotFoundException("File does not exist: " + file2);
                }
                object = "Unable to delete file: " + file2;
                throw new IOException((String)object);
            }
            catch (IOException iOException) {
                object = iOException;
                object = iOException;
            }
        }
        if (object != null) {
            throw object;
        }
    }

    public static void b(File file, File file2) {
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        }
        if (file2.exists()) {
            throw new a("Destination '" + file2 + "' already exists");
        }
        boolean bl = file.renameTo(file2);
        if (!bl) {
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
                throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
            }
            b.c(file, file2);
            b.b(file);
            if (file.exists()) {
                throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    static {
        a.multiply(e);
        f = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(0x1000000000000000L));
        a.multiply(f);
    }
}
