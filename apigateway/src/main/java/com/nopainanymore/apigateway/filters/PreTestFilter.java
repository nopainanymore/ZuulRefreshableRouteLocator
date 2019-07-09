package com.nopainanymore.apigateway.filters;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nopainanymore
 * @create 2019/1/5  23:14
 **/
public class PreTestFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PreTestFilter.class);

    private static final Gson gson = new Gson();

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("this is pre filter");
        return null;
    }
}
