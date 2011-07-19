import org.jibble.pircbot.*;

public class MainTestBot {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        TestBot bot = new TestBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("127.0.0.1");

        // Join the #pircbot channel.
        bot.joinChannel("#Bot");
        
    }
    
}