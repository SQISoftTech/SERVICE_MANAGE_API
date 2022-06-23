package com.sqisoft.mgapi.datasource.iqsbz3.dao;

import com.sqisoft.mgapi.datasource.iqsbz3.vo.MenuVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuRepository extends JpaRepository<MenuVO, Long> {
    List<MenuVO> findAllBy();
}
