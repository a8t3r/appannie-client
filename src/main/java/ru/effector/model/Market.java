package ru.effector.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public enum Market {

    ios,
    mac,
    google_play,
    amazon_appstore,
    windows_phone,
    windows_store,
    ibooks_store,
    kindle_store,
    adbuddiz,
    adcolony,
    admob,
    appdriver_jp,
    appia,
    appia_advertiser,
    applift,
    applift_advertiser,
    applovin,
    chartboost,
    clickky,
    facebook,
    flurry,
    fyber,
    fyber_advertiser,
    heyzap,
    iad,
    iad_workbench,
    inmobi,
    jampp,
    jumptap,
    jumptap_advertiser,
    leadbolt,
    leadbolt_advertiser,
    lifestreet,
    mdotm,
    mmedia,
    mobilecore,
    mobvista,
    nativex,
    nativex_advertiser,
    nend,
    playhaven,
    revmob,
    supersonic,
    tapit,
    tapjoy,
    taptica_advertiser,
    unilead,
    unity_ads,
    vungle
    ;

    public static Set<Market> withMinus = new HashSet<>(Arrays.asList(ibooks_store, kindle_store, google_play, amazon_appstore, windows_phone, windows_store));

    @Override
    public String toString() {
        if (withMinus.contains(this)) {
            return name().replace("_", "-");
        }

        return name();
    }
}
