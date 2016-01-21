package com.kenvifire.db.store.mysql;

/**
 * Created by kenvi on 16/1/19.
 */
public enum PageTypeEnum {
    FSR_HDR((short)8),
    IBUF_BITMAP((short)5),
    INODE((short)3),
    INDEX((short)17855),
    FREE((short)0);

    private short value;
    private PageTypeEnum(short value) {
       this.value = value;
    }

    public static PageTypeEnum parse(short value) {
        for(PageTypeEnum typeEnum : values()) {
            if(typeEnum.value == value) {
                return typeEnum;
            }
        }

        return null;
    }
}
