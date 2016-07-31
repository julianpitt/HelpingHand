package org.govhack.helpinghand.dataservice;

import org.govhack.helpinghand.dataservice.data.DataUsageItem;
import org.govhack.helpinghand.persistance.entities.SuburbUsageEntity;
import org.govhack.helpinghand.persistance.respositories.SuburbDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 30-Jul-16.
 */
@Component
public class UsageService {

    @Autowired
    SuburbDAO suburbDAO;

    public UsageService() {}

    public List<DataUsageItem> calculateDataUsageForZone(double latitude, double longtitude, int zoom, String type) {
        List<SuburbUsageEntity> usages = suburbDAO.getAllSuburbUsage();
        List<DataUsageItem> dataUsageItems = new ArrayList<>();
        for(SuburbUsageEntity usageEntity : usages) {
            dataUsageItems.add(new DataUsageItem(
                    usageEntity.getSuburb().getLongtitude(),
                    usageEntity.getSuburb().getLatitude(),
                    usageEntity.getSuburb().getZoom(),
                    (int)(usageEntity.getValue()),
                    usageEntity.getUsageType().getUsageTypeCode()));
        }
        return dataUsageItems;
    }

    private List<DataUsageItem> generateDummyItems(String type) {
        List<DataUsageItem> dataUsageItems = new ArrayList<DataUsageItem>();

        // Adding Dummy Data Items for Development of Map Plugins

        switch (type.toUpperCase()) {
            case "GAS":
                DataUsageItem d1 = new DataUsageItem();
                d1.setZone(10);
                d1.setValue(80000d);
                d1.setLat(-36.2253229);
                d1.setLng(143.8110939);
                d1.setType("GAS");
                dataUsageItems.add(d1);
                DataUsageItem d2 = new DataUsageItem();
                d2.setZone(10);
                d2.setLat(-37.6690772);
                d2.setValue(126541d);
                d2.setLng(145.6743077);
                d2.setType("GAS");
                dataUsageItems.add(d2);
                DataUsageItem d3 = new DataUsageItem();
                d3.setZone(10);
                d3.setValue(95465d);
                d3.setLat(-37.0961944);
                d3.setLng(146.270316);
                d3.setType("GAS");
                dataUsageItems.add(d3);
                break;
            case "ELECTRICITY":
                DataUsageItem d4 = new DataUsageItem();
                d4.setZone(10);
                d4.setLat(-35.9807133);
                d4.setValue(84855d);
                d4.setLng(147.7603367);
                d4.setType("ELECTRICITY");
                dataUsageItems.add(d4);
                DataUsageItem d5 = new DataUsageItem();
                d5.setZone(10);
                d5.setLat(-31.2996163);
                d5.setLng(146.0644425);
                d5.setValue(96458d);
                d5.setType("ELECTRICITY");
                dataUsageItems.add(d5);
                DataUsageItem d6 = new DataUsageItem();
                d6.setZone(10);
                d6.setLat(-27.8463346);
                d6.setLng(142.701254);
                d6.setValue(10200d);
                d6.setType("ELECTRICITY");
                dataUsageItems.add(d6);
                DataUsageItem d7 = new DataUsageItem();
                d7.setZone(10);
                d7.setLat(-29.0400719);
                d7.setValue(98548d);
                d7.setLng(142.1341367);
                d7.setType("ELECTRICITY");
                dataUsageItems.add(d7);
                break;
            case "WATER":
                DataUsageItem d8 = new DataUsageItem();
                d8.setZone(10);
                d8.setLat(-25.9115837);
                d8.setValue(98574d);
                d8.setLng(149.6385146);
                d8.setType("WATER");
                dataUsageItems.add(d8);
                DataUsageItem d9 = new DataUsageItem();
                d9.setZone(10);
                d9.setLat(-33.3730549);
                d9.setValue(96525d);
                d9.setLng(148.3350889);
                d9.setType("WATER");
                dataUsageItems.add(d9);
                DataUsageItem d10 = new DataUsageItem();
                d10.setZone(10);
                d10.setLat(-35.1196128);
                d10.setLng(144.9635568);
                d10.setValue(145000d);
                d10.setType("WATER");
                dataUsageItems.add(d10);
                break;
            case "HOMELESSNESS":
                DataUsageItem d11 = new DataUsageItem();
                d11.setZone(10);
                d11.setLat(-26.9663198);
                d11.setValue(87000d);
                d11.setLng(146.8406093);
                d11.setType("HOMELESSNESS");
                dataUsageItems.add(d11);
                DataUsageItem d12 = new DataUsageItem();
                d12.setZone(10);
                d12.setValue(140351d);
                d12.setLat(-21.7953931);
                d12.setLng(148.1479823);
                d12.setType("HOMELESSNESS");
                dataUsageItems.add(d12);
                DataUsageItem d13 = new DataUsageItem();
                d13.setZone(10);
                d13.setValue(135000d);
                d13.setLat(-19.8547485);
                d13.setLng(145.6870448);
                d13.setType("HOMELESSNESS");
                dataUsageItems.add(d13);
                break;
            default:
                break;
        }

        return dataUsageItems;
    }
}
