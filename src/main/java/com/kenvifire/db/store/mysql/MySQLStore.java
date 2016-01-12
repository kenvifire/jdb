package com.kenvifire.db.store.mysql;


import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/8.
 */
public class MySQLStore {

    private FILHeader header;

    public MySQLStore() {
    }

    public static MySQLStore read(ByteBuffer buffer) {
        MySQLStore mySQLStore = new MySQLStore();
        mySQLStore.header = FILHeader.readHeader(buffer);
        return mySQLStore;
    }

    public FILHeader getHeader() {
        return header;
    }

    public void setHeader(FILHeader header) {
        this.header = header;
    }
}
