## Capstone Two Delicious

## Purpose:
This project is the point of sales application for DELI-cious, a custom sandwich shop. 
This CLI version of POS will do the basic automation of the sandwich shop allowing customizing sandwiches and orders.

## Demo Class Diagram:
![ClassDiagram.png](ClassDiagram.png)

## Planning chart:
The project code will follow the outline attached below:

| External Files and Folders                                | Class to Run POS | POS for operation | Menu for prices and details                                                    | GUI                |
|-----------------------------------------------------------|------------------|-------------------|--------------------------------------------------------------------------------|--------------------|
| README.MD                                                 | Main.java        | POS.java          | Order.java                                                                     | WelcomeWindow.java |
| receipts folder (containing order receipts as .txt files) |                  | POSInterface.java | Drink.java <br/>Chips.java<br/>Sandwich.java                                   |                    |
|                                                           |                  |                   | SignatureSandwich.java<br/>BLTSandwich.java<br/>PhillyCheeseSteakSandwich.java |                    |

## Project Chart:
![ProjectStructure.png](ProjectStructure.png)

## Understanding Class Functions:
Main.java: Main class to call methods. <br/>
POS.java: contains methods for operation for POS. POS implements POSInterface. <br/>
POSInterface.java: Interface for uniform actions on POS. <br/>
Order.java: contains variables, constructor, calculate price method and to string for order. <br/>
Drink.java: contains variables, constructor, calculate price method and to string for drink. <br/>
Chips.java: contains variables, constructor, calculate price method and to string for chips. <br/>
Sandwich.java: contains variables, constructor, calculate price method and to string for sanwiches. <br/>
SignatureSandwich.java: contains common details of signature sandwiches. <br/>
BLTSandwich.java: contains details of BLT sandwich. <br/>
PhillyCheeseSteakSandwich.java: contains details of Philly CheeseSteak Sandwich. <br/>
WelcomeWindow.java: contains GUI method to display logo in welcome window. <br/>
Readme.md: Contains project details.<br/>
Receipts: Folder for storing receipts

## Code Snippets:

### Main.java:
![Main.png](Main.png)
### POS.java:
![POSOne.png](POSOne.png)
![POSTWO.png](POSTWO.png)
![POSThree.png](POSThree.png)
![POSFour.png](POSFour.png)
![POSFive.png](POSFive.png)
![POSSix.png](POSSix.png)
![POSSeven.png](POSSeven.png)

### POSInterface.java: 
![POSInterface.png](POSInterface.png)

### Order.java: 
![Order.png](Order.png)

### Drink.java: 
![Drink.png](Drink.png)

### Chips.java: 
![Chip.png](Chip.png)

### Sandwich.java: 
![SandwichOne.png](SandwichOne.png)
![SandwichTwo.png](SandwichTwo.png)

### SignatureSandwich.java: 
![SignatureSandwich.png](SignatureSandwich.png)

### BLTSandwich.java: 
![BLTSandwich.png](BLTSandwich.png)

### PhillyCheeseSteakSandwich.java: 
![PhillyCheeseSteak.png](PhillyCheeseSteak.png)

### WelcomeWindow.java:
![WelcomeWindow.png](WelcomeWindow.png)

### Receipts: 
![Receipts.png](Receipts.png)

## Sample Input and Output:
![OutputOne.png](OutputOne.png)
![OutputTwo.png](OutputTwo.png)
![OutputThree.png](OutputThree.png)


### Error/Invalid Choice Snippet:
Any error or choice outside of case shows Invalid Choice.
![Error.png](Error.png)

### Interesting Piece of Code:
![IntCode.png](IntCode.png)
![IntCodeTwo.png](IntCodeTwo.png)

### Limitations:
1. Invalid Inputs of adding another sandwich, drink and chips should be shown as error.
2. Signature Sandwiches should be able to be customized.

### Future Upgrade:
1. Memory Optimization.
2. Better looking GUI for customers.
3. Customer Profile.
4. Order history by profile.
5. Quick order.

Project done by JARIN MAHMUD.

### ***End of Readme***