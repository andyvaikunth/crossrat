/*
 * Decompiled with CFR 0_124.
 */
package a.b;

import a.b.a;
import a.b.b;
import a.b.d;
import a.b.e;
import a.b.f;

public enum c {
    e("Alpine Linux", "alpine", new f("/etc/arch-release")),
    f("Antergos", new Object[0]),
    g("Arch Linux", "archlinux", "archarm"),
    h("BLAG", new Object[0]),
    i("Chakra", new f("/etc/chakra-release")),
    j("CentOS", new f("/etc/centos-release"), new e("/etc/redhat-release", "CentOS")),
    k("Crunchbang", new f("/etc/crunchbang-lsb-release"), new f("/etc/lsb-release-crunchbang")),
    l("Debian", new Object[0]),
    m("Raspbian", new e("/etc/os-release", "Raspbian")),
    n("elementary OS", "elementary"),
    o("Evolve OS", "EvolveOS", new f("/etc/evolveos-release")),
    p("KaOS", "kaos"),
    q("Fedora", new e("/etc/fedora-release", "fedora")),
    r("Frugalware", new Object[0]),
    s("Funtoo", new e("/etc/gentoo-release", "funtoo"), new a(new String[]{"lsb_release", "-sd"}, "funtoo")),
    t("Gentoo", new e("/etc/gentoo-release", "gentoo")),
    u("Jiyuu", "Jiyuu"),
    v("Deepin", "LinuxDeepin", new e("/etc/issue/", "LinuxDeepin")),
    a("Kali Linux", "Kali", "Debian Kali Linux"),
    w("Korora", new e("/etc/fedora-release", "korora")),
    x("Mageia", new f("/etc/mageia-release")),
    y("Mandriva", "MandrivaLinux", new f("/etc/mandriva-release")),
    z("Mandrake", new f("/etc/mandrake-release")),
    A("Manjaro", "ManjaroLinux"),
    B("Linux Mint", "LinuxMint", "mint"),
    b("NixOS", new f("/etc/NIXOS")),
    c("LMDE", new Object[0]),
    C("Lunar Linux", "Lunar"),
    D("openSUSE", "SUSE LINUX", "openSUSE project", new f("/etc/SuSE-release")),
    E("Parabola", "Parabola GNU/Linux-libre", new e("/etc/issue", "Parabola GNU/Linux-libre")),
    F("Peppermint", new Object[0]),
    G("Redhat Enterprise", "RedHatEnterprise", new e("/etc/redhat-release", "Red Hat")),
    H("Sabayon", new f("/etc/sabayon-edition")),
    I("Scientific Linux", new e("/etc/system-release", "Scientific Linux")),
    J("Slackware", new f("/etc/slackware-version")),
    K("SolusOS", new e("/etc/issue", "SolusOS")),
    L("SteamOS", "steam"),
    M("TinyCore", new f("/usr/share/doc/tc/release.txt")),
    N("Trisquel", new Object[0]),
    O("Ubuntu", new Object[0]),
    P("Viperr", new Object[0]),
    Q("Crux", new b("crux")),
    R("gNewSense", new e("/etc/issue", "gNewSense")),
    S("Dragora", new f("/etc/dragora-version")),
    T("Chapeau", new Object[0]),
    U("neon", "KDE neon"),
    V("Oracle Linux", "ol", "Ol", new f("/etc/oracle-release"), new e("/etc/system-release", "Oracle Linux")),
    W("Qubes", new f("/etc/qubes-rpc")),
    d("Unknown", new Object[0]);
    
    private String X;
    private Object[] Y;

    private /* varargs */ c(String string2, Object ... arrobject) {
        this.X = string2;
        this.Y = arrobject;
    }

    public final Object[] a() {
        return this.Y;
    }

    public final String b() {
        return this.X;
    }

    public final String c() {
        if (this == d) {
            return "Unknown Linux";
        }
        if (!this.X.toLowerCase().contains("linux")) {
            return String.valueOf(this.X) + " Linux";
        }
        return this.X;
    }

    public static d d() {
        return crossrat.e.d();
    }
}
