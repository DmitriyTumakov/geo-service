package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    static LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

    @Test
    void localeRuTest() {
        // when

        String localeRu = localizationService.locale(Country.RUSSIA);

        //then

        Assertions.assertEquals("Добро пожаловать", localeRu);
    }

    @Test
    void localeUsTest() {
        // when

        String localeUs = localizationService.locale(Country.USA);

        //then

        Assertions.assertEquals("Welcome", localeUs);
    }
}