package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T>  implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        size = 0;
        header = new ListNode(null,null,trailer);
        trailer = new ListNode(null,header,null);
        this.trailer.prev= header;
        //TODO: construtor deve inicializar uma fila vazia
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        if(elem == null) throw new NullPointerException();
        try {
            ListNode prevNode = this.trailer.prev;
            ListNode newNode = new ListNode(elem,prevNode,this.trailer);
            prevNode.next = newNode;
            trailer.prev = newNode;
            this.size++;
        }
        catch(OutOfMemoryError e) {
            throw new QueueFullException(e.getMessage());
        }
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        ListNode removeNode =this.header.next;
        removeNode.next.prev = header;
        header.next=removeNode.next;

        this.size--;
        return removeNode.element;
    }

    @Override
    public T front() throws QueueEmptyException {
        return header.next.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
