package com.kenvifire.db.store.mysql;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * Created by kenvi on 16/1/19.
 */
public class IndexPage extends Page{
    private FILHeader filHeader;
    private IndexHeader indexHeader;
    private FSEGHeader fsegHeader;
    private IndexSystemRecord[] systemRecords = new IndexSystemRecord[2];

    private List<UserRecord> userRecordList;
    private byte[] freeSpace;
    private List<PageDirectory> pageDirectoryList;
    private FILTrailer filTrailer;


    @Override
    public FILHeader getFilHeader() {
        return filHeader;
    }

    @Override
    public void setFilHeader(FILHeader filHeader) {
        this.filHeader = filHeader;
    }

    public IndexHeader getIndexHeader() {
        return indexHeader;
    }

    public void setIndexHeader(IndexHeader indexHeader) {
        this.indexHeader = indexHeader;
    }

    public FSEGHeader getFsegHeader() {
        return fsegHeader;
    }

    public void setFsegHeader(FSEGHeader fsegHeader) {
        this.fsegHeader = fsegHeader;
    }


    public byte[] getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(byte[] freeSpace) {
        this.freeSpace = freeSpace;
    }



    @Override
    public FILTrailer getFilTrailer() {
        return filTrailer;
    }

    @Override
    public void setFilTrailer(FILTrailer filTrailer) {
        this.filTrailer = filTrailer;
    }

    @Override
    public void readPageData(ByteBuffer buffer) {
        this.filHeader = FILHeader.readHeader(buffer);
        this.indexHeader = new IndexHeader();
        this.indexHeader.read(buffer);
        this.fsegHeader = new FSEGHeader();
        this.fsegHeader.read(buffer);
        this.systemRecords[0] = new IndexSystemRecord();
        this.systemRecords[1] = new IndexSystemRecord();
        this.systemRecords[0].read(buffer);
        this.systemRecords[1].read(buffer);

    }

    @Override
    public String dump() {
        return super.dump();
    }
}
