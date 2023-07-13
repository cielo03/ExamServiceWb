package com.groupeisi.m2gl.dayfinder.vivorcelia.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "search_items")
public class SearchItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "search_date")
    private Date searchDate;

    @Column(name = "request")
    private String request;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "response_id")
    private DayResponse response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public DayResponse getResponse() {
        return response;
    }

    public void setResponse(DayResponse response) {
        this.response = response;
    }
}

