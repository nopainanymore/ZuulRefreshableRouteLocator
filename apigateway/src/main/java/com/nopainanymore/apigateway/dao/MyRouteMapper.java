package com.nopainanymore.apigateway.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nopainanymore.apigateway.entity.MyRoute;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * api-gateway: MyRouteMapper
 *
 * @author nopainanymore
 * @version 1.0.0, 2019-01-05 09:39
 * @since 1.0.0, 2019-01-05 09:39
 */
public interface MyRouteMapper extends BaseMapper<MyRoute> {

    List<MyRoute> getAllRoute();
}
