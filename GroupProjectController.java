import javafx.scene.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.io.*;
import java.util.Date;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.print.*;
import javax.print.attribute.*;

/**
 *
 * @author Rahul Chowdhary Student id:991658927
 * @author Abhi Sharma Student id:991661414
 */
public class GroupProjectController {

  @FXML
  private RadioButton radioRegular;

  @FXML
  private Text textSubTotal;

  @FXML
  private Text textTax;

  @FXML
  private Text headerText;

  @FXML
  private Text textOne;

  @FXML
  private TextField promptQtyThree;

  @FXML
  private RadioButton radioWhite;

  @FXML
  private RadioButton radioWheat;

  @FXML
  private CheckBox radioButter;

  @FXML
  private Text textTotalSale;

  @FXML
  private ImageView imageCoffee;

  @FXML
  private Label outputLabelOne;

  @FXML
  private RadioButton radioCappuccino;

  @FXML
  private TextField promptQtyTwo;

  @FXML
  private Text textQtyThree;

  @FXML
  private Rectangle rectangleThird;

  @FXML
  private Rectangle rectangleFourth;

  @FXML
  private Text textFour;

  @FXML
  private Rectangle rectangleOne;

  @FXML
  private Button buttonReceiptFile;

  @FXML
  private CheckBox radioBlueberryJam;

  @FXML
  private CheckBox radioCreamCheese;

  @FXML
  private RadioButton radioCafeAU;

  @FXML
  private Button buttonReset;

  @FXML
  private TextField promptQtyOne;

  @FXML
  private Label outputLabelThree;

  @FXML
  private Text textTwo;

  @FXML
  private Text textQtyOne;

  @FXML
  private Label outputLabelTwo;

  @FXML
  private Button buttonExit;

  @FXML
  private Button buttonReceiptPrinter;

  @FXML
  private ToggleGroup bagelGroup;

  @FXML
  private CheckBox radioPeachJelly;

  @FXML
  private Button buttonCalculate;

  @FXML
  private CheckBox radioRaspberryJam;

  @FXML
  private Text textThree;

  @FXML
  private Text textQtyTwo;

  @FXML
  private RadioButton radioNone;

  @FXML
  private Rectangle rectangleTwo;


    public void ffffffee() {}

    /**
     * method buttonCalculateListener displayes the calculted values of the subtotal,tax and total on outputLabels set in the scene builder
     */
    public void buttonCalculateListener() {
    Double subTotal = getSubTotal();//declaring variable subTotal
    Double tax = getTax(subTotal);//declaring variable tax
    Double total = subTotal + tax;//declaring variable total
    outputLabelOne.setText("$" + String.valueOf(subTotal));
    outputLabelTwo.setText("$" + String.valueOf(tax));
    outputLabelThree.setText("$" + String.valueOf(total));
  }

    /**
     *
     * @return subTotal gets the subtotal
     */
    public Double getSubTotal() {
    return getBagel() + getCoffee() + getToppings();
  }

    /**
     *
     * @param total
     * @return tax gets the tax
     */
    public Double getTax(Double total) {
    return 0.13 * total;
  }

    /**
     *method ResetBagel resets the bagels items to default
     */
    public void resetBagel() {
    radioWhite.setSelected(false);
    radioWheat.setSelected(false);
    promptQtyTwo.setText("");//set text to null
    promptQtyThree.setText("");//set text to null
  }

    /**
     *method ResetCoffee resets the Coffee items to default
     */
    public void ResetCoffee() {
    radioNone.setSelected(false);
    radioRegular.setSelected(false);
    radioCappuccino.setSelected(false);
    radioCafeAU.setSelected(false);
  }

    /**
     *method ResetToppings resets the Toppings items to default
     */
    public void resetToppings() {
    radioCreamCheese.setSelected(false);
    radioBlueberryJam.setSelected(false);
    radioRaspberryJam.setSelected(false);
    radioButter.setSelected(false);
    radioPeachJelly.setSelected(false);
  }

    /**
    *method ResetCost resets the labels input values to 0
     */
    public void resetCost() {
    outputLabelOne.setText("$0.00");
    outputLabelTwo.setText("$0.00");
    outputLabelThree.setText("$0.00");
  }

  @FXML
  void buttonResetListener(ActionEvent event) {
    resetBagel();
    ResetCoffee();
    resetToppings();
    resetCost();
  }

    /**
     *method buttonExitListener exits through the system
     */
    public void buttonExitListener() {
    System.exit(0);
  }
java.util.Date date=new java.util.Date();  //creating date variable according to system date .

