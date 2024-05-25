package PrintingManager;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

import TableConstrain.GetPrintingData;

@SuppressWarnings("serial")
public class PrintingBase extends JFrame implements ActionListener {

	private JTextPane mTextPane;
    
    public void setPrintBase(String ids) {
    	 setTitle("Printer preview demo");
         setSize(600, 600);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel(new BorderLayout());

         mTextPane = new JTextPane();
         mTextPane.setContentType("text/html");

         StringBuilder builder = new StringBuilder();
         
         DesignFormateOne dn = new DesignFormateOne();
         
         GetPrintingData gp = new GetPrintingData();
         String[] customerData = gp.getPresecriptionResult(ids);
         String fromate = dn.formateTwo(customerData , ids);
         
         builder.append(fromate);

         mTextPane.setText(builder.toString());

         JButton previewButton = new JButton("Preview");
         previewButton.addActionListener(this);

         panel.add(new JScrollPane(mTextPane), BorderLayout.CENTER);
         panel.add(previewButton, BorderLayout.SOUTH);
         getContentPane().add(panel);
    	
    }
	
	@Override
	public void actionPerformed(ActionEvent event){
		JDialog dialog = new JDialog();
		dialog.setModal(true);
		dialog.setSize(700, 600);
		dialog.setLayout(new BorderLayout());
		
		HashPrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
		set.add(MediaSizeName.ISO_A4);
		set.add(OrientationRequested.PORTRAIT);
		
		PageFormat pf = PrinterJob.getPrinterJob().getPageFormat(set);

		final PrintPreview preview = new PrintPreview(mTextPane.getPrintable(null, null), pf);

		    // Load an image for the printButton's icon
		    ImageIcon printIcon = new ImageIcon("resources/printer.png");
		    JButton printButton = new JButton(printIcon);
		    printButton.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent arg0) {
		        	// Close the   Base JFrame
		            PrintingBase.this.dispose();
		            preview.print();
		            dialog.dispose();
		        }
		    });

		    JPanel buttonsPanel = new JPanel();
		    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		    
		    JPanel blankspace = new JPanel();
		    int panelHeight = 30; // Set your desired height here

		    blankspace.setPreferredSize(new Dimension(this.getWidth(), panelHeight));

		    // Add the printButton before preview.getControls()
		    buttonsPanel.add(printButton);
		    buttonsPanel.add(preview.getControls());
		    buttonsPanel.add(blankspace);

		    dialog.add(preview, BorderLayout.CENTER);
		    dialog.add(buttonsPanel, BorderLayout.NORTH);
		    dialog.setVisible(true);
	}
	
	public void directPrint() {
		HashPrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
		set.add(MediaSizeName.ISO_A4);
		set.add(OrientationRequested.PORTRAIT);
		
		PageFormat pf = PrinterJob.getPrinterJob().getPageFormat(set);

		final PrintPreview preview = new PrintPreview(mTextPane.getPrintable(null, null), pf);
		preview.print();
	}
	
	
	
}
