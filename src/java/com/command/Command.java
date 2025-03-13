package src.java.com.command;

import src.java.com.service.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command{
    private final Service service;
    public Command(Service service){
        this.service = service;
    }
    public String handleCommand(String command) {
        List<String> parts = parseCommand(command);
        if (parts.isEmpty()) {
            return "Error - invalid command";
        }
        String cmd = parts.get(0).toUpperCase();

        if (cmd.equals("REGISTER") && parts.size() == 2) {
            return service.registerUser(parts.get(1));
        }
        else if (cmd.equals("CREATE_LISTING") && parts.size() == 6) {
            return service.createListing(parts.get(1), parts.get(2), parts.get(3), Double.parseDouble(parts.get(4)), parts.get(5));
        }
        else if(cmd.equals("DELETE_LISTING") && parts.size() == 3){
            return service.deleteListing(parts.get(1), Integer.parseInt(parts.get(2)));
        }
        else if(cmd.equals("GET_LISTING") && parts.size() == 3){
            return service.getListing(parts.get(1), Integer.parseInt(parts.get(2)));
        }

        return "Error - invalid command";
    }
    private List<String> parseCommand(String command) {
        List<String> parts = new ArrayList<>();
        Matcher m = Pattern.compile("([^'\\s]+|'[^']*')\\s*").matcher(command);
        while (m.find()) {
            parts.add(m.group(1).replace("'", ""));
        }
        return parts;    
    }
    
}