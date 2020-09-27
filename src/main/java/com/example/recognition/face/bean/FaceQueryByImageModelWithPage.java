package com.example.recognition.face.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

@Configuration
public class FaceQueryByImageModelWithPage {
	/**
	 * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
	 */
	static {
		ArtemisConfig.host = "56.18.132.43:443"; // 平台/nginx的IP和端口（必须使用https协议，https端口默认为443）
		ArtemisConfig.appKey = "24030804"; // 秘钥appkey
		ArtemisConfig.appSecret = "I6Pl9pBbAMv0tPAPiAmC";// 秘钥appSecret
	}
	/**
	 * STEP2：设置OpenAPI接口的上下文
	 */
	private static final String ARTEMIS_PATH = "/artemis";

	// 名单库以脸搜脸
	public static String queryByImageModelWithPage(QueryByImageModelWithPageRequest queryByImageModelWithPageRequest) {
		final String queryByImageModelWithPageDataApi = ARTEMIS_PATH
				+ "/api/aiapplication/v1/face/queryByImageModelWithPage";
		Map<String, String> path = new HashMap<String, String>(2) {
			{
				put("https://", queryByImageModelWithPageDataApi);
			}
		};
		String body = JSON.toJSONString(queryByImageModelWithPageRequest);
		String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
		return result;
	}
//    class QueryByImageModelWithPageRequest {
//
//    }
}
