/*
 * Decompiled with CFR 0_124.
 */
package org.jnativehook.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.jnativehook.GlobalScreen;
import org.jnativehook.b.d;
import org.jnativehook.c;
import org.jnativehook.e;
import org.jnativehook.example.a;
import org.jnativehook.example.b;

public class NativeHookDemo
extends JFrame
implements ActionListener,
ItemListener,
WindowListener,
org.jnativehook.a.a,
org.jnativehook.b.a,
d {
    private JMenu a;
    private JMenuItem b;
    private JMenuItem c;
    private JCheckBoxMenuItem d;
    private JCheckBoxMenuItem e;
    private JCheckBoxMenuItem f;
    private JCheckBoxMenuItem g;
    private JCheckBoxMenuItem h;
    private JTextArea i;
    private static final Logger j = Logger.getLogger(GlobalScreen.class.getPackage().getName());

    public NativeHookDemo() {
        this.setTitle("JNativeHook Demo");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(2);
        this.setSize(600, 300);
        this.addWindowListener(this);
        Object object = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic(70);
        object.add(jMenu);
        this.b = new JMenuItem("Quit", 81);
        this.b.addActionListener(this);
        this.b.setAccelerator(KeyStroke.getKeyStroke(115, 8));
        this.b.getAccessibleContext().setAccessibleDescription("Exit the program");
        jMenu.add(this.b);
        jMenu = new JMenu("View");
        jMenu.setMnemonic(86);
        object.add(jMenu);
        this.c = new JMenuItem("Clear", 67);
        this.c.addActionListener(this);
        this.c.setAccelerator(KeyStroke.getKeyStroke(67, 3));
        this.c.getAccessibleContext().setAccessibleDescription("Clear the screen");
        jMenu.add(this.c);
        jMenu.addSeparator();
        this.d = new JCheckBoxMenuItem("Enable Native Hook");
        this.d.addItemListener(this);
        this.d.setMnemonic(72);
        this.d.setAccelerator(KeyStroke.getKeyStroke(72, 3));
        jMenu.add(this.d);
        this.a = new JMenu("Listeners");
        this.a.setMnemonic(76);
        jMenu.add(this.a);
        this.e = new JCheckBoxMenuItem("Keyboard Events");
        this.e.addItemListener(this);
        this.e.setMnemonic(75);
        this.e.setAccelerator(KeyStroke.getKeyStroke(75, 3));
        this.a.add(this.e);
        this.f = new JCheckBoxMenuItem("Button Events");
        this.f.addItemListener(this);
        this.f.setMnemonic(66);
        this.f.setAccelerator(KeyStroke.getKeyStroke(66, 3));
        this.a.add(this.f);
        this.g = new JCheckBoxMenuItem("Motion Events");
        this.g.addItemListener(this);
        this.g.setMnemonic(77);
        this.g.setAccelerator(KeyStroke.getKeyStroke(77, 3));
        this.a.add(this.g);
        this.h = new JCheckBoxMenuItem("Wheel Events");
        this.h.addItemListener(this);
        this.h.setMnemonic(87);
        this.h.setAccelerator(KeyStroke.getKeyStroke(87, 3));
        this.a.add(this.h);
        this.setJMenuBar((JMenuBar)object);
        this.i = new JTextArea();
        this.i.setEditable(false);
        this.i.setBackground(new Color(255, 255, 255));
        this.i.setForeground(new Color(0, 0, 0));
        this.i.setText("");
        object = new JScrollPane(this.i);
        object.setPreferredSize(new Dimension(375, 125));
        this.add((Component)object, "Center");
        j.setUseParentHandlers(false);
        j.setLevel(Level.ALL);
        object = new ConsoleHandler();
        object.setFormatter(new b(this, 0));
        object.setLevel(Level.WARNING);
        j.addHandler((Handler)object);
        GlobalScreen.a(new e());
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.b) {
            this.dispose();
            return;
        }
        if (actionEvent.getSource() == this.c) {
            this.i.setText("");
        }
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        ItemSelectable itemSelectable = itemEvent.getItemSelectable();
        if (itemSelectable == this.d) {
            try {
                if (itemEvent.getStateChange() == 1) {
                    GlobalScreen.a();
                } else {
                    GlobalScreen.b();
                }
            }
            catch (c c2) {
                this.i.append("Error: " + c2.getMessage() + "\n");
            }
            this.d.setState(GlobalScreen.c());
            this.a.setEnabled(this.d.getState());
            return;
        }
        if (itemSelectable == this.e) {
            if (itemEvent.getStateChange() == 1) {
                GlobalScreen.a(this);
                return;
            }
            GlobalScreen.b(this);
            return;
        }
        if (itemSelectable == this.f) {
            if (itemEvent.getStateChange() == 1) {
                GlobalScreen.a(this);
                return;
            }
            GlobalScreen.b(this);
            return;
        }
        if (itemSelectable == this.g) {
            if (itemEvent.getStateChange() == 1) {
                GlobalScreen.a(this);
                return;
            }
            GlobalScreen.b(this);
            return;
        }
        if (itemSelectable == this.h) {
            if (itemEvent.getStateChange() == 1) {
                GlobalScreen.a(this);
                return;
            }
            GlobalScreen.b(this);
        }
    }

    public void windowActivated(WindowEvent windowEvent) {
    }

    public void windowClosing(WindowEvent windowEvent) {
    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowIconified(WindowEvent windowEvent) {
    }

    public void windowOpened(WindowEvent windowEvent) {
        this.requestFocusInWindow();
        this.d.setSelected(true);
        this.i.append("JNativeHook Version " + System.getProperty("jnativehook.lib.version"));
        this.i.append("\nAuto Repeat Rate: " + System.getProperty("jnativehook.key.repeat.rate"));
        this.i.append("\nAuto Repeat Delay: " + System.getProperty("jnativehook.key.repeat.delay"));
        this.i.append("\nDouble Click Time: " + System.getProperty("jnativehook.button.multiclick.iterval"));
        this.i.append("\nPointer Sensitivity: " + System.getProperty("jnativehook.pointer.sensitivity"));
        this.i.append("\nPointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointer.acceleration.multiplier"));
        this.i.append("\nPointer Acceleration Threshold: " + System.getProperty("jnativehook.pointer.acceleration.threshold"));
        try {
            this.i.setCaretPosition(this.i.getLineStartOffset(this.i.getLineCount() - 1));
        }
        catch (BadLocationException badLocationException) {
            this.i.setCaretPosition(this.i.getDocument().getLength());
        }
        this.e.setSelected(true);
        this.f.setSelected(true);
        this.g.setSelected(true);
        this.h.setSelected(true);
    }

    public void windowClosed(WindowEvent serializable) {
        try {
            GlobalScreen.b();
        }
        catch (c c2) {
            serializable = c2;
            c2.printStackTrace();
        }
        System.runFinalization();
        System.exit(0);
    }

    public static void main(String[] object) {
        object = new StringBuffer("\nJNativeHook: Global keyboard and mouse hooking for Java.\n").append("Copyright (C) 2006-2015 Alexander Barker.  All Rights Received.\nhttps://github.com/kwhat/jnativehook/\n").append("\nJNativeHook is free software: you can redistribute it and/or modify\n").append("it under the terms of the GNU Lesser General Public License as published\nby the Free Software Foundation, either version 3 of the License, or\n").append("(at your option) any later version.\n\n").append("JNativeHook is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\n").append("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU General Public License for more details.\n").append("\nYou should have received a copy of the GNU Lesser General Public License\n").append("along with this program.  If not, see <http://www.gnu.org/licenses/>.\n");
        System.out.println(object);
        SwingUtilities.invokeLater(new a());
    }
}
