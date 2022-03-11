package com.codeexrcise.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThreadClass {

	public static void main(String[] args) {

		Queue<Integer> q = new PriorityQueue<Integer>();
		ThreadClass t = new ThreadClass();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				t.retrieve(q);
			}

		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				t.insertIntoList(q);
			}
		});

		t1.start();
		t2.start();

	}

	synchronized void retrieve(Queue<Integer> q) {
		if (q == null || q.isEmpty()) {
			Thread t = Thread.currentThread();
			System.out.println("Waiting for element to be inserted in queue :- " + t.getName());
			try {
				wait();
			System.out.println("Waiting over  :- " + t.getName());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Element in queue is :- " +q.element());
	}

	synchronized void insertIntoList(Queue<Integer> q) {
		Thread t = Thread.currentThread();
		System.out.println("Inserting element  in queue :- " + t.getName());
		q.add(2);
		System.out.println("Element inserted  in queue :- " + t.getName());
		notify();
  
	}

}
