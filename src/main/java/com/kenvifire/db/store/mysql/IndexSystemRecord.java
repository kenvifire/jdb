package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;

import javax.xml.crypto.Data;
import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/19.
 */
public class IndexSystemRecord {
    private byte    infoFlags;//3bits
    private byte    noOfRecordsOwned;//4 bits
    private short   order;//13bits
    private byte    recordType;//3bits
    private short nextRecordOffset;
    private byte[] str = new byte[8];

    public void read(ByteBuffer buffer) {
        byte tmp = buffer.get();
        infoFlags = (byte)((int)tmp & 0x0f);
        noOfRecordsOwned = (byte)(((int) tmp >> 4) &0x0f );
        short tmpShort = DataUtils.readShort(buffer);
        order = (short)((int)tmpShort & 0x1fff);
        recordType = (byte)(((int)tmpShort >> 13) &0x07);
        nextRecordOffset = DataUtils.readShort(buffer);
        DataUtils.readBytes(buffer, str);
    }


    public byte getInfoFlags() {
        return infoFlags;
    }

    public void setInfoFlags(byte infoFlags) {
        this.infoFlags = infoFlags;
    }

    public byte getNoOfRecordsOwned() {
        return noOfRecordsOwned;
    }

    public void setNoOfRecordsOwned(byte noOfRecordsOwned) {
        this.noOfRecordsOwned = noOfRecordsOwned;
    }

    public short getOrder() {
        return order;
    }

    public void setOrder(short order) {
        this.order = order;
    }

    public byte getRecordType() {
        return recordType;
    }

    public void setRecordType(byte recordType) {
        this.recordType = recordType;
    }

    public short getNextRecordOffset() {
        return nextRecordOffset;
    }

    public void setNextRecordOffset(short nextRecordOffset) {
        this.nextRecordOffset = nextRecordOffset;
    }

    public byte[] getStr() {
        return str;
    }

    public void setStr(byte[] str) {
        this.str = str;
    }
}
