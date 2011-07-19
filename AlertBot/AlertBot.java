import org.jibble.pircbot.*;

public class AlertBot {
    public static void main(String[] args) throws Exception {
    
        
        // Now start our bot up.
        Bot bot = new Bot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("127.0.0.1");

        // Join the channels channel.
        bot.joinChannel("#Bot");
	bot.joinChannel("#test");
	bot.joinChannel("#DnD");
        
    }
    
}