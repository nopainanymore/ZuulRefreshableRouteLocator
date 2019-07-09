package com.nopainanymore.apigateway;



import com.nopainanymore.apigateway.entity.MyRoute;
import com.nopainanymore.apigateway.service.MyRouteService;
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
 * apigateway: MyRouteLocator
 *
 * @author nopainanymore
 * @version 1.0.0, 2019-01-04 19:43
 * @since 1.0.0, 2019-01-04 19:43
 */
public class MyRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private ZuulProperties properties;

    private MyRouteService myRouteService;

    public void setMyRouteService(MyRouteService myRouteService) {
        this.myRouteService = myRouteService;
    }


    public MyRouteLocator(String servletPath, ZuulProperties properties) {
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
        List<MyRoute> myRouteList = myRouteService.getAllLocalRouteList();
        for (MyRoute myRoute : myRouteList) {
            if (org.apache.commons.lang.StringUtils.isBlank(myRoute.getPath()) || org.apache.commons.lang.StringUtils.isBlank(myRoute.getUrl())) {
                continue;
            }
            ZuulRoute zuulRoute = new ZuulRoute();
            BeanUtils.copyProperties(myRoute, zuulRoute);
            routesMap.put(zuulRoute.getPath(), zuulRoute);
        }
        return routesMap;
    }


}
