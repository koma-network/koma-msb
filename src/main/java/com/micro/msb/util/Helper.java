/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micro.msb.util;

import com.micro.msb.beans.MsbSessionReadBean;
import com.micro.msb.beans.MsbSessionWriteBean;

/**
 *
 * @author T420
 */
public class Helper {
    
    public static MsbSessionWriteBean toMsbSessionWriteBean(MsbSessionReadBean session){
        MsbSessionWriteBean bean = new MsbSessionWriteBean();
        bean.setSessionid(session.getSessionid());
        bean.setSubscriber(session.getSubscriber());
        bean.setDomain(session.getDomain());
        bean.setIpaddress(session.getIpaddress());
        bean.setIpport(session.getIpport());
        bean.setProtocol(session.getProtocol());
        bean.setStarttime(session.getStarttime());
        bean.setEndtime(session.getEndtime());
        bean.setResource(session.getResource());
        bean.setPresence(session.getPresence());
        bean.setStatus(session.getStatus());
        return bean;
    }
}
