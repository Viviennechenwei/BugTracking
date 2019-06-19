package com.vivi.bugTracking.model;

import lombok.Data;

@Data
public class Permission {
    private int id;
    private String resourceName;
    private String actionName;
}
