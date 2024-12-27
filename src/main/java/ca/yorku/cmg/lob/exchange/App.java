package ca.yorku.cmg.lob.exchange;


import java.util.Map;


public class App {
	
    public static void main(String[] args) {
        ArgumentProcessor processor = new ArgumentProcessor();
        Map<String, String> arguments = processor.parseArguments(args);

        if (arguments == null) {
            return; // Invalid arguments or help requested, so exit
        }

    	Exchange exc = new Exchange();

    	
    	exc.readSecurityListfromFile(arguments.get("securities")); 
    	exc.readAccountsListFromFile(arguments.get("accounts"));
    	exc.readInitialPositionsFromFile(arguments.get("initial_positions"));
    	String init_balances = exc.printBalances(true);
    	exc.processOrderFile(arguments.get("orders"));
    	
    	System.out.println(exc.printAskTable(false));
    	System.out.println(exc.printBidTable(false));
    	System.out.println(exc.printTradesLog(true));
    	System.out.println(init_balances);
    	System.out.println(exc.printBalances(true));
    	System.out.println(exc.printFeesCollected(true));
    }
}
