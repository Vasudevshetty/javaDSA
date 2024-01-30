package dsa.list;

/**
 * The functinal interface for circualr linkedc list where it conatins the
 * isciruclar utility function.
 */
@FunctionalInterface
public interface CircularLinkedList<E> {
    /**
     * The function to check whterh the list is circular or not.
     * @return the result of being circular or not.
     */
    boolean isCircular();
}
