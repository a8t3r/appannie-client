package ru.effector.responses;

import ru.effector.model.Country;
import ru.effector.model.Region;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 07.08.2015
 */
public class CountriesResponse extends BasicResponse {

    public List<Country> countryList;
    public List<Region> regionList;

}
