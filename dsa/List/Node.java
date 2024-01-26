package dsa.list;

/**
 * This interface if for node, where it contains only data so it has it getters and mutattors.
 */
public interface Node<E> {
    /**
     * The function to fetch the data.
     * @return the data.
     */
    public E getData();
    /**
     * the function to set the data.
     * @param data the data to be set.
     */
    public void setData(E data);
}
