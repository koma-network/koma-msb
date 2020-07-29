/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/yypurdi/koma-auc
 * Description : This is the MSB Connector for Authentication & Control
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

package com.micro.msb.dao;

import com.micro.msb.beans.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package : com.micro.msb.dao for AuCDaoMapper
 * Class   : DaoMapper
 * @author : Yan Yan Purdiansah
 */

@Mapper 
public interface AuCDaoMapper {
    public MsbSessionSearchBean searchMsbSessionRosterAll(MsbSessionSearchBean input);
    public MsbSessionSearchBean searchMsbSessionRosterOnline(MsbSessionSearchBean input);
    public MsbSessionSearchBean searchMsbSessionRosterSubscriber(MsbSessionSearchBean input);	
}
