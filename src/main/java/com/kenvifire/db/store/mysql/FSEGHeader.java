package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/19.
 */
public class FSEGHeader {
    private int leafPagesInodeSpaceId;
    private int leafPagesInodePageNumber;
    private short leafPageInodeOffset;
    private int internalInodeSpaceId;
    private int internalInodePageNumber;
    private short internalInodeOffset;

    public void read(ByteBuffer buffer) {
        leafPagesInodeSpaceId = DataUtils.readInt(buffer);
        leafPagesInodePageNumber = DataUtils.readInt(buffer);
        leafPageInodeOffset = DataUtils.readShort(buffer);
        internalInodeSpaceId = DataUtils.readInt(buffer);
        internalInodePageNumber = DataUtils.readInt(buffer);
        internalInodeOffset = DataUtils.readShort(buffer);
    }

    public int getLeafPagesInodeSpaceId() {
        return leafPagesInodeSpaceId;
    }

    public void setLeafPagesInodeSpaceId(int leafPagesInodeSpaceId) {
        this.leafPagesInodeSpaceId = leafPagesInodeSpaceId;
    }

    public int getLeafPagesInodePageNumber() {
        return leafPagesInodePageNumber;
    }

    public void setLeafPagesInodePageNumber(int leafPagesInodePageNumber) {
        this.leafPagesInodePageNumber = leafPagesInodePageNumber;
    }

    public short getLeafPageInodeOffset() {
        return leafPageInodeOffset;
    }

    public void setLeafPageInodeOffset(short leafPageInodeOffset) {
        this.leafPageInodeOffset = leafPageInodeOffset;
    }

    public int getInternalInodeSpaceId() {
        return internalInodeSpaceId;
    }

    public void setInternalInodeSpaceId(int internalInodeSpaceId) {
        this.internalInodeSpaceId = internalInodeSpaceId;
    }

    public int getInternalInodePageNumber() {
        return internalInodePageNumber;
    }

    public void setInternalInodePageNumber(int internalInodePageNumber) {
        this.internalInodePageNumber = internalInodePageNumber;
    }

    public short getInternalInodeOffset() {
        return internalInodeOffset;
    }

    public void setInternalInodeOffset(short internalInodeOffset) {
        this.internalInodeOffset = internalInodeOffset;
    }
}
