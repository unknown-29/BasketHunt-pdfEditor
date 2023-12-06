import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String pdfFilePath = "/home/dm/eclipse-workspace/test/src/main/java/input.pdf";
        String wordFilePath = "output.docx";

        try {
            convertPdfToWord(pdfFilePath, wordFilePath);
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertPdfToWord(String pdfFilePath, String wordFilePath) throws IOException {
        try (PDDocument document = PDDocument.load(new FileInputStream(pdfFilePath));
             FileOutputStream out = new FileOutputStream(wordFilePath);
             XWPFDocument wordDocument = new XWPFDocument()) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            XWPFParagraph paragraph = wordDocument.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(text);

            wordDocument.write(out);
        }
    }
}