/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class e
extends h {
    private File a;
    private String b;

    public e(String string, String string2) {
        this(new File(string), string2);
    }

    private e(File file, String string) {
        this.a = file;
        this.b = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean a() {
        if (!this.a.exists()) return false;
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.a)));
            do {
                if ((string = bufferedReader.readLine()) != null) continue;
                bufferedReader.close();
                return false;
            } while (!string.toLowerCase().contains(this.b.toLowerCase()));
            bufferedReader.close();
            return true;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        return false;
    }
}
