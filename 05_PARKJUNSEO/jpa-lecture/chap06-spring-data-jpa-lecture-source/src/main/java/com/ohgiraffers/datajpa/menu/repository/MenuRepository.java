package com.ohgiraffers.datajpa.menu.repository;

import com.ohgiraffers.datajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {



}
