package com.jiawa.train.member.controller;

import com.jiawa.train.common.resp.CommonResp;
import com.jiawa.train.member.req.PassengerSaveReq;
import com.jiawa.train.member.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    //使用Postman的api记住登录token，const result = JSON.parse(responseBody) pm.globals.set("token",result.content.token)
    //在login请求中将登录产生的token放入Postman中的全局变量
    //在save请求头中用{{token}}获取全局变量中的token
    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req){
        passengerService.save(req);
        return new CommonResp<>();
    }

}
