package be.mms.thread;

public class HelloThread extends Thread{

	public static void main(String[] args) {

		HelloThread h  = new HelloThread();
		h.start();
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello Thread");
	}

}
