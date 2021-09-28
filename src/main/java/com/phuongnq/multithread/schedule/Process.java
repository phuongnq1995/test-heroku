package com.phuongnq.multithread.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Process {

	private static String[] tasks = { "i", "i", "i", "i", "i" };

	@Scheduled(cron = "0 * * ? * *")
	public void do1() {
		for (int i = 0; i < tasks.length; i++) {

			if (tasks[i] == "i") {

				tasks[i] = "i1";

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tasks[i] = "c";
			}
		}
	}
	/*
	 * @Scheduled(cron = "0 * * ? * *") public synchronized void do2() { for (int i
	 * = 0; i < tasks.length; i++) { try { Thread.sleep(5000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } tasks[i] = "t"; } }
	 * 
	 * @Scheduled(cron = "0 * * ? * *") public void do3() { for (int i = 0; i <
	 * tasks.length; i++) { try { Thread.sleep(5000); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } tasks[i] =
	 * "r"; } }
	 */
}
