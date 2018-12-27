package q8a;

class Printing {
	int n = 0;
	public void produce() throws InterruptedException {
		synchronized(this) {
			while(true) {
				System.out.println("Produced meal: " + ++n);
				wait();
				notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized(this) {
			while(true) {
				System.out.println("Consumed meal: " + n);
				Thread.sleep(5000);
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
		try {obj.produce();}
		catch(InterruptedException e) {System.out.println("Producer thread interrupted.");}
	}
}

class thread2 extends Thread {
	Printing obj;
	thread2(Printing o) {
		obj = o;
		this.start();
	}
	public void run() {
		try {obj.consume();}
		catch(InterruptedException e) {System.out.println("Consumer thread interrupted.");}
	}
}

public class q8a {
	public static void main(String[] args) {
		Printing obj = new Printing();
		thread1 t1 = new thread1(obj);
		thread2 t2 = new thread2(obj);
	}
}