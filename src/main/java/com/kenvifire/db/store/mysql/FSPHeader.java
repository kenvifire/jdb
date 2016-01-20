package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;
import lombok.Data;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/11.
 */
@Data
public class FSPHeader {

    private Integer spaceId;
    private Integer unused;
    private Integer higestPageNo;
    private Integer higestPageNoInitialized;
    private Integer flags;
    private Integer numOfPageUsed;
    private byte[]  node4FreeList = new byte[16];
    private byte[]  node4FreeFragList = new byte[16];
    private byte[]  node4FullFragList = new byte[16];
    private Long    nextUnusedSegmentId;
    private byte[]  node4FullInodesList = new byte[16];
    private byte[]  node4FreeInodesList = new byte[16];

    public static FSPHeader read(ByteBuffer buffer) {
        FSPHeader header = new FSPHeader();
        header.spaceId = DataUtils.readInt(buffer);
        header.unused = DataUtils.readInt(buffer);
        header.higestPageNo = DataUtils.readInt(buffer);
        header.higestPageNoInitialized = DataUtils.readInt(buffer);
        header.flags = DataUtils.readInt(buffer);
        header.numOfPageUsed = DataUtils.readInt(buffer);
        DataUtils.readBytes(buffer,header.node4FreeList);
        DataUtils.readBytes(buffer,header.node4FreeFragList);
        DataUtils.readBytes(buffer,header.node4FullFragList);
        header.nextUnusedSegmentId = DataUtils.readLong(buffer);
        DataUtils.readBytes(buffer, header.node4FullInodesList);
        DataUtils.readBytes(buffer, header.node4FreeInodesList);

        return header;
    }

    public String dump() {
        return String.format("spaceId:%d\n" +
                "highest page number in file:%d\n" +
                "number of pages used in free_frag list:%d\n" +
                "next unused segment id:%d\n",spaceId,higestPageNo,
                higestPageNoInitialized,nextUnusedSegmentId);

    }

}
