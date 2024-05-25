package NavigationManager;

import java.awt.event.ActionEvent;

import PrintingManager.PrintingBase;

public class PrintPreview {
	PrintingBase printingBase;
	
	public PrintPreview() {
		this.printingBase = new PrintingBase();
	}
	
	public void setPrintData(String ids) {
		this.printingBase.setPrintBase(ids);
        printingBase.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
	}
	
}