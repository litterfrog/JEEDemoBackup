package com.fxp.test;

import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;

public class Test1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyThread mt=new MyThread();
		FutureTask<Integer> result=new FutureTask<>(mt);
		
		new Thread(result).start();
		
		try {
			Integer sum=result.get();
			System.out.println(sum);
			System.out.println("over");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		Future<Integer> submit = newScheduledThreadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("ddd");
				
			}
		}, 5);
		System.out.println(submit.get());
		
		ByteBuffer allocate = ByteBuffer.allocate(1024);
	}
	

}

class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<1000;i++){
			sum+=i;
		}
		return sum;
	}
	
}