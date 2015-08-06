package ru.effector;

import feign.Feign;
import feign.Target;
import ru.effector.interfaces.Accounts;
import ru.effector.interfaces.Products;
import ru.effector.interfaces.Sharings;
import ru.effector.utils.FeignBuilder;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class AppannieClient {

    public static final String serverUrl = "http://api.appannie.com/v1.2/";

    private final Feign feign;

    public AppannieClient(String token) {
        this.feign = FeignBuilder.build(token);
    }

    public Accounts accounts() {
        return build(Accounts.class);
    }

    public Sharings sharings() {
        return build(Sharings.class);
    }

    public Products products() {
        return build(Products.class);
    }

    public  <T> T build(Class<T> serviceInterface) {
        return feign.newInstance(new Target.HardCodedTarget<T>(serviceInterface, serverUrl));
    }
}
