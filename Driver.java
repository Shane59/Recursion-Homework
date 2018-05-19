/*
 * Shinya Aoi
 * HW Recursion
 * 05/10/2018
 */
/**
 * Driver for the recursion class to test the method.
 * If file does not exist, throw it to
 */
public class Driver {
    public static void main(String[] args) {
        int maxFile=1;
        String targetName = "ICE job.docx";
        String pathToSearch = "C:\\Users\\tkn27\\Desktop";
        FindFile finder = new FindFile(maxFile);
        try {
            finder.directorySearch(targetName, pathToSearch);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("File is full!");
        }
        if(finder.getCount()==0){
            System.out.println("File was not found!");
        }
        for(int i=0; i< finder.getCount(); i++) {
            if (finder.getFiles()[i]!=null){
                System.out.println(finder.getFiles()[i]);
            }
        }
    }
}
