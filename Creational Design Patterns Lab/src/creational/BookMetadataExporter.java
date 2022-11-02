package creational;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileWriter;

public abstract class BookMetadataExporter extends BookCollection {
    public void export(PrintStream stream ) throws IOException, ParserConfigurationException {
        BookMetadataFormatter formatter = getFormatter();
        for (Book b : books){
            formatter.append(b);
        }
        stream.println(formatter.getMetadataString());
        
        try (FileWriter file = new FileWriter("./result.txt")){
            file.write(formatter.getMetadataString());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    
    }

    public abstract BookMetadataFormatter getFormatter() throws IOException, ParserConfigurationException;
}
