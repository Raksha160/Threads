package com.treadutil;
class Cab implements Runnable {

    private String cabDriverName;
    private final Object lock = new Object();

    public Cab(String cabDriverName) {
        this.cabDriverName = cabDriverName;
    }

    public void printArray() {
        synchronized (lock) {
            System.out.println(cabDriverName + " is waiting for passenger...");
            try {
                lock.wait(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println(cabDriverName + " is done waiting.");
        }
    }
    public void run() {
        printArray();
    }
}

public class CabEx {

	public static void main(String[] args) {
		 Cab cab = new Cab("Erric");
	     Thread th1 = new Thread(cab);
	     th1.start();

	}

}
