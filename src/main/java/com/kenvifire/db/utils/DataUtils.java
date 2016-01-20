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
        byte[] bytes = new byte[4];
        buff.get(bytes);

        int x = (bytes[0] & 0xff) <<24;
        x = x | (bytes[1] & 0xff)<<16;
        x = x | (bytes[2] & 0xff)<<8;
        x = x | (bytes[3] & 0xff);
        return x;
    }

    public static Long readLong(ByteBuffer buff) {
        byte[] bytes = new byte[8];
        buff.get(bytes);
        long x = ((long)bytes[0] & 0xff) << 56;
        x = x | ((long)bytes[1] & 0xff) <<48;
        x = x | ((long)bytes[2] & 0xff) <<40;
        x = x | ((long)bytes[3] & 0xff) <<32;
        x = x | (bytes[4] & 0xff)<<24;
        x = x | (bytes[5] & 0xff)<<16;
        x = x | (bytes[6] & 0xff)<<8;
        x = x | (bytes[7] & 0xff);
        return x;

    }

    public static short readShort(ByteBuffer buff) {
        byte[] bytes = new byte[2];
        buff.get(bytes);
        Integer x = (int)bytes[0];
        x = x | (bytes[1] & 0xff)<<1;
        return x.shortValue();
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
