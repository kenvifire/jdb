package com.kenvifire.db.store.mysql;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by kenvi on 16/1/11.
 */
public class Main {
     public static void main(String[] args) throws IOException {
          RandomAccessFile file = new RandomAccessFile(new File("/Users/kenvi/mysql/data/ibdata1"),"r");
          ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
          FileChannel channel = file.getChannel();
          channel.read(buffer);
          buffer.flip();
          MySQLStore store = MySQLStore.read(buffer);

          System.out.println(store.getHeader().dump());
     }
}
