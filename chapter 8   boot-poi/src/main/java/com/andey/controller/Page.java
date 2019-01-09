package com.andey.controller;

import java.util.Collections;
import java.util.List;

/**
 * Created by jiangbin on 2019/1/9.
 */
public class Page {
    /**
     ?* @currPageNo? 页面传入的页号，从一开始
     ?* @pageSize??? 每页记录数
     ?*/
    public <T> List getPagingResultMap(List<T> list, Integer currPageNo, Integer pageSize) {
        if (list.isEmpty()) {

            return Collections.emptyList();
        }
        int totalRowNum = list.size();
        int totalPageNum = (totalRowNum - 1) / pageSize + 1;
        int realPageNo = currPageNo;
        if (currPageNo > totalPageNum) {
            realPageNo = totalPageNum;
        } else if (currPageNo < 1) {
            realPageNo = 1;
        }
        int fromIdx = (realPageNo - 1) * pageSize;
        int toIdx = realPageNo * pageSize;
        if (realPageNo == totalPageNum && totalPageNum * pageSize > totalRowNum) {
            toIdx = totalRowNum ;
        }
        List<T> result = list.subList(fromIdx, toIdx);
        return result;
    }
}
