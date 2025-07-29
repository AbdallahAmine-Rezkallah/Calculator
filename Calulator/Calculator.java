import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Calculator {
    public JPanel panel = new JPanel();
    public JLabel displayLabel = new JLabel();
  JFrame fram = new JFrame("Calculator");
  int bordWidth = 370;
  int hightWidth = 500;
  Color customBlack =new Color(28   , 28, 28);
  Color customDarkGrey = new Color(80, 80, 80);
  Color lightGrey = new Color(212, 212, 210);
  Color customOrange = new Color(255, 149, 0);
  JPanel buttonPanel = new JPanel();
  Color customLightGrey = new Color(212, 212, 210);
  String A="0";
    String operator =null;
    String B=null;

  String[] buttonValues = {
     "AC","+/-","%" ,"+",
     "7","8", "9", "-",
     "4" ,"5", "6","×",
     "1" ,"2", "3", "÷",
   "0","√", ".", "="
  
    };
String [] rightSymbols={"+","-","×","÷","="};
String [] topSymbol={"AC","+/-","%"};

 public Calculator() {
    
    fram.setSize(bordWidth, hightWidth );
    fram.setLocationRelativeTo(null);
    fram.setResizable(false);
    fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fram.setLayout(new BorderLayout());
   

   displayLabel.setBackground(customBlack);

displayLabel.setOpaque(true);                
displayLabel.setForeground(Color.white);     
displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
displayLabel.setHorizontalAlignment(JLabel.RIGHT);
displayLabel.setText("0"); 
displayLabel.setOpaque(true);
panel.setLayout(new BorderLayout());
panel.add(displayLabel);
fram.add(panel, BorderLayout.NORTH);

    Border border = BorderFactory.createLineBorder(customDarkGrey, 2);
    panel.setBorder(border);

    displayLabel.setBorder(border);
   panel.setBackground(customBlack);
    displayLabel.setForeground(Color.white);

    fram.getContentPane().setBackground(Color.white);
    fram.setVisible(true);
    buttonPanel.setBackground(customDarkGrey);
    fram.add(buttonPanel, BorderLayout.CENTER);
    buttonPanel.setLayout(new GridLayout(5, 4));
    buttonPanel.setBackground(customBlack);
    
    for(int i= 0;i<buttonValues.length;i++){
       JButton button= new JButton();
       String buttonvalues = buttonValues[i];
       button.setFont(new Font("Arial", Font.PLAIN, 30));
       button.setText(buttonvalues);
        button.setBorder(new LineBorder(customBlack)) ;
       button.setFocusable(false);
       if(Arrays.asList(topSymbol).contains(buttonvalues)){
           button.setBackground(customLightGrey);
           button.setForeground(customBlack);
    }
   else if (Arrays.asList(rightSymbols).contains(buttonvalues)){
           button.setBackground(customOrange);
           button.setForeground(Color.white);
    
    }
    else{
        button.setBackground(customDarkGrey);
        button.setForeground(Color.white);

    }

   buttonPanel.add(button);
   button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        String buttonValues = button.getText();
        if(Arrays.asList(topSymbol).contains(buttonValues)){
          if(buttonValues=="AC"){
             clearAll();
             displayLabel.setText("0");
          }
          else if(buttonValues=="+/-"){
         double numdisplay = Double.parseDouble(displayLabel.getText());
         numdisplay *= -1;
         displayLabel.setText(removeZeroDecimal(numdisplay) );


        
          }
          else if(buttonValues=="%"){
                double numdisplay = Double.parseDouble(displayLabel.getText());
         numdisplay /=100;
         displayLabel.setText(removeZeroDecimal(numdisplay) ); 
          }
          
        }
        else if (Arrays.asList(rightSymbols).contains(buttonValues)){
          if(buttonValues=="="){
            if(A!=null){
                B=displayLabel.getText();
                double numA = Double.parseDouble(A);
                double numB = Double.parseDouble(B);    
              if(operator=="+"){
            
               displayLabel.setText(removeZeroDecimal(numA + numB));
              }
             
                else if(operator=="-"){
                    displayLabel.setText(removeZeroDecimal(numA - numB));
                }
                else if(operator=="×"){
                    displayLabel.setText(removeZeroDecimal(numA * numB));
                }
                else if(operator=="÷"){
                    if(numB==0){
                        displayLabel.setText("Error");
                    }
                    else{
                        displayLabel.setText(removeZeroDecimal(numA / numB));
                    }
              }
            }
          
        }
        else if("+-÷×".contains(buttonValues)) {
          if(operator==null){
            A =displayLabel.getText();
            displayLabel.setText("0");
            B="0";

          }
          operator=buttonValues;

        }
    }
        else{
            if(buttonValues=="."){
             if(!displayLabel.getText().contains(buttonValues)){
               displayLabel.setText(displayLabel.getText()+ buttonValues);
             }
            }
            else if ("0123456789".contains(buttonValues)){
             if(displayLabel.getText()=="0"){
             displayLabel.setText(buttonValues);
             }
             else{
                displayLabel.setText(displayLabel.getText()+ buttonValues);
             }
            }
        }
        }

   });
   fram.setVisible(true);
  }

}
void clearAll(){
    A="0";
    operator = null;
    B = null;
 
}
String removeZeroDecimal( double numdisplay){
  if(numdisplay % 1 == 0) {
    return String.valueOf((int) numdisplay);
  } 
  return Double.toString(numdisplay);
   
 }

  }