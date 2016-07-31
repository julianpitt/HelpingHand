package org.govhack.helpinghand.api.handlers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.govhack.helpinghand.api.request.UsageRequest;
import org.govhack.helpinghand.api.response.UsageResponse;
import org.govhack.helpinghand.dataservice.UsageService;
import org.govhack.helpinghand.dataservice.data.DataUsageItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by James on 30-Jul-16.
 */
public class UsageRequestHandler extends BaseRequestHandler<UsageRequest> {

    public UsageRequestHandler() {}

    public UsageResponse handleRequest(UsageRequest usageRequest) {
        UsageResponse usageResponse = new UsageResponse();
        List<DataUsageItem> items = (new UsageService()).calculateDataUsageForZone(usageRequest.getLatitude(), usageRequest.getLongtitude(), usageRequest.getZoomLevel(), usageRequest.getType());
        usageResponse.setDataUsageItems(items);
        return usageResponse;
    }
}
