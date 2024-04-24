package NavigationManager;

import java.awt.event.ActionEvent;

import PrintingManager.PrintingBase;

public class PrintPreview {
	PrintingBase printingBase;
	
	public PrintPreview() {
		this.printingBase = new PrintingBase();
	}
	
	public void setPrintData(Object ids) {
//    	System.out.println("excuted !!!");
//    	new PrintingBase().setVisible(true);
//    	PrintingBase printingBase = new PrintingBase(ids);
		this.printingBase.setPrintBase(ids);
        printingBase.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
	}
	
}