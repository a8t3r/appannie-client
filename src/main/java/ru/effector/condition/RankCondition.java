package ru.effector.condition;

import ru.effector.model.Interval;
import ru.effector.utils.QueryParamsJsonSerializer;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class RankCondition {

    public String startDate;
    public String endDate;
    public Interval interval;

    @Override
    public String toString() {
        return QueryParamsJsonSerializer.getStringBuilder(this)
                .toString();
    }
}
