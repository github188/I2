package com.bullx.test;

import org.dom4j.Document;

import com.bullx.cacdata.CACData;
import com.bullx.common.Constant;
import com.bullx.heartbeat.HeartBeat;
import com.bullx.utils.I2Util;

public class I2Test {

    public static final String HeartBeatResponse = Constant.ROOT
                                                         + "/resource/HeartBeatResponse.xml";

    private static void HeartBeatTest() {
        HeartBeat hearBeat = new HeartBeat();
        Document request = hearBeat.getRequest();
        System.out.println(I2Util.prettyXML(request));
    }

    private static void CACDataTest() {
        CACData cacData = new CACData();
        Document request = cacData.getRequest();
        System.out.println(I2Util.prettyXML(request));
    }

    public static void main(String[] args) {
        //        HeartBeatTest();
        CACDataTest();
        //
        //        ConfigCacDAO cacDAO = new ConfigCacDAO();
        //        List<ConfigCac> list = cacDAO.findAll();
        //        for (int i = 0; i < list.size(); i++) {
        //            System.out.println(list.get(i).getCacId());
        //        }
        //
        //        ConfigIedDAO iedDAO = new ConfigIedDAO();
        //        List<ConfigIed> iList = iedDAO.findAll();
        //        for (int i = 0; i < iList.size(); i++) {
        //            ConfigIed ied = iList.get(i);
        //            System.out.println(ied.getIedName() + " " + ied.getIedNameCn() + " "
        //                    + ied.getConfigCac().getCacId());
        //        }
        //
        //        DataMmxnDAO mmDAO = new DataMmxnDAO();
        //        Query qb = mmDAO.getSession().createQuery(
        //                "from DataMmxn as inst where inst.lnInst=? order by inst.dataTime desc");
        //        qb.setInteger(0, 1);
        //        qb.setFirstResult(0);
        //        qb.setMaxResults(1);
        //        List<DataMmxn> ll = qb.list();
        //        if (ll.size() > 0) {
        //            System.out.println(ll.get(0).getDataTime().toString());
        //        } else {
        //            System.out.println("Syntax error!");
        //        }
        //
        //        DataXML dataXML = new DataXML();
        //        System.out.println(dataXML.get());
        //        System.out.println("**************");
        //
        //        HeartBeatXML hearBeat = new HeartBeatXML();
        //        Document request = hearBeat.getRequest();
        //        System.out.println(request.asXML());
    }
}
