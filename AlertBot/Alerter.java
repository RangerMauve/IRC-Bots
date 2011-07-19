// This is a class that is used to handle alerting stuff.

public class Alerter{
	public String channel, poster;

	Alerter(String chan, String Post){
		channel = new String(chan);
		poster = new String(Post);
	}
/*
// create a pure tone of the given frequency for the given duration
	public static double[] tone(double hz, double duration) { 
        int N = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[N+1];
        for (int i = 0; i <= N; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a; 
	}*/ 
	
	// This sends the alert
	public void Alert(){
		char a = 7;
		//StdAudio.play(tone(1400,10));
		for (int i = 0; i <4; i++) System.out.println(a);
	}
}