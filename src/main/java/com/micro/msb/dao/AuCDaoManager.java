/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/koma-network/koma-msb
 * Description : This is the MSB Connector for Authentication & Control
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

package com.micro.msb.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.micro.msb.beans.*;

/**
 * Package : com.micro.msb.dao for myBatis
 * Class   : AuCDaoManager
 * @author : Yan Yan Purdiansah
 */
@Component
public class AuCDaoManager {

    protected SqlSession sqlSession;
    
    public AuCDaoManager(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public MsbSessionSearchBean searchMsbSessionRosterAll(MsbSessionSearchBean input) {
        List<MsbSessionBean> output = new ArrayList<MsbSessionBean>();
        output = sqlSession.selectList("searchMsbSessionRosterAll", input);
        input.setMsbSession(output);
        return input;
    }

    public MsbSessionSearchBean searchMsbSessionRosterOnline(MsbSessionSearchBean input) {
        List<MsbSessionBean> output = new ArrayList<MsbSessionBean>();
        output = sqlSession.selectList("searchMsbSessionRosterOnline", input);
        input.setMsbSession(output);
        return input;
    }
    
    public MsbSessionSearchBean searchMsbSessionRosterSubscriber(MsbSessionSearchBean input) {
        List<MsbSessionBean> output = new ArrayList<MsbSessionBean>();
        output = sqlSession.selectList("searchMsbSessionRosterSubscriber", input);
        input.setMsbSession(output);
        return input;
    }
 
    public MsbSessionDeleteBean deleteMsbSessionOldRecords(MsbSessionDeleteBean input) {
        MsbSessionDeleteBean output = new MsbSessionDeleteBean();
        int ret = sqlSession.delete("deleteMsbSessionOldRecords", input);
        if (ret == 0) {
            return output;
        } else {
            return input;
        }
    }    
}
