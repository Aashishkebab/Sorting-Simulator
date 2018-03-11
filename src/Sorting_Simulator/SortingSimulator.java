/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Simulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Scanner;


/**
 * @author Aashish Bharadwaj
 */
public class SortingSimulator extends Application{

	public static boolean banned = false;
	public static boolean randomExplained = false;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args){
		Application.launch(args);
	}

	public static void pause(){
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
	}

	public static void alert(String title, String header, String content, String alertType,
	                         boolean wait){
		Alert alert;
		switch(alertType){
			case "INFORMATION":
				alert = new Alert(Alert.AlertType.INFORMATION);
				break;
			case "WARNING":
				alert = new Alert(Alert.AlertType.WARNING);
				break;
			default:
				return;
		}

		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		Toolkit.getDefaultToolkit().beep();

		alert.setResizable(false);

		if(wait){
			alert.showAndWait();
		}else{
			alert.show();
		}
	}

	/**
	 * Truncates string to specified length, and then adds three periods to denote truncation
	 *
	 * @param string The string to be truncated
	 * @param length How many maximum characters the string should be allowed to contain
	 * @return Returns the truncated string
	 */
	public static String truncate(String string, int length){
		if(string.length() >
				(length + 1)){ //If the string needs to be truncated because it is too long
			string = string.substring(0, length) +
					"...";   //Shorten the string to specified length, then add three dots at the end
		}
		return string;
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		GUI.createUI();

		primaryStage.setScene(new Scene(GUI.elements, 777, 537));

		primaryStage.setMinWidth(777);
		primaryStage.setMinHeight(537);

		primaryStage.show();
	}

}
