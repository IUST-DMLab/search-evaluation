/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.iust.dml.kg.evaluation.model;

import java.util.List;

/**
 *
 * @author r.farjamfard
 */
public class KnowledgeGraphResponse {
    private String query;
    List<String> UriList;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getUriList() {
        return UriList;
    }

    public void setUriList(List<String> UriList) {
        this.UriList = UriList;
    }


    
    
}
