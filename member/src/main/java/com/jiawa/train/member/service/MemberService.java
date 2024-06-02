package com.jiawa.train.member.service;

import com.jiawa.train.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    public int count(){
        int count = memberMapper.count();
        return count;
    }
}
