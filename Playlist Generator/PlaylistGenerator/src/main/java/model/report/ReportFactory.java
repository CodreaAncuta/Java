package model.report;
import javax.swing.JOptionPane;

import model.User;

public class ReportFactory {

	public ReportFactory() {
		
	}
	
	public Report createReport(String type, User u, String absPath) {
		
		Report report = null;
		if(type == null){
	         return null;
	      }		
	      if(type.equalsIgnoreCase("txt")){
	    	  report = new TxtReport();
	         
	      } else if(type.equalsIgnoreCase("pdf")){
	    	  report = new PdfReport();
	         
	      } 
	      assert report != null;
		  if(report.generateReport(u, absPath) == true) 
				JOptionPane.showMessageDialog(null, "The required report has been generated!");
			
	      return report;
	}
}
