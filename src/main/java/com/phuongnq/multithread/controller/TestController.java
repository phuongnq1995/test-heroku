package com.phuongnq.multithread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phuongnq.multithread.service.AsyncService;

@Controller("/test")
public class TestController {

	private static int countUser = 0;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("test-thread-pool") TaskExecutor taskExecutor;
	 */
	@Autowired
	private ApplicationContext context;

	@Autowired
	private AsyncService asyncService;

	@RequestMapping("/3")
	public @ResponseBody String greeting() {
		asyncService.doSomething(countUser);
		countUser++;
		return "Hello World: "+countUser;
	}

	@RequestMapping("/1")
	public @ResponseBody String check() {

		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("test-thread-pool", TaskExecutor.class);

		String a = "isTerminated: " + executor.getThreadPoolExecutor().isTerminated();
		String b = "isShutdown: " + executor.getThreadPoolExecutor().isShutdown();
		String c = "isTerminating: " + executor.getThreadPoolExecutor().isTerminating();
		return a + "\n" + b + "\n" + c + "\n";
	}

	@RequestMapping("/2")
	public @ResponseBody String shutdown() {

		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("test-thread-pool", TaskExecutor.class);

		executor.shutdown();

		String a = "isTerminated: " + executor.getThreadPoolExecutor().isTerminated();
		String b = "isShutdown: " + executor.getThreadPoolExecutor().isShutdown();
		String c = "isTerminating: " + executor.getThreadPoolExecutor().isTerminating();
		return a + "\n" + b + "\n" + c + "\n";
	}
}
