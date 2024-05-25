package PrintingManager;

import TableConstrain.GetPrescriptionData;

public class DesignFormateOne {
	
	public String styleSheet() {
		String stringValue = "<style> body{margin:10px;} table {width: 100%; border-left:1px solid black; border-right:1px solid black;} .borderOnTop{ border-top: 1px solid black; } .sales_heading{font-size: 15px; margin-bottom: 0px;} .Eyecare_heading{font-size: 20px;} .font_weight_400{font-weight: 400;} .textAlign_Center{text-align: center;} tr , .lastEleBorder {border-bottom: 1px solid black;} #Extraborder{border-right: 1px solid black;} .balance_paragraph{width:0px} .widthFull{width:100%} tr.repeter_billing_border td {text-align: center;} .lastEleDot{margin-bottom:-10px} .borderOnRight{ border-bottom: 1px solid black}</style>";
		return stringValue;
	}
	
	public String htmlStrat() {
		String styleSheet = this.styleSheet();
		String stringValue = "<html><head>"+styleSheet+"</head><body>";
		return stringValue;
	}

	public String htmlEnd() {
		String stringValue = "</body></html>";
		return stringValue;
	}
	
	public String headerPart() {
		String stringValue = "<div><table cellspacing=0 class='borderOnTop'> <thead class='MainBorder'> <tr> <th colspan=\"10\"> <h3 class=\"sales_heading\">Sales Invoice</h3> <h2 class=\"Eyecare_heading\">EyeCare Software</h2> </th> </tr> </thead>";
		return stringValue;
	}
	
	public String footerPart() {
		String stringValue = "</table>";
		return stringValue;
	}
	
	public String nextTableStart() {
		String stringValue = "<table cellspacing=0><tbody>";
		return stringValue;
	}
	
	public String nextTableEnd() {
		String stringValue = "</tbody></table>";
		return stringValue;
	}
	
	public String firstSection(String[] CustomerData) {
//		for (String data : CustomerData) {
//            System.out.println(data);
//        }
		String stringValue = " <tr class='MainBorder'> <td colspan=\"2\"><h3>Recipt Number :</h3><h3>Customer Name :</h3><h3>Address :</h3></td> <td colspan=\"2\"><h3 class=\"font_weight_400\">"+CustomerData[30]+"</h3><h3 class=\"font_weight_400\">"+CustomerData[23]+"</h3><h3 class=\"font_weight_400\">"+CustomerData[24]+"</h3></td> <td></td> <td colspan=\"2\"><h3>Phone No :</h3><h3>Receipt Date</h3><h3>Delivery Date</h3></td> <td colspan=\"2\"><h3 class=\"font_weight_400\">"+CustomerData[25]+"</h3><h3 class=\"font_weight_400\">25-june-2013</h3><h3 class=\"font_weight_400\">25-june-2013</h3></td> <td></td> </tr>";
		return stringValue;
	}
	
	public String secondSection(String[] CustomerData) {
		String stringValue = "<tr> <td colspan=\"5\"  id='Extraborder' class='textAlign_Center'>Right</td><p class='balance_paragraph'></p><td colspan=\"5\" class=\"textAlign_Center\">LEFT</td> </tr>";
		return stringValue;
	}
	
	public String thirdSection(String[] CustomerData) {
		String stringValue = "<tr><td id='Extraborder'></td><td id='Extraborder'>SPH</td><td id='Extraborder'>CYL</td><td id='Extraborder'>AXIX</td><td id='Extraborder'>VN</td><td id='Extraborder'></td><td id='Extraborder'>SPH</td><td id='Extraborder'>CYL</td><td id='Extraborder'>AXIX</td><td>VN</td><td class='balance_paragraph'></td></tr>";
		return stringValue;
	}
	
	public String forthSection(String[] CustomerData) {
		String stringValue = "<tr class='widthFull'><td id='Extraborder'>DV</td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'>DV</td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td></td><td class='balance_paragraph'></td></tr>";
		return stringValue;
	}
	
