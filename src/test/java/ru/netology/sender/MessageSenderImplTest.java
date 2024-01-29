package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    static GeoService geoService = Mockito.spy(GeoServiceImpl.class);
    static LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

    @Test
    void sendRuTest() {
        // given

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        // when

        String message = messageSender.send(headers);

        // then

        Assertions.assertEquals("Добро пожаловать", message);
    }

    @Test
    void sendUsTest() {
        // given

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        // when

        String message = messageSender.send(headers);

        // then

        Assertions.assertEquals("Welcome", message);
    }
}