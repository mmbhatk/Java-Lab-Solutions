package q12a;

class myThread extends Thread {
	int n;
	myThread(int n) {
		this.n = n;
	}
	public void run() {
		System.out.println("Running thread: " + n);
		while(true) {}
	}
}

public class q12a {
	public static void main(String[] args) {
		myThread t1 = new myThread(1);
		myThread t2 = new myThread(2);
		myThread t3 = new myThread(3);
		myThread t4 = new myThread(4);
		myThread t5 = new myThread(5);
		
		t1.setPriority(9);
		t2.setPriority(8);
		t3.setPriority(7);
		t4.setPriority(6);
		t5.setPriority(5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.sleep(100);
			t2.sleep(100);
		}
		catch(InterruptedException e) {e.printStackTrace();}
		
		if(t1.isAlive()) System.out.println("Active t1.");
		else System.out.println("Sleep t1.");
		if(t2.isAlive()) System.out.println("Active t2.");
		else System.out.println("Sleep t2.");
		if(t3.isAlive()) System.out.println("Active t3.");
		else System.out.println("Sleep t3.");
		if(t4.isAlive()) System.out.println("Active t4.");
		else System.out.println("Sleep t4.");
		if(t5.isAlive()) System.out.println("Active t5.");
		else System.out.println("Sleep t5.");
	}
}