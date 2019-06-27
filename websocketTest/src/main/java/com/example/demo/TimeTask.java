package com.example.demo;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TimeTask {
	@Scheduled(cron = "0/10 * * * * ?") // 每分钟执行一次
	public void test() {
		System.err.println("*********   定时任务执行   **************");
		
		CopyOnWriteArraySet<MyWebSocket> webSocketSet = MyWebSocket.getWebSocketSet();
		webSocketSet.forEach(c -> {
			try {
//				c.sendMessage("  定时发送  " + new Date().toLocaleString());
				c.sendMessageUser(new User());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.err.println("。。。。。。。。。 定时任务完成 。。。。。。。。。。。。");
	}

}
