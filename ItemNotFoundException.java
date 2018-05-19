/*
 * Shinya Aoi
 * RecursionHW
 * 05/11/2018
 */

/**
 * ItemNotFoundException is extends from the Exception class
 * that it throw an exception if the item was not found.
 */
public class ItemNotFoundException extends Exception {

    /**
     * A no-argument constructor.
     */
    public ItemNotFoundException(){
        super();
    }

    /**
     * constructor that takes a string value of e.
     * @param e which is target word.
     */
    public ItemNotFoundException(String e){
        super(e+" was not found!");
    }
}
