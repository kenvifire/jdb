package com.kenvifire.db.store.mysql;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenvi on 16/1/11.
 */
public class Main {
     public static void main(String[] args) throws IOException {
          RandomAccessFile file = new RandomAccessFile(new File("/usr/local/mysql/data/test/t_btree.ibd"),"r");
          ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
          FileChannel channel = file.getChannel();
          List<Page> pageList = new ArrayList<Page>();
          while(channel.read(buffer)>=16*1024) {
              buffer.flip();
              Page page = Page.read(buffer);
              page.getFilHeader();

              buffer.rewind();
              pageList.add(page);
          }
          System.out.println("total + " + pageList.size() + " pages");
          for(Page page : pageList) {
             System.out.println(page.dump());
          }
     }
}
