import org.jibble.pircbot.*;

public class Bot extends PircBot {
	Alerter[] alert;
    
	public Bot() {
		this.setName("AlertBot");
		this.alert = new Alerter[16];
	}
    
	public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
		if (message.equalsIgnoreCase("time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
		
		if (message.equalsIgnoreCase("list alerts")){
			String WhereWatching = "Watchers on: ";
			for (int i = 0; i < 16; i++){
			if (alert[i] != null) WhereWatching += alert[i].channel+" by "+alert[i].poster+", ";
			}
			sendMessage(channel,WhereWatching);
		}
		
		if (message.equalsIgnoreCase("watch") && sender.equalsIgnoreCase("Mauve")){
			boolean worked = false;
			for (int i = 0; i < 16; i ++){
				if (alert[i]== null){
					alert[i] = new Alerter(channel,sender);
					alert[i].channel = channel;
					alert[i].poster = sender;
					worked = true;
					System.out.println("Made an alerter on "+alert[i].channel);
					i = 16;
				}
			}
			if (!worked) sendMessage(sender,"Derp herp, all the channel watchers are already taken");
		} else if (message.equalsIgnoreCase("watch stop") && sender.equalsIgnoreCase("Mauve")) {
			for (int i = 0; i < 16; i++) {
				if (alert[i] != null && alert[i].channel == channel) {
					alert[i] = null;
					i = 16;
					System.out.println("Killed the alerter on "+channel);
				}
			}
		}
	}
	
	public void onJoin(String channel,String sender, String login, String hostname) {
		for (int i = 0; i < 16; i++){
			//if (alert[i]!=null) System.out.println(alert[i].channel+", "+channel);
			if (alert[i] != null && alert[i].channel.equalsIgnoreCase(channel)){
				//System.out.println(alert[i].channel);
				alert[i].Alert();
				sendMessage(alert[i].poster,login+" joined "+channel);
				alert[i] = null;
				i = 16;
			}
		}
		//System.out.println(channel+" "+sender+" "+login);
	}
}