package xyz.kingsword.shopdemo.model.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import xyz.kingsword.shopdemo.model.bean.Card;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wzh date: 2019-04-22 08:44
 * @version: 1.0
 **/
public class CardCheck {
    private static final String cardCheckUrl = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json";

    public static Card CardCheck(String cardNo) {
        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("cardBinCheck", true);
        paramMap.put("cardNo", cardNo);
        String jsonStr = HttpUtil.get(cardCheckUrl, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        if (!jsonObject.getBool("validated"))
            return null;
        String cardType = jsonObject.getStr("cardType");
        return new Card(cardNo, "中国建设银行", cardType);
    }
}
