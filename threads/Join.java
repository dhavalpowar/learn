public class Join extends Thread	{
	private String info;
	Join aT1;

	public Join (String info) {
		this.info = info;
	}

	public void run () {
		System.out.println(info + " is running");
		try {
			sleep(10);
		}
		catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
			if ( isInterrupted() )
				System.err.println("yup it's true.");
		}
		System.out.println(info + ": exit run");

	}
	public static void main (String args []) {
		Join aT1  = new Join("first");
		Join aT2  = new Join("second");
		Join aT3  = new Join("third");

		aT1.start();
		aT2.start();
		aT3.start();
		try {
			aT1.join();
			aT2.join();
			aT3.join();
			System.err.println("Got it");
		}
		catch (  InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
