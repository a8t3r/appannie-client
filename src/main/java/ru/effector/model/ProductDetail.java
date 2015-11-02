package ru.effector.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.effector.utils.deserializers.CategoryPathJsonDeserializer;
import ru.effector.utils.deserializers.StringCommaListJsonDeserializer;

import java.util.Date;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductDetail {

    public Vertical vertical;
    public Market market;
    public Integer productId;
    public String productCode;
    public String productName;
    public String bundleId;
    public Integer publisherId;
    public String publisherName;
    public String icon;
    public String description;
    public String currentVersion;
    public Date releaseDate;
    public Date lastUpdate;
    public Boolean unpublished;
    public Integer price;
    public Boolean hasIAP;
    public String size;

    @JsonDeserialize(using = StringCommaListJsonDeserializer.class)
    public List<String> languages;

    public String mainCategory;

    @JsonDeserialize(using = StringCommaListJsonDeserializer.class)
    public List<String> otherCategories;

    @JsonDeserialize(using = CategoryPathJsonDeserializer.class)
    public List<String> mainCategoryPath;

    @JsonDeserialize(using = CategoryPathJsonDeserializer.class)
    public List<List<String>> otherCategoryPaths;


    public String originalIcon;
    public FamilySharing familySharing;
    public String seller;
    public List<String> appsInThisBundle;
    public List<String> bundlesContainThisApp;
    public String purchasedSeparatelyPrice;
    public String productType;
    public List<String> supportedDeviceList;

}
