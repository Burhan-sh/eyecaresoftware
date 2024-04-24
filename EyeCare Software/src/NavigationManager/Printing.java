package NavigationManager;

import PrintingManager.PrintingBase;

public class Printing {
	
	public Printing(Object ids) {
		PrintingBase printingBase = new PrintingBase(ids);
		printingBase.directPrint();
	}

}
