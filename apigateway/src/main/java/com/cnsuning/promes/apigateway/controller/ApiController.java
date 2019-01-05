
package com.cnsuning.promes.apigateway.controller;

import com.cnsuning.promes.apigateway.RoutePublisher;
import com.cnsuning.promes.apigateway.entity.LocalRoute;
import com.cnsuning.promes.apigateway.service.LocalRouteService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * apigateway: ApiController
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-04 17:43
 * @since 1.0.0, 2019-01-04 17:43
 */

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private Gson gson = new Gson();

    @Autowired
    LocalRouteService localRouteService;

    @Autowired
    RoutePublisher routePublisher;

    @GetMapping("/hello")
    public String api() {
        log.info("success");
        return "success";
    }

    @GetMapping("/add")
    public String add(@RequestParam String api,
                      @RequestParam String path,
                      @RequestParam String url) {
        LocalRoute localRoute = new LocalRoute();
        localRoute.setId(api);
        localRoute.setPath(path);
        localRoute.setUrl(url);
        LocalRoute route = localRouteService.add(localRoute);
        return gson.toJson(route);
    }

    @RequestMapping("/refreshRoute")
    public String refreshRoute() {
        routePublisher.refreshRoute();
        return "refreshRoute";
    }

    @Autowired
    ZuulHandlerMapping zuulHandlerMapping;

    @RequestMapping("/watchNowRoute")
    public String watchNowRoute() {
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        Object map = handlerMap.get("handlerMap");
        return gson.toJson(map);
    }
}

