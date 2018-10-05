package com.vivi.bugTracking.controller.request;

import lombok.Data;

@Data
public class PageRequest {
    private String filter;
    private Integer pageIndex;
    private Integer pageSize;
    private String sortOrder;
}
