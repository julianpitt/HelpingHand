package org.govhack.helpinghand.api.response;

import org.govhack.helpinghand.dataservice.data.DataUsageItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by James on 30-Jul-16.
 */
public class UsageResponse extends BaseResponse {
    public UsageResponse() {
        super();
        dataUsageItems = Arrays.asList();
    }

    private List<DataUsageItem> dataUsageItems;

    public List<DataUsageItem> getDataUsageItem() {
        return dataUsageItems;
    }

    public void setDataUsageItems(List<DataUsageItem> dataUsageItems) {
        this.dataUsageItems = dataUsageItems;
    }
}
