package ru.netology.geo;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationService;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    GeoService geoService = new GeoServiceImpl();
    static String[] ip = {"172.0.32.11", "172.6.53.45", "96.44.183.149", "96.65.312.453"};

    @Test
    void byIpRuTest() {
        for (int i = 0; i < ip.length; i++) {
            Location location = geoService.byIp(ip[i]);
            if (ip[i].startsWith("172")) {
                Assertions.assertEquals(Country.RUSSIA, location.getCountry());
            } else {
                Assertions.assertEquals(Country.USA, location.getCountry());
            }
        }
    }
}