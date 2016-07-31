package org.govhack.helpinghand.api.handlers;

import org.govhack.helpinghand.api.response.BaseResponse;
import org.govhack.helpinghand.api.response.UsageResponse;

/**
 * Created by James on 30-Jul-16.
 */
public class BaseRequestHandler<T> implements IRequestHandler<T> {
    @Override
    public BaseResponse handleRequest(T request) {
        return new BaseResponse();
    }
}