    /**
     *
     * @param event
     * @throws FileNotFoundException
     *Using if else loop to printReceiptFile and show it on receipt.txt file
     */
    @FXML
   public void buttonReceiptFileListener(ActionEvent event) throws FileNotFoundException{
	  try{
		  System.out.println("SUCCESS! Your file is Printed !");
		  PrintWriter outStream = new PrintWriter("receiptt.txt");
		  outStream.println("********WELCOME TO SHERIDAN BAGEL SHOP******** \n");
		  outStream.println(date.toString());
		  outStream.println("Item Name: \t\tQuantity\tAmount \n");
		  if(radioWhite.isSelected()){
			  outStream.print("White Bagel\t\t");
			  outStream.print(promptQtyTwo.getText()+"\t");
			  outStream.println("\t"+"$"+1.50*Double.valueOf(promptQtyTwo.getText()));

		  }
		  //using if else loop to print the calculated values on receipt.txt file

		  if(radioWheat.isSelected()){
		  			  outStream.print("Whole Wheat Bagel\t");
		  			  outStream.print(promptQtyTwo.getText()+"\t\t");
		  			  outStream.println("$"+1.75*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioCreamCheese.isSelected()){
		  		  			  outStream.print("Cream Cheese\t\t");
		  		  			  outStream.print(promptQtyTwo.getText()+"\t");
		  		  			  outStream.println("\t"+"$"+0.50*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioButter.isSelected()){
		  		  		  			  outStream.print("Butter\t\t\t");
		  		  		  			  outStream.print(promptQtyTwo.getText()+"\t");
		  		  		  			  outStream.println("\t"+"$"+0.25*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioBlueberryJam.isSelected()){
		  		  		  		  			  outStream.print("Blueberry Jam\t\t");
		  		  		  		  			  outStream.print(promptQtyTwo.getText()+"\t");
		  		  		  		  			  outStream.println("\t"+"$"+0.75*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioRaspberryJam.isSelected()){
		  		  		  		  		  			  outStream.print("Raspberry Jam\t\t");
		  		  		  		  		  			  outStream.print(promptQtyTwo.getText()+"\t");
		  		  		  		  		  			  outStream.println("\t"+"$"+0.75*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioPeachJelly.isSelected()){
		  		  		  		  		  		  			  outStream.print("Peach Jelly\t\t");
		  		  		  		  		  		  			  outStream.print(promptQtyTwo.getText()+"\t");
		  		  		  		  		  		  			  outStream.println("\t"+"$"+0.75*Double.valueOf(promptQtyTwo.getText()));
		  }

		  if(radioRegular.isSelected()){
		  		  		  		  		  		  		  			  outStream.print("Regular Coffee\t\t");
		  		  		  		  		  		  		  			  outStream.print(promptQtyThree.getText()+"\t");
		  		  		  		  		  		  		  			  outStream.println("\t"+"$"+1.25*Double.valueOf(promptQtyThree.getText()));
		  		  }

		  		  if(radioCappuccino.isSelected()){
				  		  		  		  		  		  		  		  			  outStream.print("Cappuccino Coffee\t");
				  		  		  		  		  		  		  		  			  outStream.print(promptQtyThree.getText()+"\t");
				  		  		  		  		  		  		  		  			  outStream.println("\t"+"$"+2.00*Double.valueOf(promptQtyThree.getText()));
		  		  }

		  		  if(radioCafeAU.isSelected()){
				  				  		  		  		  		  		  		  		  			  outStream.print("Cafe AU Lait\t\t");
				  				  		  		  		  		  		  		  		  			  outStream.print(promptQtyThree.getText()+"\t");
				  				  		  		  		  		  		  		  		  			  outStream.println("\t"+"$"+1.75*Double.valueOf(promptQtyThree.getText()));
		  		  }

		  		  outStream.println("\t\t\t\t---------------");
		  		  outStream.println("SubTotal\t\t\t\t"+outputLabelOne.getText());
		  		  outStream.println("TAX\t\t\t\t\t"+outputLabelTwo.getText());
                  outStream.println("Total Sales\t\t\t"+outputLabelThree.getText()+"\n");
                  outStream.println("*******************THANK YOU*******************");
                  outStream.close();

                //  it sets the stage

                  Stage stage2 = (Stage) buttonReceiptFile.getScene().getWindow();
                  stage2.close();
                  Stage stage = new Stage();
                  Parent order = FXMLLoader.load(getClass().getResource("textarea.fxml"));

                  Scene order1=new Scene(order);

                  order1.getStylesheets().add(getClass().getResource("layout.css").toExternalForm());//it links to layout.css
                  stage.setScene(order1);
                  stage.show();

	  }

	  catch(Exception localException){
		  System.out.println("Error Printing to File");
	  }
  }

    /**
     *
     */
    public void ee0000() {}

    /**
     *buttonReceiptListener sets the printWriter
     */
    public void buttonReceiptPrinterListener() {
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


    public void ff0c0c() {}

    /**
     *
     * @return Bagel get the Bagel
     *using ternary operators to return prices of the item selected in getBagel method
     */
    public Double getBagel() {
    Double quantity = Double.valueOf(promptQtyTwo.getText());
    Double whitePrice = radioWhite.isSelected() ? 1.50 : 0;
    Double wheatPrice = radioWheat.isSelected() ? 1.75 : 0;
    return quantity * (whitePrice + wheatPrice);
  }

    /**
     *
     * @return Coffee get the Coffee
     *using ternary operators to return prices of the item selected in getCoffee method
     */
    public Double getCoffee() {
    Double quantity = !promptQtyThree.getText().isEmpty() ? Double.valueOf(promptQtyThree.getText()) : 0;
    Double nonePrice = radioNone.isSelected() ? 0.00 : 0;
    Double regularPrice = radioRegular.isSelected() ? 1.25 : 0;
    Double cappuccinoPrice = radioCappuccino.isSelected() ? 2.00 : 0;
    Double cafePrice = radioCafeAU.isSelected() ? 1.75 : 0;
    return quantity * (nonePrice+regularPrice+cappuccinoPrice+cafePrice);
  }

    /**
     *
     * @return Toppings get the Toppings
     *using ternary operators to return prices of the item selected in getToppings method
     */
    public Double getToppings() {
    Double cheesePrice = radioCreamCheese.isSelected() ? 0.50 : 0;
    Double butterPrice = radioButter.isSelected() ? 0.25 : 0;
    Double bjamPrice = radioBlueberryJam.isSelected() ? 0.75 : 0;
    Double rjamPrice = radioRaspberryJam.isSelected() ? 0.75 : 0;
    Double jellyPrice = radioPeachJelly.isSelected() ? 0.75 : 0;
     return cheesePrice+butterPrice+bjamPrice+rjamPrice+jellyPrice;
}
}