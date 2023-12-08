import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfDocumentBase;

import java.io.File;

public class MergePdf {

    public static void main(String[] args) {

        //Specify folder path
        File folder = new File("/home/dm/Downloads/pdfs");

        //Get files under the folder
        File[] listOfFiles = folder.listFiles();

        //Define a string array
        String[] filePaths = new String[listOfFiles.length];

        //Loop through the files
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                //Get absolute path of each file and write the string array
                filePaths[i] = listOfFiles[i].getAbsolutePath();
            }
        }

        //Merge these files
        PdfDocumentBase doc = PdfDocument.mergeFiles(filePaths);

        //Save to a PDF file
        doc.save("output/Merge.pdf", FileFormat.PDF);
        doc.dispose();
    }
}
