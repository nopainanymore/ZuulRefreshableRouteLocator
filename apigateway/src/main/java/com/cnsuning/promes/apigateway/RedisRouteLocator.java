package com.cnsuning.promes.apigateway;

import com.cnsuning.promes.apigateway.entity.LocalRoute;
import com.cnsuning.promes.apigateway.service.LocalRouteService;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * apigateway: RedisRouteLocator
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-04 19:43
 * @since 1.0.0, 2019-01-04 19:43
 */
public class RedisRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private ZuulProperties properties;

    private LocalRouteService localRouteService;

    public void setLocalRouteService(LocalRouteService localRouteService) {
        this.localRouteService = localRouteService;
    }

    public RedisRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
    }

    @Override
    public Collection<String> getIgnoredPaths() {
        return super.getIgnoredPaths();
    }

    @Override
    public List<Route> getRoutes() {
        return super.getRoutes();
    }

    @Override
    public Route getMatchingRoute(String path) {
        return super.getMatchingRoute(path);
    }


    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());

        routesMap.putAll(locateRoutesFromDB());

        LinkedHashMap<String, ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            // Prepend with slash if not already present.
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (org.springframework.util.StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    @Override
    protected boolean matchesIgnoredPatterns(String path) {
        return super.matchesIgnoredPatterns(path);
    }

    private Map<String, ZuulRoute> locateRoutesFromDB() {
        LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<>();
        List<LocalRoute> localRouteList = localRouteService.getAllLocalRouteList();
        for (LocalRoute localRoute : localRouteList) {
            if (org.apache.commons.lang.StringUtils.isBlank(localRoute.getPath()) || org.apache.commons.lang.StringUtils.isBlank(localRoute.getUrl())) {
                continue;
            }
            ZuulRoute zuulRoute = new ZuulRoute();
            BeanUtils.copyProperties(localRoute, zuulRoute);
            routesMap.put(zuulRoute.getPath(), zuulRoute);
        }
        return routesMap;
    }


}
