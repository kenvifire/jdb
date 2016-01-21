package com.kenvifire.db.utils;

import java.nio.ByteBuffer;

/**
 * Created by kenvi on 16/1/11.
 */
public class DataUtils {

    public static String readString(ByteBuffer buff, int len) {
        char[] chars = new char[len];

        for (int i = 0; i< len; i++ ) {
            int x = buff.get();
            chars[i] = (char)x;
        }
        return new String(chars);
    }


    public static Integer readInt(ByteBuffer buff) {
       return buff.getInt();
    }

    public static Long readLong(ByteBuffer buff) {
       return buff.getLong();

    }

    public static short readShort(ByteBuffer buff) {
        return buff.getShort();
    }

    public static void readBytes(ByteBuffer buffer, byte[] dst) {
        buffer.get(dst);
    }

    public static String dumpHex(byte[] bytes) {
        String result = "";
        for (byte b : bytes) {
            result += Integer.toHexString(b);
        }
        return result;
    }

}
