import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.queue.Queue;
import pt.pa.adts.queue.QueueLinkedList;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueLinkedListTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp(){
        queue = new QueueLinkedList<Integer>();
    }

    @Test
    public void enqueueTest(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.size(),3);
    }

    @Test
    public void dequeueTest(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        assertEquals(queue.size(),2);
    }
}
