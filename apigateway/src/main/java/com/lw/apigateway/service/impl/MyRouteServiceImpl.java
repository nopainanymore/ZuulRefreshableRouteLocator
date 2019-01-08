package com.lw.apigateway.service.impl;

import com.lw.apigateway.dao.MyRouteMapper;
import com.lw.apigateway.entity.MyRoute;
import com.lw.apigateway.service.MyRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * apigateway: MyRouteServiceImpl
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:42
 * @since 1.0.0, 2019-01-05 09:42
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class MyRouteServiceImpl implements MyRouteService {

    private static Logger log = LoggerFactory.getLogger(MyRouteServiceImpl.class);

    private final MyRouteMapper myRouteMapper;

    public MyRouteServiceImpl(MyRouteMapper myRouteMapper) {
        this.myRouteMapper = myRouteMapper;
    }

    @Override
    public List<MyRoute> getAllLocalRouteList() {
        return myRouteMapper.selectList(null);
    }

    @Override
    public Integer add(MyRoute route) {
        return myRouteMapper.insert(route);
    }


}
