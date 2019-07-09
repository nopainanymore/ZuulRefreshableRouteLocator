
package com.nopainanymore.apigateway.controller;

import com.google.gson.Gson;

import com.nopainanymore.apigateway.RoutePublisher;
import com.nopainanymore.apigateway.entity.MyRoute;
import com.nopainanymore.apigateway.service.MyRouteService;
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
 * @author nopainanymore
 * @version 1.0.0, 2019-01-04 17:43
 * @since 1.0.0, 2019-01-04 17:43
 */
@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private Gson gson = new Gson();

    private final MyRouteService myRouteService;

    private final RoutePublisher routePublisher;

    private final ZuulHandlerMapping zuulHandlerMapping;

    @Autowired
    public ApiController(MyRouteService myRouteService, RoutePublisher routePublisher, ZuulHandlerMapping zuulHandlerMapping) {
        this.myRouteService = myRouteService;
        this.routePublisher = routePublisher;
        this.zuulHandlerMapping = zuulHandlerMapping;
    }

    @GetMapping("/hello")
    public String api() {
        log.info("success");
        return "success";
    }

    @GetMapping("/add")
    public String add(@RequestParam String api,
                      @RequestParam String path,
                      @RequestParam String url) {
        MyRoute myRoute = new MyRoute();
        myRoute.setId(api);
        myRoute.setPath(path);
        myRoute.setUrl(url);
        Integer route = myRouteService.add(myRoute);
        return gson.toJson(route);
    }

    @RequestMapping("/refreshRoute")
    public String refreshRoute() {
        routePublisher.refreshRoute();
        return "refreshRoute";
    }


    @RequestMapping("/watchNowRoute")
    public String watchNowRoute() {
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        Object map = handlerMap.get("handlerMap");
        return gson.toJson(map);
    }
}

