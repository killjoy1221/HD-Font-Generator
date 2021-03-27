package mnm.hdfontgen.pack;

import mnm.hdfontgen.bitmap.BitmapFontGenerator;
import mnm.hdfontgen.legacy.LegacyFontGenerator;

public enum PackFormat {
    V1(1, "1.6.1", "1.8.9", LegacyFontGenerator::new),
    V2(2, "1.9", "1.10.2", LegacyFontGenerator::new),
    V3(3, "1.11", "1.12.2", LegacyFontGenerator::new),
    V4(4, "1.13", "1.14.4", BitmapFontGenerator::new),
    V5(5, "1.15", "1.16.1", BitmapFontGenerator::new),
    V6(6, "1.16.2", "1.16.5", BitmapFontGenerator::new),
    V7(7, "1.17", null, BitmapFontGenerator::new),
    ;

    public static final PackFormat LATEST = V7;

    private final int format;
    private final String minVersion;
    private final String maxVersion;
    private final PackGeneratorFactory factory;

    PackFormat(int format, String minVersion, String maxVersion, PackGeneratorFactory factory) {
        this.format = format;
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
        this.factory = factory;
    }

    public int getFormat() {
        return format;
    }

    public String getVersionRange() {
        if (maxVersion == null) {
            return String.format("%s+", minVersion);
        }
        return String.format("%s-%s", minVersion, maxVersion);
    }

    public PackGeneratorFactory getFactory() {
        return factory;
    }

    @Override
    public String toString() {
        if (maxVersion == null) {
            return String.format("MC %s+", minVersion);
        }
        return String.format("MC %s - %s", minVersion, maxVersion);
    }
}