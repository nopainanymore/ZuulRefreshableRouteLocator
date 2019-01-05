package com.cnsuning.promes.apigateway.service.impl;

import com.cnsuning.promes.apigateway.dao.LocalRouteDao;
import com.cnsuning.promes.apigateway.entity.LocalRoute;
import com.cnsuning.promes.apigateway.service.LocalRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * apigateway: LocalRouteServiceImpl
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:42
 * @since 1.0.0, 2019-01-05 09:42
 */
@Service
public class LocalRouteServiceImpl implements LocalRouteService {

    private static Logger log = LoggerFactory.getLogger(LocalRouteServiceImpl.class);

    private final LocalRouteDao localRouteDao;

    public LocalRouteServiceImpl(LocalRouteDao localRouteDao) {
        this.localRouteDao = localRouteDao;
    }

    @Override
    public List<LocalRoute> getAllLocalRouteList() {
        return localRouteDao.findAll();
    }

    @Override
    public LocalRoute add(LocalRoute route) {
        return localRouteDao.save(route);
    }


}
