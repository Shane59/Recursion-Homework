/*
 * Shinya Aoi
 * RecursionHW
 * 05/10/2018
 */
import java.io.File;

/**
 * This class searches directories for a target file name.
 */
public class FindFile {
    private int maxFile; //how do you use this
    private int count=0;
    private String[] file; //putting files?

    /**
     * A constructor to set maxFile of searching
     * @param maxFile
     */
    public FindFile(int maxFile){
        this.maxFile = maxFile;
        file = new String[maxFile];
    }

    /**
     * This method searches a file.
     * @param target which is a file
     * @param dirName which is a path to search a target.
     */
    public void directorySearch(String target, String dirName) throws IllegalArgumentException{
        File f = new File(dirName);
        if(!f.isDirectory()){
            throw new IllegalArgumentException(); //Is this right?
        }
        String[] temp = f.list();
        if(temp == null) return;
        for (String aTemp : temp) {
            File aFile = new File(dirName + "\\" + aTemp);
            if (aFile.isDirectory()) {
                directorySearch(target, aFile.getAbsolutePath());
            }
            if (aFile.isFile()) {
                if (aFile.getName().equals(target)) {
                    file[count++] = aFile.getAbsolutePath();
                }
            }
        }
    }

    /**
     * This returns a value of count.
     * @return count
     */
    public int getCount(){
        return count;
    }

    /**
     * This returns an array of string
     * @return file
     */
    public String[] getFiles(){
        return file;
    }
}
