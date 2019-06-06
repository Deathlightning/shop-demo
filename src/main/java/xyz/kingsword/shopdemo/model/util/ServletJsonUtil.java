package xyz.kingsword.shopdemo.model.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ServletJsonUtil {
    public JSONObject paraseRequest(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            request.setCharacterEncoding("UTF-8");
            InputStream inputStream = request.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONUtil.parseObj(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
