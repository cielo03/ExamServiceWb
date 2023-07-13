package com.groupeisi.m2gl.dayfinder.vivorcelia.service;

import com.groupeisi.m2gl.dayfinder.vivorcelia.model.DayResponse;
import com.groupeisi.m2gl.dayfinder.vivorcelia.model.SearchItem;
import com.groupeisi.m2gl.dayfinder.vivorcelia.repository.SearchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DayFinderService {

    @Autowired
    private SearchItemRepository searchItemRepository;

    public String getDayOfWeek(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(date);
    }

    public void saveSearchItem(String request, DayResponse response) {
        SearchItem searchItem = new SearchItem();
        searchItem.setRequest(request);
        searchItem.setResponse(response);
        searchItem.setSearchDate(new Date());
        searchItemRepository.save(searchItem);
    }

    public List<SearchItem> getHistorique() {
        return searchItemRepository.findAll();
    }
}

