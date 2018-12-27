package q5a;

class Printing {
	public void welcome() throws InterruptedException {
		synchronized(this) {
			while(true) {
				System.out.println("Welcome");
				wait();
				notify();
			}
		}
	}
	
	public void goodbye() throws InterruptedException {
		synchronized(this) {
			while(true) {
				System.out.println("Goodbye");
				notify();
				wait();
			}
		}
	}
}

class thread1 extends Thread {
	Printing obj;
	thread1(Printing o) {
		obj = o;
		this.start();
	}
	public void run() {
		try {obj.welcome();}
		catch(InterruptedException e) {System.out.println("Thread 1 interrupted.");}
	}
}

class thread2 extends Thread {
	Printing obj;
	thread2(Printing o) {
		obj = o;
		this.start();
	}
	public void run() {
		try {obj.goodbye();}
		catch(InterruptedException e) {System.out.println("Thread 2 interrupted.");}
	}
}

public class q5a {
	public static void main(String[] args) {
		Printing obj = new Printing();
		thread1 t1 = new thread1(obj);
		thread2 t2 = new thread2(obj);
	}
}