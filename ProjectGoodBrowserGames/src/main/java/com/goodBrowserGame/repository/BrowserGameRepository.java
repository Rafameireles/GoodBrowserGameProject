package com.goodBrowserGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodBrowserGame.entity.BrowserGameEntity;

@Repository
public interface BrowserGameRepository extends JpaRepository<BrowserGameEntity, Long> {

}
