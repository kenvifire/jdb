package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/19.
 */
public class IndexHeader {
    private short noOfDirectorySlots;
    private short heapTopPos;
    private short noOfHeapRecords;
    private short formatFlag;
    private short firstGarbageRecordOffset;
    private short garbageSpace;
    private short lastInsertPos;
    private short pageDirection;
    private short noOfInsertsInPageDirection;
    private short noOfRecords;
    private long maximumTransactionId;
    private short pageLevel;
    private long indexId;

    public String dump() {
        return String.format("----------\nnoOfDirectorSlots:%s\n" +
                            "heapTopPos:%s\n" +
                            "noOfHeapRecords:%s\n" +
                            "formatFloag:%s\n" +
                            "firstGarbageRecordOffset:%s\n" +
                            "garbageSpace:%s\n" +
                            "lastInsertPost:%s\n" +
                            "pageDirection:%s\n" +
                            "noOfInsertsInPageDirection:%s\n" +
                            "noOfRecords:%s\n" +
                            "maximumTransactionId:%s\n" +
                            "pageLevel:%s\n" +
                            "indexId:%s\n",
                    noOfDirectorySlots,
                    heapTopPos,
                    noOfHeapRecords,
                    formatFlag,
                    firstGarbageRecordOffset,
                    garbageSpace,
                    lastInsertPos,
                    pageDirection,
                    noOfInsertsInPageDirection,
                    noOfRecords,
                    maximumTransactionId,
                    pageLevel,
                    indexId);
    }

    public void read(ByteBuffer buffer) {
        noOfDirectorySlots = DataUtils.readShort(buffer);
        heapTopPos = DataUtils.readShort(buffer);
        short tmp = DataUtils.readShort(buffer);
        noOfHeapRecords = (short)((int)tmp & 0x7fff);
        formatFlag = (byte)((int)tmp & 0x8000);
        firstGarbageRecordOffset = DataUtils.readShort(buffer);
        garbageSpace = DataUtils.readShort(buffer);
        lastInsertPos = DataUtils.readShort(buffer);
        pageDirection = DataUtils.readShort(buffer);
        noOfInsertsInPageDirection = DataUtils.readShort(buffer);
        noOfRecords = DataUtils.readShort(buffer);
        System.out.println("currnet pos-->" + buffer.position());
        maximumTransactionId = DataUtils.readLong(buffer);
        System.out.println("currnet pos-->" + buffer.position());
        pageLevel = DataUtils.readShort(buffer);
        indexId = DataUtils.readLong(buffer);
        System.out.println("currnet pos-->" + buffer.position());
    }

    public short getNoOfDirectorySlots() {
        return noOfDirectorySlots;
    }

    public void setNoOfDirectorySlots(short noOfDirectorySlots) {
        this.noOfDirectorySlots = noOfDirectorySlots;
    }

    public short getHeapTopPos() {
        return heapTopPos;
    }

    public void setHeapTopPos(short heapTopPos) {
        this.heapTopPos = heapTopPos;
    }

    public short getNoOfHeapRecords() {
        return noOfHeapRecords;
    }

    public void setNoOfHeapRecords(short noOfHeapRecords) {
        this.noOfHeapRecords = noOfHeapRecords;
    }

    public short getFormatFlag() {
        return formatFlag;
    }

    public void setFormatFlag(short formatFlag) {
        this.formatFlag = formatFlag;
    }

    public short getFirstGarbageRecordOffset() {
        return firstGarbageRecordOffset;
    }

    public void setFirstGarbageRecordOffset(short firstGarbageRecordOffset) {
        this.firstGarbageRecordOffset = firstGarbageRecordOffset;
    }

    public short getGarbageSpace() {
        return garbageSpace;
    }

    public void setGarbageSpace(short garbageSpace) {
        this.garbageSpace = garbageSpace;
    }

    public short getLastInsertPos() {
        return lastInsertPos;
    }

    public void setLastInsertPos(short lastInsertPos) {
        this.lastInsertPos = lastInsertPos;
    }

    public short getPageDirection() {
        return pageDirection;
    }

    public void setPageDirection(short pageDirection) {
        this.pageDirection = pageDirection;
    }

    public short getNoOfInsertsInPageDirection() {
        return noOfInsertsInPageDirection;
    }

    public void setNoOfInsertsInPageDirection(short noOfInsertsInPageDirection) {
        this.noOfInsertsInPageDirection = noOfInsertsInPageDirection;
    }

    public short getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(short noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public long getMaximumTransactionId() {
        return maximumTransactionId;
    }

    public void setMaximumTransactionId(long maximumTransactionId) {
        this.maximumTransactionId = maximumTransactionId;
    }

    public short getPageLevel() {
        return pageLevel;
    }

    public void setPageLevel(short pageLevel) {
        this.pageLevel = pageLevel;
    }


}