	public String fifthSection(String[] CustomerData) {
		String stringValue = "<tr class='widthFull'><td id='Extraborder'>NV</td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'>NV</td><td id='Extraborder'></td><td id='Extraborder'></td><td id='Extraborder'></td><td></td><td class='balance_paragraph'></td></tr>";
		return stringValue;
	}
	
	public String sixthSection(String[] CustomerData) {
		String stringValue = " <tr> <td></td> <td>ADD</td> <td colspan=\"3\" class='textAlign_Center'>+2.00</td> <td></td> <td>ADD</td> <td colspan=\"3\" class='textAlign_Center'>+2.00</td> </tr><tr><td></td></tr>";
		return stringValue;
	}
	
	public String sevenSection(String[] CustomerData) {
		String stringValue = "<tr><td id='Extraborder'>Dr.</td><td id='Extraborder' colspan=\"2\">"+CustomerData[26]+"</td><td id='Extraborder'>SD</td><td id='Extraborder' colspan=\"3\"></td><td id='Extraborder'>PD</td><td colspan=\"2\"></td></tr>";
		return stringValue;
	}
	
	public String eigthSection(String[] CustomerData) {
		String stringValue = "<tr><td id='Extraborder'>SN</td><td id='Extraborder'>Frame Type</td><td id='Extraborder'>Lens Price</td><td id='Extraborder'>Frame Price</td><td id='Extraborder'>Paid Ammount</td><td id='Extraborder'>Extra Charges</td><td id='Extraborder'>Total Ammount</td><td>Remark (Extra Notes)</td></tr>";
		return stringValue;
	}
	
	public String repeterBilling(String CustomerData) {
		
		GetPrescriptionData DMI = new GetPrescriptionData();
		String[][] data = DMI.getPrescriptionById(CustomerData);
		
        StringBuilder htmlTable = new StringBuilder();
  	
    	for (int i = 0; i < data.length; i++) {
    		if (data[i] != null) {
    			htmlTable.append("<tr class='repeter_billing_border'>");
    			for (int j = 0; j < data[i].length; j++) {
    				htmlTable.append("<td id='Extraborder'>").append(data[i][j]).append("</td>");
    			}
    			htmlTable.append("</tr>");
    		}
    	}
        

        return htmlTable.toString();
	}
	

	
	public String totalRepeterBilling(String[] CustomerData) {
		String BillingRepeter = "<tr class='repeter_billing_border'> <td id='Extraborder'>GT</td> <td></td> <td></td> <td></td> <td></td> <td id='Extraborder'></td> <td id='Extraborder'>2700</td> <td></td> </tr>";
		return BillingRepeter;
	}
	
	public String lastlatters() {
		String stringValue = "<span>.</span>";
		return stringValue;
	}
	
	public String formateTwo(String[] CustomerData , String customerID) {
		String htmlStrat = this.htmlStrat();
		String header = this.headerPart();
		String footer = this.footerPart();
		String first = this.firstSection(CustomerData);
		String second = this.secondSection(CustomerData);
		String third = this.thirdSection(CustomerData);
		String forth = this.forthSection(CustomerData);
		String fifth = this.fifthSection(CustomerData);
		String sixth = this.sixthSection(CustomerData);
		String seven = this.sevenSection(CustomerData);
		String htmlEnd = this.htmlEnd();
		String nextTableStart = this.nextTableStart();
		String nextTableEnd = this.nextTableEnd();
		String eigth = this.eigthSection(CustomerData);
		String repeterBilling = this.repeterBilling(customerID);
		String totalRepeterBilling = this.totalRepeterBilling(CustomerData);
		String lastlatters = this.lastlatters();
		String stringValue = htmlStrat + header + first + footer  + nextTableStart  + second + third + forth + fifth + sixth + nextTableEnd + nextTableStart + seven + nextTableEnd + nextTableStart + eigth + repeterBilling + totalRepeterBilling + nextTableEnd + lastlatters + htmlEnd;
		return stringValue;
	}
	
}