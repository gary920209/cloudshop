package src.main.java.com.service;

import java.util.List;
import java.util.stream.Collectors;
import src.main.java.com.model.Listing;
import src.main.java.com.model.User;
import src.main.java.com.repository.IListingRepository;
import src.main.java.com.repository.IUserRepository;

public class Service{
    private final IUserRepository userRepository;
    private final IListingRepository listingRepository;

    public Service(IUserRepository userRepository, IListingRepository listingRepository){
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
    }
    // REGISTER
    public String registerUser(String username) {
        User user = new User(username);
        if (!userRepository.add(user)) {
            return "Error - user already existing";
        }
        return "Success";
    }
    // CREATE_LISTING <username> <title> <description> <price> <category>
    public String createListing(String username, String title, String description, 
                               int price, String category){
        User user = userRepository.get(username);
        if (user == null) {
            return "Error - unknown user";
        }
        int listingId = listingRepository.add(title, description, price, username, category);
        return String.valueOf(listingId);
    }
    public String deleteListing(String username, int listingId){
        User user = userRepository.get(username);
        Listing listing = listingRepository.get(listingId);
        if(listing == null){
            return "Error - listing does not exist";
        }
        if(!listing.getUsername().equals(username)){
            return "Error - listing owner mismatch";
        }
        listingRepository.delete(listingId);
        return "Success";
    }
    public String getListing(String username, int listingId){
        User user = userRepository.get(username);
        if(user == null){
            return "Error - unknown user";
        }
        Listing listing = listingRepository.get(listingId);
        if(listing == null){
            return "Error - not found";
        }
        return listing.toString();
    }
    public String getCategory(String username, String category){
        User user = userRepository.get(username);
        if(user == null){
            return "Error - unknown user";
        }
        List<Listing> listings = listingRepository.getByCategory(category);
        if(listings.isEmpty()){
            return "Error - category not found";
        }
        return listings.stream()
                .map(Listing::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getTopCategory(String username){
        User user = userRepository.get(username);
        if(user == null){
            return "Error - unknown user";
        }
        String topCategory = listingRepository.getTopCategory();
        if(topCategory == null){
            return "Error - Category is empty";
        }
        return topCategory;
    }
    
    // To Do: Implement the following methods
}