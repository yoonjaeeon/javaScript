package com.yedam.network;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {

	// startClient()

	// stopClient()

	// receive()

	// send()

	// start() => UI 만드는 메소드.
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(event->{
			if (btnConn.getText().equals("start")) {
				// startClient();
			}else if(btnConn.getText().equals("stop")) {
				// // stopClient()
			}
		});
		btnSend=new Button("send");
		
	}
}
