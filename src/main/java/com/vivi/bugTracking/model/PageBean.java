package com.vivi.bugTracking.model;

import com.vivi.bugTracking.exception.PageException;
import lombok.Getter;

import java.util.List;

/**
 * Paging bean, <strong>page start with 1</strong>
 *
 * @param <T>
 */
@Getter
public class PageBean<T> {
    private int pageIndex;
    private int pageSize;
    private int totalPage;
    private int totalRecord;
    private List<T> data;

    public PageBean(int pageIndex, int pageSize, int totalRecord) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        if (pageSize > 0) {
            if (totalRecord % pageSize == 0) {
                this.totalPage = totalRecord / pageSize;
            } else {
                this.totalPage = totalRecord / pageSize + 1;
            }
        }
    }

    public int startIndex() {
        if (pageIndex > totalPage || pageIndex <= 0) {
            throw new PageException("InvalidPage");
        }
        return (this.pageIndex - 1) * this.pageSize;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
