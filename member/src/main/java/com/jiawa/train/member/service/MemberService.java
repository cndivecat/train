package com.jiawa.train.member.service;

import com.jiawa.train.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    public long countByExample(){
        return memberMapper.countByExample(null);
    }
}
