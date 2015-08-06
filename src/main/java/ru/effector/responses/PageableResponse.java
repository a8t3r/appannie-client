package ru.effector.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class PageableResponse extends BasicResponse {

    @JsonProperty("page_num")
    public int pageNum;

    @JsonProperty("page_index")
    public int pageIndex;

    @JsonProperty("prev_page")
    public String prevPage;

    @JsonProperty("next_page")
    public String nextPage;

}
