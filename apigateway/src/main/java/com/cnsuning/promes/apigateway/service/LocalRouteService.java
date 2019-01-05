package com.cnsuning.promes.apigateway.service;

import com.cnsuning.promes.apigateway.entity.LocalRoute;

import java.util.List;

/**
 * apigateway: LocalRouteService
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:41
 * @since 1.0.0, 2019-01-05 09:41
 */
public interface LocalRouteService {

    List<LocalRoute> getAllLocalRouteList();

    LocalRoute add(LocalRoute route);
}
