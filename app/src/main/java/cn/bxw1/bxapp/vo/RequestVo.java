package cn.bxw1.bxapp.vo;

import java.util.Map;

public class RequestVo {

	public String requestUrl;
	public Map<String, String> requestDataMap;

	public RequestVo() {
		super();
	}

	public RequestVo(String requestUrl, Map<String, String> requestDataMap) {
		super();
		this.requestUrl = requestUrl;
		this.requestDataMap = requestDataMap;
	}

	@Override
	public String toString() {
		return "RequestVo [requestUrl=" + requestUrl + ", requestDataMap=" + requestDataMap + "]";
	}
}
