package com.micro.msb.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.micro.msb.beans.*;

/**
 * Package : com.micro.msb.dao for myBatis
 * Class   : DaoManager
 * @author : Yan Yan Purdiansah
 */

@Component 
public class DaoManager {

	private final SqlSession sqlSession;

	public DaoManager(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Integer countMsbAccountSearch(MsbAccountSearchBean input){
		return sqlSession.selectOne("countMsbAccountSearch",input);
	}
	
	public MsbAccountSearchBean searchMsbAccount(MsbAccountSearchBean input){
       List<MsbAccountBean> output = new ArrayList<MsbAccountBean>();       
       output = sqlSession.selectList("searchMsbAccount", input);
       input.setMsbAccount(output);
       return input;	
	}
	
	public Integer countMsbAffiliationSearch(MsbAffiliationSearchBean input){
		return sqlSession.selectOne("countMsbAffiliationSearch",input);
	}
	
	public MsbAffiliationSearchBean searchMsbAffiliation(MsbAffiliationSearchBean input){
       List<MsbAffiliationBean> output = new ArrayList<MsbAffiliationBean>();       
       output = sqlSession.selectList("searchMsbAffiliation", input);
       input.setMsbAffiliation(output);
       return input;	
	}
	
	public Integer countMsbAuthoritiesSearch(MsbAuthoritiesSearchBean input){
		return sqlSession.selectOne("countMsbAuthoritiesSearch",input);
	}
	
	public MsbAuthoritiesSearchBean searchMsbAuthorities(MsbAuthoritiesSearchBean input){
       List<MsbAuthoritiesBean> output = new ArrayList<MsbAuthoritiesBean>();       
       output = sqlSession.selectList("searchMsbAuthorities", input);
       input.setMsbAuthorities(output);
       return input;	
	}
	
	public Integer countMsbMenusSearch(MsbMenusSearchBean input){
		return sqlSession.selectOne("countMsbMenusSearch",input);
	}
	
	public MsbMenusSearchBean searchMsbMenus(MsbMenusSearchBean input){
       List<MsbMenusBean> output = new ArrayList<MsbMenusBean>();       
       output = sqlSession.selectList("searchMsbMenus", input);
       input.setMsbMenus(output);
       return input;	
	}
	
	public Integer countMsbMucaffiliationSearch(MsbMucaffiliationSearchBean input){
		return sqlSession.selectOne("countMsbMucaffiliationSearch",input);
	}
	
	public MsbMucaffiliationSearchBean searchMsbMucaffiliation(MsbMucaffiliationSearchBean input){
       List<MsbMucaffiliationBean> output = new ArrayList<MsbMucaffiliationBean>();       
       output = sqlSession.selectList("searchMsbMucaffiliation", input);
       input.setMsbMucaffiliation(output);
       return input;	
	}
	
	public Integer countMsbMucmemberSearch(MsbMucmemberSearchBean input){
		return sqlSession.selectOne("countMsbMucmemberSearch",input);
	}
	
	public MsbMucmemberSearchBean searchMsbMucmember(MsbMucmemberSearchBean input){
       List<MsbMucmemberBean> output = new ArrayList<MsbMucmemberBean>();       
       output = sqlSession.selectList("searchMsbMucmember", input);
       input.setMsbMucmember(output);
       return input;	
	}
	
	public Integer countMsbMucroomSearch(MsbMucroomSearchBean input){
		return sqlSession.selectOne("countMsbMucroomSearch",input);
	}
	
	public MsbMucroomSearchBean searchMsbMucroom(MsbMucroomSearchBean input){
       List<MsbMucroomBean> output = new ArrayList<MsbMucroomBean>();       
       output = sqlSession.selectList("searchMsbMucroom", input);
       input.setMsbMucroom(output);
       return input;	
	}
	
	public Integer countMsbMucroompropSearch(MsbMucroompropSearchBean input){
		return sqlSession.selectOne("countMsbMucroompropSearch",input);
	}
	
	public MsbMucroompropSearchBean searchMsbMucroomprop(MsbMucroompropSearchBean input){
       List<MsbMucroompropBean> output = new ArrayList<MsbMucroompropBean>();       
       output = sqlSession.selectList("searchMsbMucroomprop", input);
       input.setMsbMucroomprop(output);
       return input;	
	}
	
	public Integer countMsbMucserviceSearch(MsbMucserviceSearchBean input){
		return sqlSession.selectOne("countMsbMucserviceSearch",input);
	}
	
	public MsbMucserviceSearchBean searchMsbMucservice(MsbMucserviceSearchBean input){
       List<MsbMucserviceBean> output = new ArrayList<MsbMucserviceBean>();       
       output = sqlSession.selectList("searchMsbMucservice", input);
       input.setMsbMucservice(output);
       return input;	
	}
	
	public Integer countMsbMucservicepropSearch(MsbMucservicepropSearchBean input){
		return sqlSession.selectOne("countMsbMucservicepropSearch",input);
	}
	
	public MsbMucservicepropSearchBean searchMsbMucserviceprop(MsbMucservicepropSearchBean input){
       List<MsbMucservicepropBean> output = new ArrayList<MsbMucservicepropBean>();       
       output = sqlSession.selectList("searchMsbMucserviceprop", input);
       input.setMsbMucserviceprop(output);
       return input;	
	}
	
	public Integer countMsbOfflineSearch(MsbOfflineSearchBean input){
		return sqlSession.selectOne("countMsbOfflineSearch",input);
	}
	
	public MsbOfflineSearchBean searchMsbOffline(MsbOfflineSearchBean input){
       List<MsbOfflineBean> output = new ArrayList<MsbOfflineBean>();       
       output = sqlSession.selectList("searchMsbOffline", input);
       input.setMsbOffline(output);
       return input;	
	}
	
	public Integer countMsbPersistentLoginsSearch(MsbPersistentLoginsSearchBean input){
		return sqlSession.selectOne("countMsbPersistentLoginsSearch",input);
	}
	
	public MsbPersistentLoginsSearchBean searchMsbPersistentLogins(MsbPersistentLoginsSearchBean input){
       List<MsbPersistentLoginsBean> output = new ArrayList<MsbPersistentLoginsBean>();       
       output = sqlSession.selectList("searchMsbPersistentLogins", input);
       input.setMsbPersistentLogins(output);
       return input;	
	}
	
	public Integer countMsbPresenceSearch(MsbPresenceSearchBean input){
		return sqlSession.selectOne("countMsbPresenceSearch",input);
	}
	
	public MsbPresenceSearchBean searchMsbPresence(MsbPresenceSearchBean input){
       List<MsbPresenceBean> output = new ArrayList<MsbPresenceBean>();       
       output = sqlSession.selectList("searchMsbPresence", input);
       input.setMsbPresence(output);
       return input;	
	}
	
	public Integer countMsbPropertySearch(MsbPropertySearchBean input){
		return sqlSession.selectOne("countMsbPropertySearch",input);
	}
	
	public MsbPropertySearchBean searchMsbProperty(MsbPropertySearchBean input){
       List<MsbPropertyBean> output = new ArrayList<MsbPropertyBean>();       
       output = sqlSession.selectList("searchMsbProperty", input);
       input.setMsbProperty(output);
       return input;	
	}
	
	public Integer countMsbPubsubSearch(MsbPubsubSearchBean input){
		return sqlSession.selectOne("countMsbPubsubSearch",input);
	}
	
	public MsbPubsubSearchBean searchMsbPubsub(MsbPubsubSearchBean input){
       List<MsbPubsubBean> output = new ArrayList<MsbPubsubBean>();       
       output = sqlSession.selectList("searchMsbPubsub", input);
       input.setMsbPubsub(output);
       return input;	
	}
	
	public Integer countMsbPubsubaffiliationSearch(MsbPubsubaffiliationSearchBean input){
		return sqlSession.selectOne("countMsbPubsubaffiliationSearch",input);
	}
	
	public MsbPubsubaffiliationSearchBean searchMsbPubsubaffiliation(MsbPubsubaffiliationSearchBean input){
       List<MsbPubsubaffiliationBean> output = new ArrayList<MsbPubsubaffiliationBean>();       
       output = sqlSession.selectList("searchMsbPubsubaffiliation", input);
       input.setMsbPubsubaffiliation(output);
       return input;	
	}
	
	public Integer countMsbPubsubitemSearch(MsbPubsubitemSearchBean input){
		return sqlSession.selectOne("countMsbPubsubitemSearch",input);
	}
	
	public MsbPubsubitemSearchBean searchMsbPubsubitem(MsbPubsubitemSearchBean input){
       List<MsbPubsubitemBean> output = new ArrayList<MsbPubsubitemBean>();       
       output = sqlSession.selectList("searchMsbPubsubitem", input);
       input.setMsbPubsubitem(output);
       return input;	
	}
	
	public Integer countMsbPubsubnodeSearch(MsbPubsubnodeSearchBean input){
		return sqlSession.selectOne("countMsbPubsubnodeSearch",input);
	}
	
	public MsbPubsubnodeSearchBean searchMsbPubsubnode(MsbPubsubnodeSearchBean input){
       List<MsbPubsubnodeBean> output = new ArrayList<MsbPubsubnodeBean>();       
       output = sqlSession.selectList("searchMsbPubsubnode", input);
       input.setMsbPubsubnode(output);
       return input;	
	}
	
	public Integer countMsbPubsubnodegroupsSearch(MsbPubsubnodegroupsSearchBean input){
		return sqlSession.selectOne("countMsbPubsubnodegroupsSearch",input);
	}
	
	public MsbPubsubnodegroupsSearchBean searchMsbPubsubnodegroups(MsbPubsubnodegroupsSearchBean input){
       List<MsbPubsubnodegroupsBean> output = new ArrayList<MsbPubsubnodegroupsBean>();       
       output = sqlSession.selectList("searchMsbPubsubnodegroups", input);
       input.setMsbPubsubnodegroups(output);
       return input;	
	}
	
	public Integer countMsbPubsubsubscriberSearch(MsbPubsubsubscriberSearchBean input){
		return sqlSession.selectOne("countMsbPubsubsubscriberSearch",input);
	}
	
	public MsbPubsubsubscriberSearchBean searchMsbPubsubsubscriber(MsbPubsubsubscriberSearchBean input){
       List<MsbPubsubsubscriberBean> output = new ArrayList<MsbPubsubsubscriberBean>();       
       output = sqlSession.selectList("searchMsbPubsubsubscriber", input);
       input.setMsbPubsubsubscriber(output);
       return input;	
	}
	
	public Integer countMsbPubsubsubscriptionSearch(MsbPubsubsubscriptionSearchBean input){
		return sqlSession.selectOne("countMsbPubsubsubscriptionSearch",input);
	}
	
	public MsbPubsubsubscriptionSearchBean searchMsbPubsubsubscription(MsbPubsubsubscriptionSearchBean input){
       List<MsbPubsubsubscriptionBean> output = new ArrayList<MsbPubsubsubscriptionBean>();       
       output = sqlSession.selectList("searchMsbPubsubsubscription", input);
       input.setMsbPubsubsubscription(output);
       return input;	
	}
	
	public Integer countMsbRemoteserverSearch(MsbRemoteserverSearchBean input){
		return sqlSession.selectOne("countMsbRemoteserverSearch",input);
	}
	
	public MsbRemoteserverSearchBean searchMsbRemoteserver(MsbRemoteserverSearchBean input){
       List<MsbRemoteserverBean> output = new ArrayList<MsbRemoteserverBean>();       
       output = sqlSession.selectList("searchMsbRemoteserver", input);
       input.setMsbRemoteserver(output);
       return input;	
	}
	
	public Integer countMsbRevenueSearch(MsbRevenueSearchBean input){
		return sqlSession.selectOne("countMsbRevenueSearch",input);
	}
	
	public MsbRevenueSearchBean searchMsbRevenue(MsbRevenueSearchBean input){
       List<MsbRevenueBean> output = new ArrayList<MsbRevenueBean>();       
       output = sqlSession.selectList("searchMsbRevenue", input);
       input.setMsbRevenue(output);
       return input;	
	}
	
	public Integer countMsbRosterSearch(MsbRosterSearchBean input){
		return sqlSession.selectOne("countMsbRosterSearch",input);
	}
	
	public MsbRosterSearchBean searchMsbRoster(MsbRosterSearchBean input){
       List<MsbRosterBean> output = new ArrayList<MsbRosterBean>();       
       output = sqlSession.selectList("searchMsbRoster", input);
       input.setMsbRoster(output);
       return input;	
	}
	
	public Integer countMsbRostergroupsSearch(MsbRostergroupsSearchBean input){
		return sqlSession.selectOne("countMsbRostergroupsSearch",input);
	}
	
	public MsbRostergroupsSearchBean searchMsbRostergroups(MsbRostergroupsSearchBean input){
       List<MsbRostergroupsBean> output = new ArrayList<MsbRostergroupsBean>();       
       output = sqlSession.selectList("searchMsbRostergroups", input);
       input.setMsbRostergroups(output);
       return input;	
	}
	
	public Integer countMsbSessionSearch(MsbSessionSearchBean input){
		return sqlSession.selectOne("countMsbSessionSearch",input);
	}
	
	public MsbSessionSearchBean searchMsbSession(MsbSessionSearchBean input){
       List<MsbSessionBean> output = new ArrayList<MsbSessionBean>();       
       output = sqlSession.selectList("searchMsbSession", input);
       input.setMsbSession(output);
       return input;	
	}
	
	public Integer countMsbSubscriberSearch(MsbSubscriberSearchBean input){
		return sqlSession.selectOne("countMsbSubscriberSearch",input);
	}
	
	public MsbSubscriberSearchBean searchMsbSubscriber(MsbSubscriberSearchBean input){
       List<MsbSubscriberBean> output = new ArrayList<MsbSubscriberBean>();       
       output = sqlSession.selectList("searchMsbSubscriber", input);
       input.setMsbSubscriber(output);
       return input;	
	}
	
	public Integer countMsbSubscriberpropSearch(MsbSubscriberpropSearchBean input){
		return sqlSession.selectOne("countMsbSubscriberpropSearch",input);
	}
	
	public MsbSubscriberpropSearchBean searchMsbSubscriberprop(MsbSubscriberpropSearchBean input){
       List<MsbSubscriberpropBean> output = new ArrayList<MsbSubscriberpropBean>();       
       output = sqlSession.selectList("searchMsbSubscriberprop", input);
       input.setMsbSubscriberprop(output);
       return input;	
	}
	
	public Integer countMsbSubscribertypeSearch(MsbSubscribertypeSearchBean input){
		return sqlSession.selectOne("countMsbSubscribertypeSearch",input);
	}
	
	public MsbSubscribertypeSearchBean searchMsbSubscribertype(MsbSubscribertypeSearchBean input){
       List<MsbSubscribertypeBean> output = new ArrayList<MsbSubscribertypeBean>();       
       output = sqlSession.selectList("searchMsbSubscribertype", input);
       input.setMsbSubscribertype(output);
       return input;	
	}
	
	public Integer countMsbTrafficSearch(MsbTrafficSearchBean input){
		return sqlSession.selectOne("countMsbTrafficSearch",input);
	}
	
	public MsbTrafficSearchBean searchMsbTraffic(MsbTrafficSearchBean input){
       List<MsbTrafficBean> output = new ArrayList<MsbTrafficBean>();       
       output = sqlSession.selectList("searchMsbTraffic", input);
       input.setMsbTraffic(output);
       return input;	
	}
	
	public Integer countMsbVcardSearch(MsbVcardSearchBean input){
		return sqlSession.selectOne("countMsbVcardSearch",input);
	}
	
	public MsbVcardSearchBean searchMsbVcard(MsbVcardSearchBean input){
       List<MsbVcardBean> output = new ArrayList<MsbVcardBean>();       
       output = sqlSession.selectList("searchMsbVcard", input);
       input.setMsbVcard(output);
       return input;	
	}
	
	public Integer countMsbVersionSearch(MsbVersionSearchBean input){
		return sqlSession.selectOne("countMsbVersionSearch",input);
	}
	
	public MsbVersionSearchBean searchMsbVersion(MsbVersionSearchBean input){
       List<MsbVersionBean> output = new ArrayList<MsbVersionBean>();       
       output = sqlSession.selectList("searchMsbVersion", input);
       input.setMsbVersion(output);
       return input;	
	}
	
	public MsbAccountReadBean readMsbAccount(MsbAccountReadBean input){
       return sqlSession.selectOne("readMsbAccount", input);
	}	
	
	public MsbAffiliationReadBean readMsbAffiliation(MsbAffiliationReadBean input){
       return sqlSession.selectOne("readMsbAffiliation", input);
	}	
	
	public MsbAuthoritiesReadBean readMsbAuthorities(MsbAuthoritiesReadBean input){
       return sqlSession.selectOne("readMsbAuthorities", input);
	}	
	
	public MsbMenusReadBean readMsbMenus(MsbMenusReadBean input){
       return sqlSession.selectOne("readMsbMenus", input);
	}	
	
	public MsbMucaffiliationReadBean readMsbMucaffiliation(MsbMucaffiliationReadBean input){
       return sqlSession.selectOne("readMsbMucaffiliation", input);
	}	
	
	public MsbMucmemberReadBean readMsbMucmember(MsbMucmemberReadBean input){
       return sqlSession.selectOne("readMsbMucmember", input);
	}	
	
	public MsbMucroomReadBean readMsbMucroom(MsbMucroomReadBean input){
       return sqlSession.selectOne("readMsbMucroom", input);
	}	
	
	public MsbMucroompropReadBean readMsbMucroomprop(MsbMucroompropReadBean input){
       return sqlSession.selectOne("readMsbMucroomprop", input);
	}	
	
	public MsbMucserviceReadBean readMsbMucservice(MsbMucserviceReadBean input){
       return sqlSession.selectOne("readMsbMucservice", input);
	}	
	
	public MsbMucservicepropReadBean readMsbMucserviceprop(MsbMucservicepropReadBean input){
       return sqlSession.selectOne("readMsbMucserviceprop", input);
	}	
	
	public MsbOfflineReadBean readMsbOffline(MsbOfflineReadBean input){
       return sqlSession.selectOne("readMsbOffline", input);
	}	
	
	public MsbPersistentLoginsReadBean readMsbPersistentLogins(MsbPersistentLoginsReadBean input){
       return sqlSession.selectOne("readMsbPersistentLogins", input);
	}	
	
	public MsbPresenceReadBean readMsbPresence(MsbPresenceReadBean input){
       return sqlSession.selectOne("readMsbPresence", input);
	}	
	
	public MsbPropertyReadBean readMsbProperty(MsbPropertyReadBean input){
       return sqlSession.selectOne("readMsbProperty", input);
	}	
	
	public MsbPubsubReadBean readMsbPubsub(MsbPubsubReadBean input){
       return sqlSession.selectOne("readMsbPubsub", input);
	}	
	
	public MsbPubsubaffiliationReadBean readMsbPubsubaffiliation(MsbPubsubaffiliationReadBean input){
       return sqlSession.selectOne("readMsbPubsubaffiliation", input);
	}	
	
	public MsbPubsubitemReadBean readMsbPubsubitem(MsbPubsubitemReadBean input){
       return sqlSession.selectOne("readMsbPubsubitem", input);
	}	
	
	public MsbPubsubnodeReadBean readMsbPubsubnode(MsbPubsubnodeReadBean input){
       return sqlSession.selectOne("readMsbPubsubnode", input);
	}	
	
	public MsbPubsubnodegroupsReadBean readMsbPubsubnodegroups(MsbPubsubnodegroupsReadBean input){
       return sqlSession.selectOne("readMsbPubsubnodegroups", input);
	}	
	
	public MsbPubsubsubscriberReadBean readMsbPubsubsubscriber(MsbPubsubsubscriberReadBean input){
       return sqlSession.selectOne("readMsbPubsubsubscriber", input);
	}	
	
	public MsbPubsubsubscriptionReadBean readMsbPubsubsubscription(MsbPubsubsubscriptionReadBean input){
       return sqlSession.selectOne("readMsbPubsubsubscription", input);
	}	
	
	public MsbRemoteserverReadBean readMsbRemoteserver(MsbRemoteserverReadBean input){
       return sqlSession.selectOne("readMsbRemoteserver", input);
	}	
	
	public MsbRevenueReadBean readMsbRevenue(MsbRevenueReadBean input){
       return sqlSession.selectOne("readMsbRevenue", input);
	}	
	
	public MsbRosterReadBean readMsbRoster(MsbRosterReadBean input){
       return sqlSession.selectOne("readMsbRoster", input);
	}	
	
	public MsbRostergroupsReadBean readMsbRostergroups(MsbRostergroupsReadBean input){
       return sqlSession.selectOne("readMsbRostergroups", input);
	}	
	
	public MsbSessionReadBean readMsbSession(MsbSessionReadBean input){
       return sqlSession.selectOne("readMsbSession", input);
	}	
	
	public MsbSubscriberReadBean readMsbSubscriber(MsbSubscriberReadBean input){
       return sqlSession.selectOne("readMsbSubscriber", input);
	}	
	
	public MsbSubscriberpropReadBean readMsbSubscriberprop(MsbSubscriberpropReadBean input){
       return sqlSession.selectOne("readMsbSubscriberprop", input);
	}	
	
	public MsbSubscribertypeReadBean readMsbSubscribertype(MsbSubscribertypeReadBean input){
       return sqlSession.selectOne("readMsbSubscribertype", input);
	}	
	
	public MsbTrafficReadBean readMsbTraffic(MsbTrafficReadBean input){
       return sqlSession.selectOne("readMsbTraffic", input);
	}	
	
	public MsbVcardReadBean readMsbVcard(MsbVcardReadBean input){
       return sqlSession.selectOne("readMsbVcard", input);
	}	
	
	public MsbVersionReadBean readMsbVersion(MsbVersionReadBean input){
       return sqlSession.selectOne("readMsbVersion", input);
	}	
	
	public MsbAccountNewBean newMsbAccount(MsbAccountNewBean input){
       MsbAccountNewBean output = new MsbAccountNewBean();       
       int ret = sqlSession.insert("newMsbAccount", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAffiliationNewBean newMsbAffiliation(MsbAffiliationNewBean input){
       MsbAffiliationNewBean output = new MsbAffiliationNewBean();       
       int ret = sqlSession.insert("newMsbAffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAuthoritiesNewBean newMsbAuthorities(MsbAuthoritiesNewBean input){
       MsbAuthoritiesNewBean output = new MsbAuthoritiesNewBean();       
       int ret = sqlSession.insert("newMsbAuthorities", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMenusNewBean newMsbMenus(MsbMenusNewBean input){
       MsbMenusNewBean output = new MsbMenusNewBean();       
       int ret = sqlSession.insert("newMsbMenus", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucaffiliationNewBean newMsbMucaffiliation(MsbMucaffiliationNewBean input){
       MsbMucaffiliationNewBean output = new MsbMucaffiliationNewBean();       
       int ret = sqlSession.insert("newMsbMucaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucmemberNewBean newMsbMucmember(MsbMucmemberNewBean input){
       MsbMucmemberNewBean output = new MsbMucmemberNewBean();       
       int ret = sqlSession.insert("newMsbMucmember", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroomNewBean newMsbMucroom(MsbMucroomNewBean input){
       MsbMucroomNewBean output = new MsbMucroomNewBean();       
       int ret = sqlSession.insert("newMsbMucroom", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroompropNewBean newMsbMucroomprop(MsbMucroompropNewBean input){
       MsbMucroompropNewBean output = new MsbMucroompropNewBean();       
       int ret = sqlSession.insert("newMsbMucroomprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucserviceNewBean newMsbMucservice(MsbMucserviceNewBean input){
       MsbMucserviceNewBean output = new MsbMucserviceNewBean();       
       int ret = sqlSession.insert("newMsbMucservice", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucservicepropNewBean newMsbMucserviceprop(MsbMucservicepropNewBean input){
       MsbMucservicepropNewBean output = new MsbMucservicepropNewBean();       
       int ret = sqlSession.insert("newMsbMucserviceprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbOfflineNewBean newMsbOffline(MsbOfflineNewBean input){
       MsbOfflineNewBean output = new MsbOfflineNewBean();       
       int ret = sqlSession.insert("newMsbOffline", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPersistentLoginsNewBean newMsbPersistentLogins(MsbPersistentLoginsNewBean input){
       MsbPersistentLoginsNewBean output = new MsbPersistentLoginsNewBean();       
       int ret = sqlSession.insert("newMsbPersistentLogins", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPresenceNewBean newMsbPresence(MsbPresenceNewBean input){
       MsbPresenceNewBean output = new MsbPresenceNewBean();       
       int ret = sqlSession.insert("newMsbPresence", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPropertyNewBean newMsbProperty(MsbPropertyNewBean input){
       MsbPropertyNewBean output = new MsbPropertyNewBean();       
       int ret = sqlSession.insert("newMsbProperty", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubNewBean newMsbPubsub(MsbPubsubNewBean input){
       MsbPubsubNewBean output = new MsbPubsubNewBean();       
       int ret = sqlSession.insert("newMsbPubsub", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubaffiliationNewBean newMsbPubsubaffiliation(MsbPubsubaffiliationNewBean input){
       MsbPubsubaffiliationNewBean output = new MsbPubsubaffiliationNewBean();       
       int ret = sqlSession.insert("newMsbPubsubaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubitemNewBean newMsbPubsubitem(MsbPubsubitemNewBean input){
       MsbPubsubitemNewBean output = new MsbPubsubitemNewBean();       
       int ret = sqlSession.insert("newMsbPubsubitem", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodeNewBean newMsbPubsubnode(MsbPubsubnodeNewBean input){
       MsbPubsubnodeNewBean output = new MsbPubsubnodeNewBean();       
       int ret = sqlSession.insert("newMsbPubsubnode", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodegroupsNewBean newMsbPubsubnodegroups(MsbPubsubnodegroupsNewBean input){
       MsbPubsubnodegroupsNewBean output = new MsbPubsubnodegroupsNewBean();       
       int ret = sqlSession.insert("newMsbPubsubnodegroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriberNewBean newMsbPubsubsubscriber(MsbPubsubsubscriberNewBean input){
       MsbPubsubsubscriberNewBean output = new MsbPubsubsubscriberNewBean();       
       int ret = sqlSession.insert("newMsbPubsubsubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriptionNewBean newMsbPubsubsubscription(MsbPubsubsubscriptionNewBean input){
       MsbPubsubsubscriptionNewBean output = new MsbPubsubsubscriptionNewBean();       
       int ret = sqlSession.insert("newMsbPubsubsubscription", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRemoteserverNewBean newMsbRemoteserver(MsbRemoteserverNewBean input){
       MsbRemoteserverNewBean output = new MsbRemoteserverNewBean();       
       int ret = sqlSession.insert("newMsbRemoteserver", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRevenueNewBean newMsbRevenue(MsbRevenueNewBean input){
       MsbRevenueNewBean output = new MsbRevenueNewBean();       
       int ret = sqlSession.insert("newMsbRevenue", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRosterNewBean newMsbRoster(MsbRosterNewBean input){
       MsbRosterNewBean output = new MsbRosterNewBean();       
       int ret = sqlSession.insert("newMsbRoster", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRostergroupsNewBean newMsbRostergroups(MsbRostergroupsNewBean input){
       MsbRostergroupsNewBean output = new MsbRostergroupsNewBean();       
       int ret = sqlSession.insert("newMsbRostergroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSessionNewBean newMsbSession(MsbSessionNewBean input){
       MsbSessionNewBean output = new MsbSessionNewBean();       
       int ret = sqlSession.insert("newMsbSession", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberNewBean newMsbSubscriber(MsbSubscriberNewBean input){
       MsbSubscriberNewBean output = new MsbSubscriberNewBean();       
       int ret = sqlSession.insert("newMsbSubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberpropNewBean newMsbSubscriberprop(MsbSubscriberpropNewBean input){
       MsbSubscriberpropNewBean output = new MsbSubscriberpropNewBean();       
       int ret = sqlSession.insert("newMsbSubscriberprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscribertypeNewBean newMsbSubscribertype(MsbSubscribertypeNewBean input){
       MsbSubscribertypeNewBean output = new MsbSubscribertypeNewBean();       
       int ret = sqlSession.insert("newMsbSubscribertype", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbTrafficNewBean newMsbTraffic(MsbTrafficNewBean input){
       MsbTrafficNewBean output = new MsbTrafficNewBean();       
       int ret = sqlSession.insert("newMsbTraffic", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVcardNewBean newMsbVcard(MsbVcardNewBean input){
       MsbVcardNewBean output = new MsbVcardNewBean();       
       int ret = sqlSession.insert("newMsbVcard", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVersionNewBean newMsbVersion(MsbVersionNewBean input){
       MsbVersionNewBean output = new MsbVersionNewBean();       
       int ret = sqlSession.insert("newMsbVersion", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAccountWriteBean writeMsbAccount(MsbAccountWriteBean input){
       MsbAccountWriteBean output = new MsbAccountWriteBean();       
       int ret = sqlSession.update("writeMsbAccount", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAffiliationWriteBean writeMsbAffiliation(MsbAffiliationWriteBean input){
       MsbAffiliationWriteBean output = new MsbAffiliationWriteBean();       
       int ret = sqlSession.update("writeMsbAffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAuthoritiesWriteBean writeMsbAuthorities(MsbAuthoritiesWriteBean input){
       MsbAuthoritiesWriteBean output = new MsbAuthoritiesWriteBean();       
       int ret = sqlSession.update("writeMsbAuthorities", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMenusWriteBean writeMsbMenus(MsbMenusWriteBean input){
       MsbMenusWriteBean output = new MsbMenusWriteBean();       
       int ret = sqlSession.update("writeMsbMenus", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucaffiliationWriteBean writeMsbMucaffiliation(MsbMucaffiliationWriteBean input){
       MsbMucaffiliationWriteBean output = new MsbMucaffiliationWriteBean();       
       int ret = sqlSession.update("writeMsbMucaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucmemberWriteBean writeMsbMucmember(MsbMucmemberWriteBean input){
       MsbMucmemberWriteBean output = new MsbMucmemberWriteBean();       
       int ret = sqlSession.update("writeMsbMucmember", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroomWriteBean writeMsbMucroom(MsbMucroomWriteBean input){
       MsbMucroomWriteBean output = new MsbMucroomWriteBean();       
       int ret = sqlSession.update("writeMsbMucroom", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroompropWriteBean writeMsbMucroomprop(MsbMucroompropWriteBean input){
       MsbMucroompropWriteBean output = new MsbMucroompropWriteBean();       
       int ret = sqlSession.update("writeMsbMucroomprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucserviceWriteBean writeMsbMucservice(MsbMucserviceWriteBean input){
       MsbMucserviceWriteBean output = new MsbMucserviceWriteBean();       
       int ret = sqlSession.update("writeMsbMucservice", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucservicepropWriteBean writeMsbMucserviceprop(MsbMucservicepropWriteBean input){
       MsbMucservicepropWriteBean output = new MsbMucservicepropWriteBean();       
       int ret = sqlSession.update("writeMsbMucserviceprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbOfflineWriteBean writeMsbOffline(MsbOfflineWriteBean input){
       MsbOfflineWriteBean output = new MsbOfflineWriteBean();       
       int ret = sqlSession.update("writeMsbOffline", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPersistentLoginsWriteBean writeMsbPersistentLogins(MsbPersistentLoginsWriteBean input){
       MsbPersistentLoginsWriteBean output = new MsbPersistentLoginsWriteBean();       
       int ret = sqlSession.update("writeMsbPersistentLogins", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPresenceWriteBean writeMsbPresence(MsbPresenceWriteBean input){
       MsbPresenceWriteBean output = new MsbPresenceWriteBean();       
       int ret = sqlSession.update("writeMsbPresence", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPropertyWriteBean writeMsbProperty(MsbPropertyWriteBean input){
       MsbPropertyWriteBean output = new MsbPropertyWriteBean();       
       int ret = sqlSession.update("writeMsbProperty", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubWriteBean writeMsbPubsub(MsbPubsubWriteBean input){
       MsbPubsubWriteBean output = new MsbPubsubWriteBean();       
       int ret = sqlSession.update("writeMsbPubsub", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubaffiliationWriteBean writeMsbPubsubaffiliation(MsbPubsubaffiliationWriteBean input){
       MsbPubsubaffiliationWriteBean output = new MsbPubsubaffiliationWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubitemWriteBean writeMsbPubsubitem(MsbPubsubitemWriteBean input){
       MsbPubsubitemWriteBean output = new MsbPubsubitemWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubitem", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodeWriteBean writeMsbPubsubnode(MsbPubsubnodeWriteBean input){
       MsbPubsubnodeWriteBean output = new MsbPubsubnodeWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubnode", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodegroupsWriteBean writeMsbPubsubnodegroups(MsbPubsubnodegroupsWriteBean input){
       MsbPubsubnodegroupsWriteBean output = new MsbPubsubnodegroupsWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubnodegroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriberWriteBean writeMsbPubsubsubscriber(MsbPubsubsubscriberWriteBean input){
       MsbPubsubsubscriberWriteBean output = new MsbPubsubsubscriberWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubsubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriptionWriteBean writeMsbPubsubsubscription(MsbPubsubsubscriptionWriteBean input){
       MsbPubsubsubscriptionWriteBean output = new MsbPubsubsubscriptionWriteBean();       
       int ret = sqlSession.update("writeMsbPubsubsubscription", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRemoteserverWriteBean writeMsbRemoteserver(MsbRemoteserverWriteBean input){
       MsbRemoteserverWriteBean output = new MsbRemoteserverWriteBean();       
       int ret = sqlSession.update("writeMsbRemoteserver", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRevenueWriteBean writeMsbRevenue(MsbRevenueWriteBean input){
       MsbRevenueWriteBean output = new MsbRevenueWriteBean();       
       int ret = sqlSession.update("writeMsbRevenue", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRosterWriteBean writeMsbRoster(MsbRosterWriteBean input){
       MsbRosterWriteBean output = new MsbRosterWriteBean();       
       int ret = sqlSession.update("writeMsbRoster", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRostergroupsWriteBean writeMsbRostergroups(MsbRostergroupsWriteBean input){
       MsbRostergroupsWriteBean output = new MsbRostergroupsWriteBean();       
       int ret = sqlSession.update("writeMsbRostergroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSessionWriteBean writeMsbSession(MsbSessionWriteBean input){
       MsbSessionWriteBean output = new MsbSessionWriteBean();       
       int ret = sqlSession.update("writeMsbSession", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberWriteBean writeMsbSubscriber(MsbSubscriberWriteBean input){
       MsbSubscriberWriteBean output = new MsbSubscriberWriteBean();       
       int ret = sqlSession.update("writeMsbSubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberpropWriteBean writeMsbSubscriberprop(MsbSubscriberpropWriteBean input){
       MsbSubscriberpropWriteBean output = new MsbSubscriberpropWriteBean();       
       int ret = sqlSession.update("writeMsbSubscriberprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscribertypeWriteBean writeMsbSubscribertype(MsbSubscribertypeWriteBean input){
       MsbSubscribertypeWriteBean output = new MsbSubscribertypeWriteBean();       
       int ret = sqlSession.update("writeMsbSubscribertype", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbTrafficWriteBean writeMsbTraffic(MsbTrafficWriteBean input){
       MsbTrafficWriteBean output = new MsbTrafficWriteBean();       
       int ret = sqlSession.update("writeMsbTraffic", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVcardWriteBean writeMsbVcard(MsbVcardWriteBean input){
       MsbVcardWriteBean output = new MsbVcardWriteBean();       
       int ret = sqlSession.update("writeMsbVcard", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVersionWriteBean writeMsbVersion(MsbVersionWriteBean input){
       MsbVersionWriteBean output = new MsbVersionWriteBean();       
       int ret = sqlSession.update("writeMsbVersion", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAccountDeleteBean deleteMsbAccount(MsbAccountDeleteBean input){
       MsbAccountDeleteBean output = new MsbAccountDeleteBean();       
       int ret = sqlSession.delete("deleteMsbAccount", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAffiliationDeleteBean deleteMsbAffiliation(MsbAffiliationDeleteBean input){
       MsbAffiliationDeleteBean output = new MsbAffiliationDeleteBean();       
       int ret = sqlSession.delete("deleteMsbAffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbAuthoritiesDeleteBean deleteMsbAuthorities(MsbAuthoritiesDeleteBean input){
       MsbAuthoritiesDeleteBean output = new MsbAuthoritiesDeleteBean();       
       int ret = sqlSession.delete("deleteMsbAuthorities", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMenusDeleteBean deleteMsbMenus(MsbMenusDeleteBean input){
       MsbMenusDeleteBean output = new MsbMenusDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMenus", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucaffiliationDeleteBean deleteMsbMucaffiliation(MsbMucaffiliationDeleteBean input){
       MsbMucaffiliationDeleteBean output = new MsbMucaffiliationDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucmemberDeleteBean deleteMsbMucmember(MsbMucmemberDeleteBean input){
       MsbMucmemberDeleteBean output = new MsbMucmemberDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucmember", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroomDeleteBean deleteMsbMucroom(MsbMucroomDeleteBean input){
       MsbMucroomDeleteBean output = new MsbMucroomDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucroom", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucroompropDeleteBean deleteMsbMucroomprop(MsbMucroompropDeleteBean input){
       MsbMucroompropDeleteBean output = new MsbMucroompropDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucroomprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucserviceDeleteBean deleteMsbMucservice(MsbMucserviceDeleteBean input){
       MsbMucserviceDeleteBean output = new MsbMucserviceDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucservice", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbMucservicepropDeleteBean deleteMsbMucserviceprop(MsbMucservicepropDeleteBean input){
       MsbMucservicepropDeleteBean output = new MsbMucservicepropDeleteBean();       
       int ret = sqlSession.delete("deleteMsbMucserviceprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbOfflineDeleteBean deleteMsbOffline(MsbOfflineDeleteBean input){
       MsbOfflineDeleteBean output = new MsbOfflineDeleteBean();       
       int ret = sqlSession.delete("deleteMsbOffline", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPersistentLoginsDeleteBean deleteMsbPersistentLogins(MsbPersistentLoginsDeleteBean input){
       MsbPersistentLoginsDeleteBean output = new MsbPersistentLoginsDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPersistentLogins", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPresenceDeleteBean deleteMsbPresence(MsbPresenceDeleteBean input){
       MsbPresenceDeleteBean output = new MsbPresenceDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPresence", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPropertyDeleteBean deleteMsbProperty(MsbPropertyDeleteBean input){
       MsbPropertyDeleteBean output = new MsbPropertyDeleteBean();       
       int ret = sqlSession.delete("deleteMsbProperty", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubDeleteBean deleteMsbPubsub(MsbPubsubDeleteBean input){
       MsbPubsubDeleteBean output = new MsbPubsubDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsub", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubaffiliationDeleteBean deleteMsbPubsubaffiliation(MsbPubsubaffiliationDeleteBean input){
       MsbPubsubaffiliationDeleteBean output = new MsbPubsubaffiliationDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubaffiliation", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubitemDeleteBean deleteMsbPubsubitem(MsbPubsubitemDeleteBean input){
       MsbPubsubitemDeleteBean output = new MsbPubsubitemDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubitem", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodeDeleteBean deleteMsbPubsubnode(MsbPubsubnodeDeleteBean input){
       MsbPubsubnodeDeleteBean output = new MsbPubsubnodeDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubnode", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubnodegroupsDeleteBean deleteMsbPubsubnodegroups(MsbPubsubnodegroupsDeleteBean input){
       MsbPubsubnodegroupsDeleteBean output = new MsbPubsubnodegroupsDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubnodegroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriberDeleteBean deleteMsbPubsubsubscriber(MsbPubsubsubscriberDeleteBean input){
       MsbPubsubsubscriberDeleteBean output = new MsbPubsubsubscriberDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubsubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbPubsubsubscriptionDeleteBean deleteMsbPubsubsubscription(MsbPubsubsubscriptionDeleteBean input){
       MsbPubsubsubscriptionDeleteBean output = new MsbPubsubsubscriptionDeleteBean();       
       int ret = sqlSession.delete("deleteMsbPubsubsubscription", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRemoteserverDeleteBean deleteMsbRemoteserver(MsbRemoteserverDeleteBean input){
       MsbRemoteserverDeleteBean output = new MsbRemoteserverDeleteBean();       
       int ret = sqlSession.delete("deleteMsbRemoteserver", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRevenueDeleteBean deleteMsbRevenue(MsbRevenueDeleteBean input){
       MsbRevenueDeleteBean output = new MsbRevenueDeleteBean();       
       int ret = sqlSession.delete("deleteMsbRevenue", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRosterDeleteBean deleteMsbRoster(MsbRosterDeleteBean input){
       MsbRosterDeleteBean output = new MsbRosterDeleteBean();       
       int ret = sqlSession.delete("deleteMsbRoster", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbRostergroupsDeleteBean deleteMsbRostergroups(MsbRostergroupsDeleteBean input){
       MsbRostergroupsDeleteBean output = new MsbRostergroupsDeleteBean();       
       int ret = sqlSession.delete("deleteMsbRostergroups", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSessionDeleteBean deleteMsbSession(MsbSessionDeleteBean input){
       MsbSessionDeleteBean output = new MsbSessionDeleteBean();       
       int ret = sqlSession.delete("deleteMsbSession", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberDeleteBean deleteMsbSubscriber(MsbSubscriberDeleteBean input){
       MsbSubscriberDeleteBean output = new MsbSubscriberDeleteBean();       
       int ret = sqlSession.delete("deleteMsbSubscriber", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscriberpropDeleteBean deleteMsbSubscriberprop(MsbSubscriberpropDeleteBean input){
       MsbSubscriberpropDeleteBean output = new MsbSubscriberpropDeleteBean();       
       int ret = sqlSession.delete("deleteMsbSubscriberprop", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbSubscribertypeDeleteBean deleteMsbSubscribertype(MsbSubscribertypeDeleteBean input){
       MsbSubscribertypeDeleteBean output = new MsbSubscribertypeDeleteBean();       
       int ret = sqlSession.delete("deleteMsbSubscribertype", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbTrafficDeleteBean deleteMsbTraffic(MsbTrafficDeleteBean input){
       MsbTrafficDeleteBean output = new MsbTrafficDeleteBean();       
       int ret = sqlSession.delete("deleteMsbTraffic", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVcardDeleteBean deleteMsbVcard(MsbVcardDeleteBean input){
       MsbVcardDeleteBean output = new MsbVcardDeleteBean();       
       int ret = sqlSession.delete("deleteMsbVcard", input);
       if (ret == 0) return output;
       else return input;
	}	
	
	public MsbVersionDeleteBean deleteMsbVersion(MsbVersionDeleteBean input){
       MsbVersionDeleteBean output = new MsbVersionDeleteBean();       
       int ret = sqlSession.delete("deleteMsbVersion", input);
       if (ret == 0) return output;
       else return input;
	}	
	
}
