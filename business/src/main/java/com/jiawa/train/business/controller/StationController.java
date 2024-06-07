package com.jiawa.train.business.controller;

import com.jiawa.train.business.req.StationQueryReq;
import com.jiawa.train.business.resp.StationQueryResp;
import com.jiawa.train.business.service.StationService;
import com.jiawa.train.common.resp.CommonResp;
import com.jiawa.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Resource
    private StationService stationService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResp> list = stationService.queryList(req);
        return new CommonResp<>(list);
    }


}
