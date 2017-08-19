package org.lucius.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;

public class IPUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtils.class);
    private static DatabaseReader reader;
    private static InputStream resourceAsStream = null;
    static {
        try {
            resourceAsStream = IPUtils.class.getResourceAsStream("/geoip-db/GeoLite2-City.mmdb");
            reader = new DatabaseReader.Builder(resourceAsStream).withCache(new CHMCache()).build();
        } catch (IOException e) {
            LOGGER.error("初始化GEO-IP Reader", e);
            try {
                resourceAsStream.close();
            } catch (IOException e1) {
                resourceAsStream = null;
            }
        }
    }

    public static org.lucius.commons.utils.model.Region getCity(String ipAddr, String language) {
        org.lucius.commons.utils.model.Region city = new org.lucius.commons.utils.model.Region();
        String lancode = language;
        try {
            if (StringUtils.isBlank(language)) {
                lancode = "zh-CN";
            }
            InetAddress ipAddress = InetAddress.getByName(ipAddr);
            CityResponse response = reader.city(ipAddress);
            Country geocountry = response.getCountry();
            City geocity = response.getCity();
            city.setCity(geocity.getNames().get(lancode));
            city.setCountry(geocountry.getNames().get(lancode));
        } catch (Exception e) {
            city.setCity("unkown");
            city.setCountry("unkown");
            LOGGER.error("根据IP获取国家城市出现错误", e);
        }
        return city;
    }

}
