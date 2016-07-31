package org.govhack.helpinghand.api.controllers;

import org.govhack.helpinghand.api.handlers.UsageRequestHandler;
import org.govhack.helpinghand.api.request.UsageRequest;
import org.govhack.helpinghand.api.response.BaseResponse;
import org.govhack.helpinghand.api.response.UsageResponse;
import org.govhack.helpinghand.dataservice.data.DataUsageItem;
import org.govhack.helpinghand.persistance.entities.SuburbEntity;
import org.govhack.helpinghand.persistance.entities.SuburbUsageEntity;
import org.govhack.helpinghand.persistance.respositories.SuburbDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 30-Jul-16.
 */
@RestController
public class UsageController {

    @Autowired
    SuburbDAO suburbDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/usage/get/{long}/{lat}/{zoom}/{type}", produces = "application/json")
    public UsageResponse getUsage(@PathVariable("long") double longtitude, @PathVariable("lat") double latitude, @PathVariable("zoom") int zoomLevel, @PathVariable("type") String type) {
        List<SuburbUsageEntity> usages = suburbDAO.getAllSuburbUsage();
        List<DataUsageItem> dataUsageItems = new ArrayList<>();
        for(SuburbUsageEntity usageEntity : usages) {
            if(type.equalsIgnoreCase(usageEntity.getUsageType().getUsageTypeCode())) {
                dataUsageItems.add(new DataUsageItem(
                        usageEntity.getSuburb().getLongtitude(),
                        usageEntity.getSuburb().getLatitude(),
                        usageEntity.getSuburb().getZoom(),
                        (long)(Math.round(usageEntity.getValue()) /5000),
                        usageEntity.getUsageType().getUsageTypeCode()));
            }
        }
        UsageResponse usageResponse = new UsageResponse();
        usageResponse.setDataUsageItems(dataUsageItems);
        return usageResponse;
        //return (new UsageRequestHandler()).handleRequest(new UsageRequest(longtitude, latitude, zoomLevel, type));
    }

    @RequestMapping(method = RequestMethod.GET, value="/get/suburb", produces = "application/json")
    public BaseResponse getSuburb() {
        SuburbEntity sub = suburbDAO.getSuburb(3);
        return new BaseResponse(sub.getSuburbName(), "");
    }
}
