package creational;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    
    private ArrayList<JSONObject> books;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        books = new ArrayList<>();
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject book = new JSONObject();
        List<String> author = Arrays.asList(b.getAuthors());
        book.put("Authors",author);
        book.put("Title", b.getTitle());
        book.put("ISBN", b.getISBN());
        book.put("Publisher", b.getPublisher());
        books.add(book);
        return this;
    }

    @Override
    public String getMetadataString() {
        HashMap<String, Object> b = new HashMap<>();
        b.put("Books", books);
        JSONObject book = new JSONObject(b);
        return book.toString();
    }
}
