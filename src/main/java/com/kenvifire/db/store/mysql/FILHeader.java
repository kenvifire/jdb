package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/10.
 */
public class FILHeader {
    /**
     * Checksum 4
     * Offset (Page Number) 4
     * Previous Page 4
     * Next Page 4
     * LSN for last page modification 8
     * Page Type 2
     * Flush LSN( 0 except space 0 page 0) 8
     * Space Id 4
     */

    private Integer checksum;
    private Integer offSet;
    private Integer previousPage;
    private Integer nextPage;
    private Long    lsn4LastModification;
    private short   type;
    private Long    flushLsn;
    private Integer spaceId;

    public static FILHeader readHeader(ByteBuffer buffer){
        FILHeader header = new FILHeader();
        header.checksum = DataUtils.readInt(buffer);
        header.offSet = DataUtils.readInt(buffer);
        header.previousPage = DataUtils.readInt(buffer);
        header.nextPage = DataUtils.readInt(buffer);
        header.lsn4LastModification = DataUtils.readLong(buffer);
        header.type = DataUtils.readShort(buffer);
        header.flushLsn = DataUtils.readLong(buffer);
        header.spaceId = DataUtils.readInt(buffer);

        return header;

    }

    public String dump(){
        String format = "checksum:%d\n" +
                "Offset:%d\n" +
                "Previous Page :%d\n" +
                "Next Page:%d\n" +
                "LSN for last page modification:%d\n" +
                "PageType:%d\n" +
                "Flush LSN:%d\n" +
                "SpaceId:%d";
        return String.format(format,checksum,
                offSet,previousPage,nextPage,
                lsn4LastModification,type,flushLsn,spaceId);

    }


}
