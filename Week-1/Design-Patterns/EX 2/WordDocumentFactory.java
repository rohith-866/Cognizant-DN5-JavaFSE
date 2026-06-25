package Solution;

public class WordDocumentFactory extends DocumentFactory {
 
    @Override
    public Document createDocument() {
        System.out.println("[Factory] Creating a Word Document...");
        return new WordDocument();
    }
}
 