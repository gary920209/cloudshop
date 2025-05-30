package src.main.java.com.repository;

import java.util.*;
import java.util.stream.Collectors;
import src.main.java.com.model.Listing;

public class ListingRepository implements IListingRepository {
    private final Map<Integer, Listing> listings = new HashMap<>();
    private final Map<String, List<Integer>> categoryListings = new HashMap<>();

    @Override
    public int add(String title, String description, int price, String username, String category) {
        int listingId = listings.size() + 100001;
        Listing listing = new Listing(listingId, title, description, price, username, category);
        listings.put(listingId, listing);
        categoryListings.computeIfAbsent(category, k -> new ArrayList<>()).add(listingId);
        return listingId;
    }
    public Listing get(int listingId) {
        return listings.get(listingId);
    }

    @Override
    public boolean delete(int listingId){
        Listing listing = listings.get(listingId);
        if (listing == null) {
            return false;
        }
        listings.remove(listingId);
        List<Integer> categoryList = categoryListings.get(listing.getCategory());
        if (categoryList != null) {
            categoryList.remove(Integer.valueOf(listingId));
            // If this was the last listing in the category, remove the category
            if (categoryList.isEmpty()) {
                categoryListings.remove(listing.getCategory());
            }
        }
        return true;
    }

    // This command should return listings of the specified category in descending order by create time
    @Override
    public List<Listing> getByCategory(String category) {
        List<Integer> listingIds = categoryListings.get(category);
        if (listingIds == null || listingIds.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Listing> result = new ArrayList<>();
        for (Integer id : listingIds) {
            Listing listing = listings.get(id);
            if (listing != null) {
                result.add(listing);
            }
        }
    
        // Sort by creation time descending
        result.sort(Comparator.comparing(Listing::getCreatedAt).reversed());
        return result;
    }

    // This command should return the category with the most listings
    @Override
    public String getTopCategory() {
        if (categoryListings.isEmpty()) {
            return null;
        }
        int max_size = categoryListings.values().stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);

        List<String> topCategories = categoryListings.entrySet().stream()
                .filter(entry -> entry.getValue().size() == max_size)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        return String.join(", ", topCategories);
    }

}