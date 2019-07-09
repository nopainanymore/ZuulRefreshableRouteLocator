package com.nopainanymore.apigateway.service.impl;


import com.nopainanymore.apigateway.dao.MyRouteMapper;
import com.nopainanymore.apigateway.entity.MyRoute;
import com.nopainanymore.apigateway.service.MyRouteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * api-gateway: MyRouteServiceImpl
 *
 * @author nopainanymore
 * @version 1.0.0, 2019-01-05 09:42
 * @since 1.0.0, 2019-01-05 09:42
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class MyRouteServiceImpl implements MyRouteService {

    private final MyRouteMapper myRouteMapper;

    @Autowired
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
