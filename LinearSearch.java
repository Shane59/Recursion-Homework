/*
 * Shinya Aoi
 * RecursionHW
 * 05/10/2018
 */

/**
 * This class is to search by using linear search.
 */
public class LinearSearch extends SearchAlgorithm {

    /**
     * Override a search method for an iterative search.
     * @param words which is an array of words
     * @param wordToFind which is a target
     * @return the index of the target
     * @throws ItemNotFoundException
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        for (int i = 0; i < words.length; i++) {
            incrementCount();
            if(words[i].equals(wordToFind)) return i;
        }
        throw new ItemNotFoundException(wordToFind);
    }

    /**
     * This method calls the other recSearch method to complete.
     * @param words
     * @param wordToFind
     * @return
     * @throws ItemNotFoundException
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(wordToFind,words,0);
    }

    /**
     * This method is to search a target word recursively.
     * @param targetWord which is a target.
     * @param words which is an array of wards.
     * @param startIndex
     * @return an index of the target.
     * @throws ItemNotFoundException
     */
    public int recSearch(String targetWord, String[] words, int startIndex) throws ItemNotFoundException {
        incrementCount();
        if(startIndex==words.length-1) {
            if(words[startIndex].equals(targetWord)) return startIndex;
            else throw new ItemNotFoundException(targetWord);
        }
        else{
            if(targetWord.equals(words[startIndex])){
                return startIndex;
            }
            else{
                return recSearch(targetWord,words,startIndex+1);
            }
        }
    }
}
