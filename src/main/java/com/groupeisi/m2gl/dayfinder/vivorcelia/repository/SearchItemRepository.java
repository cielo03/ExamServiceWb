package com.groupeisi.m2gl.dayfinder.vivorcelia.repository;

import com.groupeisi.m2gl.dayfinder.vivorcelia.model.SearchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchItemRepository extends JpaRepository<SearchItem, Long> {
}

