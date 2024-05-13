// Team members: Ashley Wu and Andrew Blair
// Course number: CSC 210
// Course section: 0900
// Description: This is the GroceryApp FX that displays the login and
// menu windows using the GroceryStore class.
// Date: 05/15/2024
// Version: Last version

package org.example.chapter12;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class GroceryApp extends Application {
    // Fields
    private TextField userTextField;
    private TextField passwordTextField;
    private Label messageLabel;
    private TextField productNumTextField;
    private TextField quantityTextField;
    private Label resultLabel;
    private Stage primaryStage;

    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // assign primaryStage to class field
        this.primaryStage = primaryStage;

        // Create a Labels to display username and password.
        Label promptLabel1 = new Label("Username: ");
        Label promptLabel2 = new Label("Password: ");

        // Create a TextFields for input of username and password.
        userTextField = new TextField();
        passwordTextField = new TextField();

        // Create a Button to perform the Login.
        Button LoginButton = new Button("Login");

        // Register the event handler.
        LoginButton.setOnAction(new LoginButtonHandler());

        // Create an empty Label to display the message.
        messageLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.add(promptLabel1, 0, 0);
        gridPane.add(promptLabel2, 0, 1);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passwordTextField, 1, 1);
        gridPane.add(LoginButton, 1, 2);
        gridPane.add(messageLabel, 0, 3);

        // Create a Scene.
        Scene scene = new Scene(gridPane);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Login");

        // Show the window.
        primaryStage.show();
    }

    // Event handler class for LoginButton
    class LoginButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            // call Login method
            login();
        }
    }

    // method handles Login
    private void login() {

        // setting userTextField
        String user = userTextField.getText();
        // setting passwordTextField
        String password = passwordTextField.getText();

        // if user and password are the same as the ones in the GroceryStore class
        if (user.equals(GroceryStore.getUsername()) && password.equals(GroceryStore.getPassword())) {
            messageLabel.setText("Login successful"); // will display this if user login

            // call the menu method
            menu();

        } else {
            messageLabel.setText("Login failed. Please try again."); // else display try again
        }
    }

    // method handles Menu
    private void menu() {

        // Create a Labels to display products and their cost, and number.
        Label prompt1 = new Label("Products");
        Label prompt2 = new Label("Cost");
        Label num1 = new Label("                                               1");
        Label num2 = new Label("                                               2");
        Label num3 = new Label("                                               3");
        Label num4 = new Label("                                               4");
        Label product1 = new Label("Tuna");
        Label product2 = new Label("Milk");
        Label product3 = new Label("Bread");
        Label product4 = new Label("Juice");
        Label cost1 = new Label("2.60");
        Label cost2 = new Label("10.00");
        Label cost3 = new Label("5.80");
        Label cost4 = new Label("3.40");
        Label prompt3 = new Label("Enter the number for the product ");
        Label prompt4 = new Label("Enter the quantity for the product ");

        // Create a TextFields for input of product number and quantity.
        productNumTextField = new TextField();
        quantityTextField = new TextField();

        // Create a Button to perform the Calculation.
        Button calculateButton = new Button("Calculate");

        // Register the event handler.
        calculateButton.setOnAction(new calcButtonHandler());

        // Create an empty Label to display the result of the calculation.
        resultLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.add(prompt1, 1, 0);
        gridPane.add(prompt2, 2, 0);
        gridPane.add(num1, 0, 1);
        gridPane.add(num2, 0, 2);
        gridPane.add(num3, 0, 3);
        gridPane.add(num4, 0, 4);
        gridPane.add(product1, 1, 1);
        gridPane.add(product2, 1, 2);
        gridPane.add(product3, 1, 3);
        gridPane.add(product4, 1, 4);
        gridPane.add(cost1, 2, 1);
        gridPane.add(cost2, 2, 2);
        gridPane.add(cost3, 2, 3);
        gridPane.add(cost4, 2, 4);
        gridPane.add(prompt3, 0, 5);
        gridPane.add(prompt4, 0, 6);
        gridPane.add(productNumTextField, 1, 5);
        gridPane.add(quantityTextField, 1, 6);
        gridPane.add(calculateButton, 1, 7);
        gridPane.add(resultLabel, 1, 8);

        // Create a Scene.
        Scene scene2 = new Scene(gridPane);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene2);

        // Set the stage title.
        primaryStage.setTitle("Menu");

        // Show the window.
        primaryStage.show();
    }

    // Event handler class for calculateButton
    class calcButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            // try exception from Ch.11 -- handles exceptions for productNum and quantity
            try // try block statement
            {
                // Accept the product number and the quantity.
                double productNum = Double.parseDouble(productNumTextField.getText());
                double quantity = Double.parseDouble(quantityTextField.getText());

                // if statement that display invalid if prod. number is not between 1 or 4
                if (productNum < 1 || productNum > 4) {
                    resultLabel.setText("Invalid product number. Please try again.");
                    return;
                }
                // if statement that display invalid if quantity is zero or negative values
                else if (quantity <= 0) {
                    resultLabel.setText("Invalid quantity number. Please try again.");
                    return;
                }

                // Create variable and if condition for each product number
                String item = "";
                if (productNum == 1) {
                    item = "Tuna";
                } else if (productNum == 2) {
                    item = "Milk";
                } else if (productNum == 3) {
                    item = "Bread";
                } else if (productNum == 4) {
                    item = "Juice";
                }

                // Calculate cost, taxes, and total calling the GroceryStore class.
                double cost = GroceryStore.calCost(item) * quantity;
                double taxes = GroceryStore.calTaxes(item) * quantity;
                double total = GroceryStore.calTotal(item) * quantity;

                // Display the results.
                resultLabel.setText(String.format("\nCost before taxes: " + (cost) +
                        "\nTaxes: " + (taxes) + "\nTotal Cost: " + (total)));
            }

            // if the user input a word or character will display invalid
            catch (NumberFormatException e) // catch block statement
            {
                resultLabel.setText("Invalid input. Please try again with numbers.");
            }
        }
    }
}