package com.sqisoft.mgapi.api.approval.service;

import com.sqisoft.mgapi.datasource.iqsbz3.dao.MenuRepository;
import com.sqisoft.mgapi.datasource.iqsbz3.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApprovalService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuVO> getTest() {
        return menuRepository.findAllBy();
    }

}
