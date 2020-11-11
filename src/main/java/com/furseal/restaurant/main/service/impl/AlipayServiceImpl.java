package com.furseal.restaurant.main.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.furseal.restaurant.main.service.AlipayService;
import org.springframework.stereotype.Service;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Override
    public String getQrUrl() {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                    "2016101100663241",
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCp3/JHeY5CPy5Q7G10ox4U2KWPYILu2QlpBhtSYzx0LTya3rUPx+Kghc+Qx+twltUef6CqeXUw//vg1Y5uofgJVWW0DXffcV8UJvLIzu+RtsBun2nUNKc0CfZioCSOe3Aw9awReiZxv745YZxV57+kbfNb03FZXmdV00uggAbSxnph8R9GbemlU6RVhLrveBfZtqle8hkHlyfXc1t2+alwxpwyXpk+WhOmvMZJUZA/Y02ojBW7AvpRVPVI/7Jyppg9sJQz0momEPmq3UofIthLMBbmZehs04kwi2WwsVGjJIGT4KjIKgs+pYou4aFDJWPjucBtX48Mwtdve2df5N87AgMBAAECggEAbIa7FTiuTtpob6CsSODRHgZOtyu0Wn1kCqmxGNB3Vc10s4hmal+MBHuYYOmoG7TxENv+vAp+eUCBHWGx7jIh8WySXhZgp+qZEJnVb77sxM3ZYJMNnFnLHG7k7pta34Ay68R4Gm5MU01pbOVUaHl3MMhhuh96gdrS77zeyvof4dWFW8HyhUcNtuVo+yER+Cr3jMyBj4t1R172kOMRzCI4kNmo40iVziSz4JN4eOAPhqbRqKfWZ1YBa+D0sytgSkOEdGiNRnAOlSOZINV5lXQNOll5P9iqFTR4UFU3spCn7z1Q+0YCfR7K9+YMSuliPKEAQKDqDfR771RvXcHtn4Ns6QKBgQD/3EuuW7Q72Ucd5eb7v5i5VFnZKXpQVOCMB3DjsqpDwOb9CALfWe+lbaKBy9WvcHGCH46kzfEuDFKLfVaHCejwxS9aoOzhIlJ2S3MgXdooZJFu14YwBA5he/OsHbLW7XEQ/IooROuyfb3J4jyTBJTbNjuYhBJ/yi+cmeJxgwmPxwKBgQCp96bbn1g3hB0Ck9+tQ7a/Wszt4At2xgVUrGiC77pNN5RIZ10uSTBNPBJw4MCn0ySXQT9ut7zuzDsuW4rSSgejmD5+ybDnMr/5DVtjbPUmNdUbWon8ZrM7G3sj6/SA+9MMp8E/P2wB/97OBSiBml0FhZ0/xSmC/ip8ycn5+ycc7QKBgDYwOfcbhPiH8//pCRqYYYgezUio+Da7QzNlAAu5c0YWPNWqNLGJIrAuoBRNT1xwvBmLBXLyCvptsa3JReIjvyn/GSBgpMqpsj1LjX51Yhbb9dE75DeXJFSRI/J398B9WUz3r2sH7cNHzkJLn/ijJ8OloMmUbzaRY7QPA153GjdRAoGBAJ4qywjXuOU4uTJb36vCNr7NxaSbeK+XyQApzLwEUG9pCEF0hv76tss42sRWMpI6Z3OmEVx7+YKTZYNXRtE4ePFhTM756/jKfmFKb8APdfaP4/engn7yJ1oa0bX07rxVG+pL9gZgg6c8r98yZ6ZruqLX2ySr2lx/H5Sux5ksghJlAoGAZXG11Y7lu2S+nshtgWBvKHpeUZhwHBbTJ6pugmLVvvuWgIRMrWQ3ptpPah0awwBeu9W9E+azZ8xRUhz5s9xTmIFIYgVwhkPFx3l9yG5VXaIyQP1x+/VXQSSJOVYY6VdKQHqeggh0NrizLIcbZeE9oypAIXYKEGyWKl+B6eqPVrM=", "json", "UTF-8",
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl1qWDbAuJdjmbMyueDqhtTgPIfUQR6o6mDxSf0VbOWGlrYuaLu+k6M08Kiqqdf//xVuJPPNNgOBXl/mCk1N1jgw4KP9B+VirejqZG1i35pQ1M3FLrXDPjawa+6xnTvaq1RIB/rwUemQ/7e9xFq5zA8xq9+Lf7hdmPEjthupWh4teS4SG8et3NdlQUBz6l0MxN4XPXAT1gQoTd1dJHBh/CiHEYhjnObKQHSMDpiC6yigoiYrEbgWlsEWoOGkRXUzW4enqLB3HHSYhgIRpcsjJxfUtyd3ozIIkeohLXZs1ZXGN1KuQWEweeNFc3vif6Rkf0psW2w6iVUKuBQQBOtnADQIDAQAB", "RSA2");
            AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("out_trade_no","1605098194932");
            jsonObject.put("subject","手机");
            jsonObject.put("total_amount","10");
            request.setBizContent(jsonObject.toJSONString());
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
                return response.getQrCode();
            } else {
                System.out.println("调用失败");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
