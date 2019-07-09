package com.nopainanymore.apigateway.entity;

import lombok.Data;

/**
 * api-gateway: MyRoute
 *
 * @author nopainanymore
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
