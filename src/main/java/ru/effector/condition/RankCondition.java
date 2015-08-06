package ru.effector.condition;

import ru.effector.model.Device;
import ru.effector.model.Interval;
import ru.effector.utils.QueryParamsJsonSerializer;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class RankCondition extends BaseCondition {

    public Interval interval;
    public String category;
    public String feed;
    public Device device;

    @Override
    public String toString() {
        return QueryParamsJsonSerializer.getStringBuilder(this)
                .toString();
    }
}
