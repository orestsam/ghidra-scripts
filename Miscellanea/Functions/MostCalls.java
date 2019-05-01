//Shows in the listing the address of the function with most functions called within its body.
//@author Sam
//@category Home.Miscellanea.Tests.Functions
//@keybinding 
//@menupath 
//@toolbar

import ghidra.app.script.GhidraScript;
import ghidra.program.model.listing.Function;
import ghidra.program.model.listing.Program;

import java.util.*;

public class MostCalls extends GhidraScript {

	@Override
	protected void run() throws Exception {
		
		//Creation of initialized variables for keeping track
		int max = 0;
		Function mostFuns = null;
		//Iterator for traveling through the Analyzed program
		for(Function scan = getFirstFunction(); scan != null; scan = getFunctionAfter(scan.getEntryPoint())) {
			
			Set<Function> setFuns = scan.getCalledFunctions(monitor);
			if(max < setFuns.size()) {
				max = setFuns.size();
				mostFuns = scan;
			}
		}
		//Error handling
		if(mostFuns == null) {
			println("No function found. (Has the program already been analyzed?)");
		}
		else {
			println("Showing address on listing");
			goTo(mostFuns.getEntryPoint());
		}
		
		//TODO: Add script code here
	}
}
