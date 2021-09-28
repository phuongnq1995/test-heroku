package com.phuongnq.multithread.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AsyncService {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);

	@Async
	public void doSomething(int countUser) {
		LOG.info("Executing - " + countUser + " In thread  " + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (Exception e) {

		}
		LOG.info("Finished - " + countUser + " In thread  "  + Thread.currentThread().getName());
	}
}
