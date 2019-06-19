package xyz.kingsword.shopdemo.model.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import xyz.kingsword.shopdemo.model.exception.ParameterException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class ServletJsonUtil {
    public static JSONObject parseObject(HttpServletRequest request) {
        String jsonString = parseJSONString(request);
        Optional.ofNullable(jsonString).orElseThrow(ParameterException::new);
        JSONObject jsonObject = JSONUtil.parseObj(jsonString);
        return convert(jsonObject);
    }

    public static JSONArray parseArray(HttpServletRequest request) {
        String jsonString = parseJSONString(request);
        Optional.ofNullable(jsonString).orElseThrow(ParameterException::new);
        return JSONUtil.parseArray(jsonString);
    }

    private static String parseJSONString(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            InputStream inputStream = request.getInputStream();
            return IoUtil.read(inputStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //做json内部格式转换
    private static JSONObject convert(JSONObject jsonObject) {
        JSONArray attributesArray = jsonObject.getJSONArray("attributes");
        JSONArray photosArray = jsonObject.getJSONArray("photos");
        JSONObject attributes = new JSONObject();
        for (Object o : attributesArray) {
            JSONObject temp = (JSONObject) o;
            attributes.put(temp.getStr("key"), temp.getStr("value"));
        }
        jsonObject = new JSONObject();
        jsonObject.put("name", attributes.remove("商品名称"));
        jsonObject.put("classify", attributes.remove("商品类别"));
        jsonObject.put("number", Convert.toInt(attributes.remove("商品库存")));
        jsonObject.put("price", Convert.toDouble(attributes.remove("商品价格")));
        jsonObject.put("photos", photosArray);
        jsonObject.put("attributes", attributes);
        return jsonObject;
    }
}
