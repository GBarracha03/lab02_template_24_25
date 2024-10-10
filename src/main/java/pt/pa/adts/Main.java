package pt.pa.adts;

import pt.pa.adts.queue.Queue;
import pt.pa.adts.queue.QueueLinkedList;

public class Main {
  public static void main(String[] args) {
    Queue<Integer> queue;
    queue = new QueueLinkedList<Integer>();

      queue.enqueue(1);
      queue.dequeue();
      queue.enqueue(2);
      queue.enqueue(3);
      System.out.println(queue.front());


  }
}