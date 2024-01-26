package dsa.queue.Exception;

public class QueueEmptyException extends RuntimeException{
    public QueueEmptyException(String message){
        super(message);
    }
}
