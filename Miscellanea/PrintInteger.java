//Gets a number from the console and prints that many times the name of the program
//@author Sam
//@category Miscelanea
//@keybinding
//@menupath
//@toolbar

import ghidra.app.script.GhidraScript;

public class PrintInteger extends GhidraScript {

	@Override
	protected void run() throws Exception {
		//TODO: Add script code here
	
		int n = askInt( "How many times?" ,  "N" );
		for ( int i = 0 ; i < n ; ++i ) {
			if ( monitor.isCancelled() ) {
				break;
			}
	      println( i + ":" + currentProgram.getName() );
	      Thread.sleep( 1000 );
		}	
	}
}
