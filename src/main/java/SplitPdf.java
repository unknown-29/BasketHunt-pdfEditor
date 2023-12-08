import com.spire.pdf.PdfDocument;

public class SplitPdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load the source PDF file
        PdfDocument sourceDoc = new PdfDocument("/home/dm/eclipse-workspace/test/output/Merge.pdf");

        //Create another two PdfDocument objects
        PdfDocument newDoc_1 = new PdfDocument();
        PdfDocument newDoc_2 = new PdfDocument();

        //Insert the first page of source file to the first document
        newDoc_1.insertPage(sourceDoc, 0);

        //Insert the rest pages of source file to the second document
        newDoc_2.insertPageRange(sourceDoc, 1, sourceDoc.getPages().getCount() - 1);

        //Save to two different PDF files
        newDoc_1.saveToFile("output/NewPDF_1.pdf");
        newDoc_2.saveToFile("output/NewPDF_2.pdf");
	}

}
