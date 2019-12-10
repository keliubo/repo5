package com.github.wxpay.sdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author klb
 * @version 1.0
 * @date 2019/11/21 16:40
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        //1.封装请求参数
        Map<String,String> map=new HashMap();
        map.put("appid",config.getAppID());//公众账号ID
        map.put("mch_id",config.getMchID());//商户号
        map.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        map.put("sign","青橙");//签名
        map.put("transaction_id","4200000307201905278362498491");//订单号
        String xmlParam  = WXPayUtil.generateSignedXml(map, config.getKey());
        System.out.println("参数："+xmlParam);

        //2.发送请求
        WXPayRequest wxPayRequest=new WXPayRequest(config);
        String xmlResult = wxPayRequest.requestWithCert("/pay/orderquery", null, xmlParam, false);
        System.out.println("结果："+xmlResult);

        //3.解析返回结果
        Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);

        Map m=new HashMap();
        m.put("code_url", mapResult.get("code_url"));
        m.put("total_fee",money+"");
        m.put("out_trade_no",orderId);
        //提交
        System.out.println("提交");
        System.out.println("dev1");
        System.out.println("dv1");
        System.out.println("div2");

    }


}
