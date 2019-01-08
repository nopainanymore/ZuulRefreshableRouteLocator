package com.lw.apigateway.service;

import com.lw.apigateway.entity.MyRoute;

import java.util.List;

/**
 * apigateway: MyRouteService
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:41
 * @since 1.0.0, 2019-01-05 09:41
 */
public interface MyRouteService {

    List<MyRoute> getAllLocalRouteList();

    Integer add(MyRoute route);
}
