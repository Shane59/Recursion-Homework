/*
 * Shinya Aoi
 * CSS 143A
 * Data Structures: ArrayList-like Structures, Stacks, and Queues
 * 04/20/2018
 */

/**
 * ArrayList class is a class run like an ArrayList.
 * This class contains insert, remove, size, toString
 * isEmpty, indexOf, equals, get, and resizeArray methods.
 */
public class ArrayList {
    private Object[] arr = new Object[3];
    private int numOfElements = 0;

    /**
     * First, This method checks if an array is full or not. If it is full
     * it calls resizeArray method to increase size of the array. Then, move the array
     * one index to the right to make a space by using the System.arraycopy. And
     * assign the object to the index of array. Finally, increase numOfElements by one.
     * @param object that will be insert in an existing array.
     * @param index where to put an object.
     */
    public void insert(Object object, int index){//make a method for resizing the array
        if(arr.length==numOfElements) resizeArray();
        System.arraycopy(arr, index, arr,index+1, arr.length-index-1);
        arr[index] = object;
        numOfElements++;
    }

    public ArrayList(Object[] input) {
        arr = input;
        numOfElements = input.length;
    }


    /**
     * This method removes an object in an array of the index and returns the object.
     * @param index where to remove an object.
     * @return the object that has been removed.
     */
    public Object remove(int index){
        numOfElements--;
        Object remove = arr[index];
        System.arraycopy(arr, index+1, arr, index, numOfElements-index);
        return remove;
    }

    /**
     * This method returns to the size of the array which is numOfElements.
     * @return numOfElements.
     */
    public int size(){
        return numOfElements;
    }

    /**
     * Override toString that prints out an array.
     * @return retVal.
     */
    @Override
    public String toString() {//when do i use this?
        String retVal = "";
        for(int i=0; i<numOfElements; i++){
            if(i==0){
                retVal = retVal+arr[i];
                continue;
            }
            retVal = retVal+ ","+ arr[i];
        }
        return retVal;
    }

    /**
     * This method checks if an array is empty or not.
     * @return true if it is empty.
     */
    public boolean isEmpty(){
        return numOfElements == 0;
    }

    /**
     * This methods returns an index of the object. It returns the index of that object
     * that has been passed as an argument, but it returns -1 if it does not match.
     * @param object that would match with an existing object.
     * @return index. If there is no object that matches, it returns -1.
     */
    public int indexOf(Object object){
        for(int i=0; i<numOfElements; i++){
            if(arr[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Override that checks if the object is the same as the argument(object).
     * Also checks if it is empty or not.
     * @param other object that is passed, then change it to that
     * @return true if they are the same object.
     */
    @Override
    public boolean equals(Object other){
        if(!(other instanceof ArrayList)) return false;
        ArrayList that = (ArrayList) other;
        if(this.numOfElements==that.numOfElements){
            for(int i=0;i<numOfElements;i++){
                if(!this.arr[i].equals(that.arr[i])) return false;
            }
        }
        else return false;
        return true;
    }

    /**
     * This method gets an object of the index.
     * @param index of the array.
     * @return the object of the index.
     */
    public Object get(int index){
        if(index>numOfElements) return null;
        return arr[index];
    }

    /**
     * This method increases the size of the array.
     */
    public void resizeArray(){
        Object[] newArr = new Object[arr.length+100];
        System.arraycopy(arr,0,newArr,0,arr.length);
        arr = newArr;
    }
}
