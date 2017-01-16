package cn.chenzw.design_pattem.proxy.dynamic_proxy.service.impl;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;

public class DBQueryImpl implements IDBQuery {

	public DBQueryImpl() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String request() {
		return "hello world!";
	}

	public String request2() {
		return "request2";
	}

}
