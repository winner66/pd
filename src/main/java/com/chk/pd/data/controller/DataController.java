package com.chk.pd.data.controller;

import com.chk.pd.common.vo.Response;
import com.chk.pd.data.service.DataService;
import com.chk.pd.data.vo.DataCVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/collect")
    public Response collect(@RequestBody DataCVo vo) {
        dataService.insert(vo);
        return Response.ok();
    }
}
