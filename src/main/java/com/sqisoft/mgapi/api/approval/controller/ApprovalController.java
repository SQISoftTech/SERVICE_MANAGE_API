package com.sqisoft.mgapi.api.approval.controller;

import com.sqisoft.mgapi.api.approval.service.ApprovalService;
import com.sqisoft.mgapi.datasource.iqsbz3.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
//@RefreshScope // RefreshScope 어노테이션 주석처리하니 gateway에 붙었음 확인 필요...
@RequestMapping("/approve")
public class ApprovalController {

    @Autowired
    ApprovalService approveService;

    @GetMapping("/test")
    public List<MenuVO> getTest() {
        return approveService.getTest();
    }
}
