package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.train.common.context.LoginMemberContext;
import com.jiawa.train.common.resp.PageResp;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Passenger;
import com.jiawa.train.member.domain.PassengerExample;
import com.jiawa.train.member.mapper.PassengerMapper;
import com.jiawa.train.member.req.PassengerQueryReq;
import com.jiawa.train.member.req.PassengerSaveReq;
import com.jiawa.train.member.resp.PassengerQueryResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final static Logger LOG = LoggerFactory.getLogger(PassengerService.class);
    @Autowired
    private PassengerMapper passengerMapper;
    public void save(PassengerSaveReq req){
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        if(ObjectUtil.isNull(passenger.getId())) {
            passenger.setMemberId(LoginMemberContext.getId());
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerMapper.insert(passenger);
        }else{
            passenger.setUpdateTime(now);
            passenger.setCreateTime(passengerMapper.selectByPrimaryKey(passenger.getId()).getCreateTime());
            passengerMapper.updateByPrimaryKey(passenger);
        }

    }

    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req){
        PassengerExample passengerExample = new PassengerExample();
        passengerExample.setOrderByClause("id desc");
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if (ObjUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        LOG.info("查询页码：{}",req.getPage());
        LOG.info("每页条数：{}",req.getSize());
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        PageInfo<Passenger> pageInfo = new PageInfo<>(passengers);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
        List<PassengerQueryResp> list = BeanUtil.copyToList(passengers, PassengerQueryResp.class);
        PageResp<PassengerQueryResp> passengerQueryRespPageResp = new PageResp<>();
        passengerQueryRespPageResp.setList(list);
        passengerQueryRespPageResp.setTotal(pageInfo.getTotal());
        return passengerQueryRespPageResp;
    }

    public void delete(Long id) {
        passengerMapper.deleteByPrimaryKey(id);
    }
}
