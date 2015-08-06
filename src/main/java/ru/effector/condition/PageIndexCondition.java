package ru.effector.condition;

import ru.effector.utils.QueryParamsJsonSerializer;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class PageIndexCondition {

    public Integer pageIndex;

    @Override
    public String toString() {
        return QueryParamsJsonSerializer.getStringBuilder(this)
                .toString();
    }
}
