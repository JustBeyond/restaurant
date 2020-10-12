package com.furseal.restaurant.common.utils;

import com.furseal.restaurant.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Slf4j
public class HttpClientUtil {
    public static String doPost(String reqUrl, Map<String, String> headerMap, Map<String, String> paramMap) {
        HttpURLConnection connection = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        StringBuilder sb = null;
        try {
            URL url = new URL(reqUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(Constants.Http.HTTP_METHOD_POST);
            connection.setUseCaches(false);
            if (headerMap != null && headerMap.size() > 0) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    connection.setRequestProperty(key, value);
                }
            }
            pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            StringBuffer parameter = new StringBuffer();
            parameter.append("1=1");
            if (paramMap != null && paramMap.size() > 0) {
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    parameter.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
            pw.write(parameter.toString());
            pw.flush();
            pw.close();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            log.error("######get ip address error!!! " + e.getMessage());
        } finally {
            try {
                pw.close();
                br.close();
            } catch (Exception e) {
                log.error("######get ip address error!!! " + e.getMessage());
            }

        }
        return sb.toString();
    }
}
