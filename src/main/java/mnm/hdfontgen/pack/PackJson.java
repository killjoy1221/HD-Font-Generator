package mnm.hdfontgen.pack;

import com.google.gson.annotations.SerializedName;
import mnm.hdfontgen.pack.resource.AbstractJsonResource;

public class PackJson extends AbstractJsonResource {

    private final PackSection pack;

    public PackJson(int packFormat, String description) {
        pack = new PackSection(packFormat, description);
    }

    @Override
    public ZipPath getPath() {
        return () -> "pack.mcmeta";
    }

    private static class PackSection {
        @SerializedName("pack_format")
        final int packFormat;
        final String description;

        PackSection(int packFormat, String description) {
            this.packFormat = packFormat;
            this.description = description;
        }
    }
}
