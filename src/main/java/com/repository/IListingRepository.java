package src.main.java.com.repository;

import src.main.java.com.model.Listing;
import java.util.List;

public interface IListingRepository {
    int add(String title, String description, double price, String username, String category);
    Listing get(int listingId);
    boolean delete(int listingId);
    List<Listing> getByCategory(String category);
    String getTopCategory();
}
