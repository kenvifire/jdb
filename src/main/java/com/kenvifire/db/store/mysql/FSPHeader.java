package com.kenvifire.db.store.mysql;

import lombok.Data;

/**
 * Created by kenvi on 16/1/11.
 */
@Data
public class FSPHeader {

    private Integer spaceId;
    private Integer unused;
    private Integer higestPageNo;
    private Integer higestPageNoInitialized;
    private Integer flags;
    private Integer numOfPageUsed;
    private byte[]  node4FreeList;
    private byte[]  node4FreeFragList;
    private byte[]  node4FullFragList;
    private Long    nextUnusedSegmentId;
    private byte[]  node4FullInodesList;
    private byte[]  node4FreeInodesList;

}
