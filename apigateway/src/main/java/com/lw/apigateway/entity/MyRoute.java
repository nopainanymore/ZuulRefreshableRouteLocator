package com.lw.apigateway.entity;

import lombok.Data;

/**
 * apigateway: MyRoute
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:36
 * @since 1.0.0, 2019-01-05 09:36
 */
@Data
public class MyRoute {

    private Long myRouteId;

    private String id;

    private String path;

    private String serviceId;

    private String url;

    private boolean stripPrefix = true;

    private Boolean retryable;

    private Boolean enabled;

    public MyRoute() {
    }

}
