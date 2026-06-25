package Solution;

public abstract class DocumentFactory {
 
    // ★ The Factory Method — subclasses must implement this
    public abstract Document createDocument();
 
    // Common workflow using the created document
    public void openDocument() {
        Document doc = createDocument(); // Factory method called here
        doc.open();
        doc.save();
        doc.close();
    }
}
 

