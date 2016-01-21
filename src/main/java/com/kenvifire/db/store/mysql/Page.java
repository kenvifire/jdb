package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/17.
 */
public class Page {
    private PageTypeEnum pageType;

    public FILHeader getFilHeader() {
        return filHeader;
    }

    public void setFilHeader(FILHeader filHeader) {
        this.filHeader = filHeader;
    }

    public FILTrailer getFilTrailer() {
        return filTrailer;
    }

    public void setFilTrailer(FILTrailer filTrailer) {
        this.filTrailer = filTrailer;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    private FILHeader filHeader;
    private FILTrailer filTrailer;
    private byte[] data;

    public static Page read(ByteBuffer buffer) {
        int pos = buffer.position();
        buffer.position(24);
        short type = DataUtils.readShort(buffer);
        System.out.println("type==>" + type);
        PageTypeEnum pageType = PageTypeEnum.parse(type);
        Page page = new Page();
        page.pageType = pageType;
        if(pageType == PageTypeEnum.INDEX) {
            page = new IndexPage();
            buffer.position(pos);
            page.pageType  = pageType;
            page.readPageData(buffer);
        }
        return page;

    }

    public String dump(){
        return String.format("type:%s\n", pageType);
    }

    public void readPageData(ByteBuffer buffer) {
        DataUtils.readBytes(buffer, data);
    }
}
