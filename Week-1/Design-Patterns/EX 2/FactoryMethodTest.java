package Solution;


public class FactoryMethodTest {
 
    public static void main(String[] args) {
 
        System.out.println("===== Factory Method Pattern Test =====\n");
 
        System.out.println("-- Test 1: Word Document --");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.openDocument();
 
        System.out.println();
 
        System.out.println("-- Test 2: PDF Document --");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.openDocument();
 
        System.out.println();
 
        System.out.println("-- Test 3: Excel Document --");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.openDocument();
 
        System.out.println();
 
        System.out.println("-- Test 4: Switching document type at runtime --");
        DocumentFactory factory;

        String docType = "PDF"; 
        if (docType.equals("Word")) {
            factory = new WordDocumentFactory();
        } else if (docType.equals("PDF")) {
            factory = new PdfDocumentFactory();
        } else {
            factory = new ExcelDocumentFactory();
        }
 
        factory.openDocument();
 
        System.out.println("\n===== Test Complete =====");
    }
}
 