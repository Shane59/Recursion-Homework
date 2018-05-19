/*
 * Shinya Aoi
 * RecursionHW
 * 05/11/2018
 */

/**
 * This class is to find a target word by using binary search.
 */
public class BinarySearch extends SearchAlgorithm {

    /**
     * Override a search method from SearchAlgorithm class.
     * This search method is to find a target word iteratively.
     * If the target word was not found, throw it into exception.
     * @param words which is an array of words.
     * @param wordToFind which is a target.
     * @return return its index number which is middle index here.
     * @throws ItemNotFoundException
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int first = 0;
        int last = words.length-1;

        while(first<=last) {
            int middle = (first + last) / 2;
            incrementCount();
            if (words[middle].equals(wordToFind)) return middle;
            else {
                if (words[middle].compareTo(wordToFind) < 0) {
                    first = middle + 1;
                } else {
                    last = middle - 1;
                }
            }
        }
        throw new ItemNotFoundException(wordToFind);
    }

    /**
     * This method to find a target word recursively by calling recSearch2 which helps
     * this search method. If the target word was not found, throw it into exception.
     * @param words which is an array of words.
     * @param wordToFind which is a target
     * @return index number if it is found.
     * @throws ItemNotFoundException
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch2(words,0,words.length-1, wordToFind);
    }

    /**
     * This class is to find a target word recursively. This is also helping the above method.
     * If the target word was not found, throw it into exception.
     * @param words which is an array of words.
     * @param first which is the first index that we look for.
     * @param last which is the last index the we look for.
     * @param target which is a target word.
     * @return its index number.
     * @throws ItemNotFoundException
     */
    public int recSearch2(String[] words, int first, int last, String target) throws ItemNotFoundException {
        incrementCount();
        if (first == last) {
            if (words[first].equals(target)) return first;
        }
        int midIndex = (first + last) / 2;
        while (first <= last) {
            if (words[midIndex].equals(target)) return midIndex;
            if (words[midIndex].compareTo(target) < 0) {
                return recSearch2(words, midIndex + 1, last, target);
            }
            else if(words[midIndex].compareTo(target)>0) {
                return recSearch2(words, first, midIndex - 1, target);
            }
        }
        throw new ItemNotFoundException(target);
    }
}
