package rocks.zipcode.atm;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();
        areaInfo.setEditable(false);

        Button btnSubmit = new Button("Set Account ID");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        vbox.getChildren().add(new Text("Test"));
        return vbox;
    }

    private Parent createContentGrid(){
        GridPane grid = new GridPane();
        grid.setPrefSize(400,600);
     //   grid.setGridLinesVisible(true);
     //   grid.setHgap(20);
     //   grid.setVgap(20);

        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField mailField = new TextField();
        TextField balanceField = new TextField();
        TextField amountField = new TextField();

        TextArea areaInfo = new TextArea();
        areaInfo.setEditable(false);

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnLogout = new Button("Logout");
        btnLogout.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });


        grid.add(new Text("ID:"),       0,0);
        grid.add(idField,               1,0,3,1);
        grid.add(btnLogin,              1,1);
        grid.add(btnLogout,             2,1);
        grid.add(new Text("Name:"),     0,2);
        grid.add(nameField,             1,2,3,1);
        grid.add(new Text("Email:"),    0,3);
        grid.add(mailField,             1,3,3,1);
        grid.add(new Text("Balance:"),  0,4,1,1);
        grid.add(balanceField,          1,4,3,1);
        grid.add(new Text("OverDraft"), 1,5,3,1);
        grid.add(new Text("Amount:"),   0,6);
        grid.add(amountField,           1,6,3,1);
        grid.add(new Text("Error"),     1,7,3,1);
        grid.add(btnDeposit,            1,8);
        grid.add(btnWithdraw,           2,8);

        return grid;
    }
    @Override
    public void start(Stage stage) throws Exception {
//        stage.setScene(new Scene(createContent()));
        stage.setScene(new Scene(createContentGrid()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
