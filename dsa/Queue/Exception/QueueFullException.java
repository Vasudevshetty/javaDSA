package dsa.queue.Exception;

public class QueueFullException extends RuntimeException{
    public QueueFullException(String message){
        super(message);
    }
}
