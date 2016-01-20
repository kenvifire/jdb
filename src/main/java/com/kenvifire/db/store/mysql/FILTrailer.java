package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;
import lombok.Data;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/10.
 */
@Data
public class FILTrailer {
    private Integer checksum;
    private Integer low32bOfLSN;

    public static FILTrailer read(ByteBuffer buffer) {
        FILTrailer trailer = new FILTrailer();
        trailer.checksum = DataUtils.readInt(buffer);
        trailer.low32bOfLSN = DataUtils.readInt(buffer);

        return trailer;
    }
}
