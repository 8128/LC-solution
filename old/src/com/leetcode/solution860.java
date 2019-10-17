class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isEmpty()){
            tail=0;
            head=0;
            data[0]=value;
            return true;
        }else if(!isFull()){
            if(tail==size-1){
                data[0] = value;
                tail = 0;
            }else{
                tail++;
                data[tail] = value;
            }
            return true;
        }else{
            return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(head==tail&&head!=-1){
            head=-1;
            tail=-1;
            return true;
        }else if(!isEmpty()){
            if(head==size-1){
                head=0;
            }else{
                head++;
            }
            return true;
        }else{
            return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()){
            return data[head];
        }else{
            return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()){
            return data[tail];
        }else{
            return -1;
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head==-1){
            return true;
        }else{
            return false;
        }
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((head==0&&tail==size-1)||(tail+1==head)){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
