package src.main.java.com.repository;

import java.util.List;
import src.main.java.com.model.Listing;

public interface IListingRepository {
    int add(String title, String description, int price, String username, String category);
    Listing get(int listingId);
    boolean delete(int listingId);
    List<Listing> getByCategory(String category);
    String getTopCategory();
}
