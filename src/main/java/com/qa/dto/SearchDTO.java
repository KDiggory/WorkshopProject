package com.qa.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qa.service.ProjectsService.SearchType;

public class SearchDTO {

	private String searchTerm;
	 
    private SearchType searchType;
 
    public SearchDTO() {
 
    }
 
    public String getSearchTerm() {
        return searchTerm;
    }
 
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
 
    public SearchType getSearchType() {
        return searchType;
    }
 
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }
 
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}