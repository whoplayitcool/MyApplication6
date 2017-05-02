package cn.bxw1.bxapp.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager {

	private static ThreadPoolManager manager;
	private static ExecutorService service;

	private ThreadPoolManager() {
		int i = Runtime.getRuntime().availableProcessors();
		service = Executors.newFixedThreadPool(i * 4);
	}

	public static ThreadPoolManager getInstance() {
		if (manager == null) {
			manager = new ThreadPoolManager();
		}
		return manager;
	}

	public void execute(Runnable runnable) {
		service.execute(runnable);
	}
}
