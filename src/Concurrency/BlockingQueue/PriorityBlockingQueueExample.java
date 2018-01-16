package Concurrency.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {

    static class PriorityElement<V> implements Comparable<PriorityElement>{

        private int priorityLevel;
        private V data;

        PriorityElement(int priorityLevel, V data){
            this.priorityLevel=priorityLevel;
            this.data=data;
        }

        public int getPriorityLevel(){
            return this.priorityLevel;
        }

        @Override
        public int compareTo(PriorityElement o) {
            return o.getPriorityLevel()-this.getPriorityLevel();
        }

        public V getData() {
            return data;
        }
    }
    private static BlockingQueue<PriorityElement<String>> blockingQueue= new PriorityBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        PriorityElement high= new PriorityElement(10, "HIGH");
        PriorityElement mid= new PriorityElement(5,"MID");
        PriorityElement low= new PriorityElement(1,"LOW");

        blockingQueue.put(high);
        blockingQueue.put(low);
        blockingQueue.put(mid);

        System.out.println(blockingQueue.take().getData());
        System.out.println(blockingQueue.take().getData());
        System.out.println(blockingQueue.take().getData());
    }
}
