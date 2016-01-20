package com.kenvifire.db.store.mysql;

import com.kenvifire.db.utils.DataUtils;
import lombok.Data;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/13.
 */
@Data
public class XDESEntry {
   private Long fileSegmentId;
   private byte[] xdesList = new byte[12];
   private Integer state;
   private byte[] pageStateBitmap = new byte[16];

   public static XDESEntry read(ByteBuffer buffer) {
      XDESEntry entry = new XDESEntry();
      entry.fileSegmentId = DataUtils.readLong(buffer);
      DataUtils.readBytes(buffer, entry.xdesList);
      entry.state = DataUtils.readInt(buffer);
      DataUtils.readBytes(buffer, entry.pageStateBitmap);
      return entry;
   }

   public String dump() {
      return String.format("fileSegmentID:%d\n" +
              "state:%d\n",fileSegmentId,state);

   }
}
