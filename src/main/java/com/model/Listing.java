package src.main.java.com.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Listings should have the following fields:
- Title
- Description
- Price
- Username
- Creation time
*/

public class Listing {
    private final int id;
    private final String title;
    private final String description;
    private final int price;
    private final String username;
    private final String category;
    private final String createdAt;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Listing(int id, String title, String description, int price, String username, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.username = username;
        this.category = category;
        this.createdAt = LocalDateTime.now().format(formatter);
    }

        public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getUsername() {
        return username;
    }

    public String getCategory() {
        return category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s", 
                title, description, price, createdAt, category, username);
    }

    public String toShortString() {
        return String.format("%s|%s|%s|%s", 
                title, description, price, createdAt);
    }

}