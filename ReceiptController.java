import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Rahul Chowdhary Student id:991658927
 * @author Abhi Sharma Student id:991661414
 */
public class ReceiptController {

    @FXML
    private TextArea bill;

    @FXML
    private Button buttonReceiptFile;

    @FXML
    private Button buttonReceiptPrinter;

    @FXML
    private Button buttonExit;


    @FXML
    void buttonExitListener(ActionEvent event) {
		System.exit(0);

    }

    @FXML
    void buttonReceiptFileListener(ActionEvent event)throws FileNotFoundException  {



		        //creating File instance to reference text file in Java
		        File text = new File("receiptt.txt");

		        //Creating Scanner instance to read File in Java
		        Scanner scnr = new Scanner(text);

		        //Reading each line of the file using Scanner class
		        while(scnr.hasNextLine()){
		            String line = scnr.nextLine();
		            bill.appendText( line + "\n" );

				}

		    }

/**
*method buttonReceiptPrinterListener sets the printReceipt file additional file
*
*/
    @FXML
    void buttonReceiptPrinterListener(ActionEvent event) {
		      PrintRequestAttributeSet pras =     new HashPrintRequestAttributeSet();
		      DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		                PrintService ps[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		               PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		              PrintService service = ServiceUI.printDialog(null, 200, 200, ps, defaultService, flavor, pras);
		                if (service != null) {
		                   try {
		                         DocPrintJob job = service.createPrintJob();
		                          DocAttributeSet das = new HashDocAttributeSet();
		                          FileInputStream fis = new FileInputStream("TestPrinter.java");
		                         Doc doc = new SimpleDoc(fis, flavor, das);
		                        try {
		                                job.print(doc, pras);
		        System.out.println("Job sent to printer.");
		        //fis.close();
		                          } catch (PrintException e) {
		                                System.out.println("Print error!" + e.getMessage());
		                          }
		       //fis.close();
		                    } catch (FileNotFoundException e) {
		                          System.out.println("File not found!" + e.getMessage());
		                  }

		    }

    }

}
