package Solution;

public class PdfDocumentFactory extends DocumentFactory {
 
    @Override
    public Document createDocument() {
        System.out.println("[Factory] Creating a PDF Document...");
        return new PdfDocument();
    }
}
 