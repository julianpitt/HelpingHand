package org.govhack.helpinghand.api.handlers;

import org.govhack.helpinghand.api.response.BaseResponse;

/**
 * Created by James on 30-Jul-16.
 */
public interface IRequestHandler<T> {
    BaseResponse handleRequest(T request);
}
