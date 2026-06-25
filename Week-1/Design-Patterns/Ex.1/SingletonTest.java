package SingletonPatternExample;

public class SingletonTest {
	    public static void main(String[] args) {

	        System.out.println("===== Singleton Pattern Test =====\n");

	        System.out.println("-- Test 1: Getting Logger instance (logger1) --");
	        Logger logger1 = Logger.getInstance();
	        logger1.log("Application has started.");
	        logger1.warn("Low memory detected.");

	        System.out.println();

	        
	        System.out.println("-- Test 2: Getting Logger instance again (logger2) --");
	        Logger logger2 = Logger.getInstance();
	        logger2.log("User logged in.");
	        logger2.error("File not found.");

	        System.out.println();

	        
	        System.out.println("-- Test 3: Verifying both instances are the same --");
	        System.out.println("logger1 hashCode: " + logger1.hashCode());
	        System.out.println("logger2 hashCode: " + logger2.hashCode());

	        if (logger1 == logger2) {
	            System.out.println("SUCCESS: logger1 and logger2 are the SAME instance!");
	        } else {
	            System.out.println("FAILURE: Two different instances were created!");
	        }

	        System.out.println();

	      
	        System.out.println("-- Test 4: Simulating another module using Logger --");
	        Logger loggerFromAnotherModule = Logger.getInstance();
	        loggerFromAnotherModule.log("Payment module initialized.");
	        System.out.println("Same as logger1? " + (loggerFromAnotherModule == logger1));

	        System.out.println("\n===== Test Complete =====");
	    }
	}
