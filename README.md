## Capstone Two Delicious

## Purpose:
This project is the point of sales application for DELI-cious, a custom sandwich shop. 
This CLI version of POS will do the basic automation of the sandwich shop allowing customizing sandwiches and orders.


## Planning chart:
The project code will follow the outline attached below:

| External Files and Folders                                | Class to Run POS | POS for operation | Menu for prices and details                                                    | GUI                |
|-----------------------------------------------------------|------------------|-------------------|--------------------------------------------------------------------------------|--------------------|
| README.MD                                                 | Main.java        | POS.java          | Order.java                                                                     | WelcomeWindow.java |
| receipts folder (containing order receipts as .txt files) |                  | POSInterface.java | Drink.java <br/>chips.java<br/>sandwich.java                                   |                    |
|                                                           |                  |                   | SignatureSandwich.java<br/>BLTSandwich.java<br/>PhillyCheeseSteakSandwich.java |                    |                  |                   |                                                                                |                    |                                                           |                  |                   |                                                                                |                    |

## Understanding Class Function:
Main.java: Main class to call methods. <br/>
POS.java: contains methods for operation for POS. POS implements POSInterface. <br/>
POSInterface.java: Interface for uniform actions on POS. <br/>
Order.java: contains variables, constructor, calculate price method and to string for order. <br/>
Drink.java: contains variables, constructor, calculate price method and to string for drink. <br/>
chips.java: contains variables, constructor, calculate price method and to string for chips. <br/>
sandwich.java: contains variables, constructor, calculate price method and to string for sanwiches. <br/>
SignatureSandwich.java: contains common details of signature sandwiches. <br/>
BLTSandwich.java: contains details of BLT sandwich. <br/>
PhillyCheeseSteakSandwich.java: contains details of Philly CheeseSteak Sandwich. <br/>
WelcomeWindow.java: contains GUI method to display logo in welcome window. <br/>
Readme.md: Contains project details.<br/>
Receipts: Folder for storing receipts

## Code Snippets:

### Main.java:
