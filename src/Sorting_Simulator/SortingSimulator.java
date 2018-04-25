/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Simulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static Sorting_Simulator.GUI.alert;


/**
 * @author Aashish Bharadwaj
 */
public class SortingSimulator extends Application{

	public static boolean banned = false;
	public static boolean getTriggered = false;
//	public static boolean randomExplained = false;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args){
		Application.launch(args);
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
	public void start(Stage primaryStage){
		if(Screen.getPrimary().getVisualBounds().getHeight() < 720){
			alert("Low Resolution Warning", "Your screen resolution is low.",
			      "Some items may\n" + "not display correctly.", "WARNING", true);
		}

		GUI.createUI();

		primaryStage.setScene(new Scene(GUI.elements, 837, 573));

		primaryStage.setMinWidth(837);
		primaryStage.setMinHeight(573);

		primaryStage.setOnCloseRequest(close->System.exit(0));

		primaryStage.show();
	}

}
