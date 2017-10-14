package com.theBeautiful.core.rest;

import javax.ws.rs.Path;

/**
 * Created by jiaoli on 10/10/17
 */
public class ProductResource implements RestResource{

    @Override
    public String getBaseUrl() {
        return getClass().getAnnotation(Path.class).value();
    }

    @Override
    public String getName() {
        return "User Product service";
    }
}
