/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Simulator;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import sorting_algorithms.Sort;

import java.awt.*;

import static Sorting_Simulator.SortingSimulator.banned;
import static Sorting_Simulator.SortingSimulator.getTriggered;


/**
 * @author Aashish Bharadwaj
 */
public class GUI{

	public static final Button goButton = new Button("Go");
	static final HBox elements = new HBox(0);
	static final HBox leftCushion = new HBox();
	static final VBox topCushion = new VBox();
	static final VBox mainInterface = new VBox(37);
	static final HBox algorithmBox = new HBox(55);
	static final VBox iteratives = new VBox(7);
	static final Label iterativeLabel = new Label("Iterative Algorithms");
	static final VBox recursives = new VBox(7);
	static final Label recursiveLabel = new Label("Recursive Algorithms");
	static final VBox mathematicals = new VBox(7);
	static final Label mathematicalLabel = new Label("Mathematical (non-comparitive) Algorithms");
	static final VBox garbages = new VBox(7);
	static final Label garbageLabel = new Label("Garbage Algorithms");
	static final ToggleGroup algorithms = new ToggleGroup();
	static final RadioButton slowSort = new RadioButton("Slow Sort");
	static final RadioButton cycleSort = new RadioButton("Cycle Sort");
	static final RadioButton stoogeSort = new RadioButton("Stooge Sort");
	static final RadioButton selectionSort = new RadioButton("Selection Sort");
	static final RadioButton heapSort = new RadioButton("Heap Sort");
	static final RadioButton bubbleSort = new RadioButton("Bubble Sort");
	static final RadioButton cocktailSort = new RadioButton("Cocktail Sort");
	static final RadioButton oddEvenSort = new RadioButton("Odd-Even Sort");
	static final RadioButton combSort = new RadioButton("Comb Sort");
	static final RadioButton insertionSort = new RadioButton("Insertion Sort");
	static final RadioButton shellSort = new RadioButton("Shell Sort");
	static final RadioButton quickSort = new RadioButton("Quick Sort");
	static final RadioButton mergeSort = new RadioButton("Merge Sort");
	//	static RadioButton timSort = new RadioButton("Tim Sort");
	static final RadioButton javaSort = new RadioButton("Java default sort");
	static final RadioButton bogoSort = new RadioButton("Bogo Sort");
	static final RadioButton trumpSort = new RadioButton("Trump Sort");
	static final RadioButton bernieSort = new RadioButton("Bernie Sort");
	static final RadioButton hillarySort = new RadioButton("Hillary Sort");
	static final RadioButton gravitySort = new RadioButton("Gravity/Bead Sort");
	static final RadioButton radixSort = new RadioButton("Radix Sort");
	static final RadioButton countingSort = new RadioButton("Counting Sort");
	//	static final RadioButton countingSortBad = new RadioButton("Crappy Counting Sort");
	static final RadioButton pigeonSort = new RadioButton("Pigeonhole Sort");
	static final RadioButton aashishSort1 = new RadioButton("Aashish Sort 1");
	static final RadioButton aashishSort2 = new RadioButton("Aashish Sort 2");
	static final RadioButton aashishSort5 = new RadioButton("Aashish Sort 5");
	static final RadioButton pancakeSort = new RadioButton("Pancake Sort");
	static final RadioButton intelligentDesignSort = new RadioButton("Intelligent Design Sort");
	static final RadioButton flashSort = new RadioButton("Flash Sort");
	static final RadioButton dropSort = new RadioButton("Drop Sort");

	static final VBox typeBox = new VBox(9);
	static final Label typeTitle = new Label("Input Type");
	static final ToggleGroup types = new ToggleGroup();

	static final RadioButton alreadySorted = new RadioButton("Already sorted");
	static final RadioButton reverseOrder = new RadioButton("Reverse order");
	static final RadioButton randomOrder = new RadioButton("Random");

	static final HBox bottomItems = new HBox(44);
	static final HBox sizeBox = new HBox(23);

//	static HBox inputSizeBox = new HBox(13);


	static final VBox sizeLabels = new VBox(17);
	static final Label inputSizeTitle = new Label("Input Size");
	static final Label minInputSizeTitle = new Label("Smallest Number");
	static final Label maxInputSizeTitle = new Label("Largest Number");
	static final Label blockSizeTitle = new Label("Block Size");
	static final VBox sizeFields = new VBox(7);
	static final TextField inputSize = new TextField("0");
	static final TextField minInputSize = new TextField("0");
	static final TextField maxInputSize = new TextField("0");

//	static HBox maxInputSizeBox = new HBox(13);


	//	static HBox blockSizeBox = new HBox(13);
	static final TextField blockSize = new TextField("0");
	static final HBox printConsoleBox = new HBox(7);
	static final Label printConsoleLabel = new Label("Display array");
	static final CheckBox printConsole = new CheckBox();
	static final Label offendLabel = new Label("Display potentially offensive content");
	static final CheckBox offend = new CheckBox();

	public static void createUI(){
		addElementsToInterface();
		setElementAssociations();
		setElementActions();
	}

	private static void addElementsToInterface(){
		elements.getChildren().add(leftCushion);

		elements.getChildren().add(mainInterface);
//		mainInterface.getChildren().add(algorithmTitle);

		mainInterface.getChildren().add(topCushion);
		mainInterface.getChildren().add(algorithmBox);


		algorithmBox.getChildren().add(iteratives);
		iteratives.getChildren().add(iterativeLabel);

		iteratives.getChildren().add(cycleSort);
		iteratives.getChildren().add(selectionSort);
		iteratives.getChildren().add(bubbleSort);
		iteratives.getChildren().add(cocktailSort);
		iteratives.getChildren().add(oddEvenSort);
		iteratives.getChildren().add(combSort);
		iteratives.getChildren().add(insertionSort);
		iteratives.getChildren().add(shellSort);
		iteratives.getChildren().add(aashishSort5);
		iteratives.getChildren().add(pancakeSort);
		iteratives.getChildren().add(aashishSort2);


		algorithmBox.getChildren().add(recursives);
		recursives.getChildren().add(recursiveLabel);
//		recursives.getChildren().add(timSort);
		recursives.getChildren().add(javaSort);
		recursives.getChildren().add(slowSort);
		recursives.getChildren().add(stoogeSort);
		recursives.getChildren().add(heapSort);
		recursives.getChildren().add(quickSort);
		recursives.getChildren().add(mergeSort);


		algorithmBox.getChildren().add(mathematicals);
		mathematicals.getChildren().add(mathematicalLabel);

		mathematicals.getChildren().add(gravitySort);
		mathematicals.getChildren().add(flashSort);
		mathematicals.getChildren().add(radixSort);
		mathematicals.getChildren().add(countingSort);
//		mathematicals.getChildren().add(countingSortBad);
		mathematicals.getChildren().add(pigeonSort);
		mathematicals.getChildren().add(aashishSort1);


		algorithmBox.getChildren().add(garbages);
		garbages.getChildren().add(garbageLabel);
		garbages.getChildren().add(bogoSort);
		garbages.getChildren().add(dropSort);
		if(getTriggered){
			garbages.getChildren().add(trumpSort);
			garbages.getChildren().add(bernieSort);
			garbages.getChildren().add(hillarySort);
			garbages.getChildren().add(intelligentDesignSort);
		}


		mainInterface.getChildren().add(bottomItems);
		bottomItems.getChildren().add(typeBox);
		typeBox.getChildren().add(typeTitle);
		typeBox.getChildren().add(alreadySorted);
		typeBox.getChildren().add(reverseOrder);
		typeBox.getChildren().add(randomOrder);

		bottomItems.getChildren().add(sizeBox);

//		sizeBox.getChildren().add(inputLabel);
		sizeBox.getChildren().add(sizeLabels);
		sizeBox.getChildren().add(sizeFields);

		sizeLabels.getChildren().add(inputSizeTitle);
		sizeFields.getChildren().add(inputSize);

//		sizeBox.getChildren().add(minInputSizeBox);
		sizeLabels.getChildren().add(minInputSizeTitle);
		sizeFields.getChildren().add(minInputSize);

//		sizeBox.getChildren().add(maxInputSizeBox);
		sizeLabels.getChildren().add(maxInputSizeTitle);
		sizeFields.getChildren().add(maxInputSize);


//		sizeBox.getChildren().add(blockSizeBox);
		sizeLabels.getChildren().add(blockSizeTitle);
		sizeFields.getChildren().add(blockSize);

		bottomItems.getChildren().add(goButton);

		mainInterface.getChildren().add(printConsoleBox);
		printConsoleBox.getChildren().add(printConsoleLabel);
		printConsoleBox.getChildren().add(printConsole);
		printConsoleBox.getChildren().add(offendLabel);
		printConsoleBox.getChildren().add(offend);

	}

	private static void setElementAssociations(){
		leftCushion.setMinWidth(19);

		javaSort.setSelected(true);
		randomOrder.setSelected(true);

		slowSort.setToggleGroup(algorithms);
		cycleSort.setToggleGroup(algorithms);
		stoogeSort.setToggleGroup(algorithms);
		selectionSort.setToggleGroup(algorithms);
		heapSort.setToggleGroup(algorithms);
		bubbleSort.setToggleGroup(algorithms);
		cocktailSort.setToggleGroup(algorithms);
		oddEvenSort.setToggleGroup(algorithms);
		combSort.setToggleGroup(algorithms);
		insertionSort.setToggleGroup(algorithms);
		shellSort.setToggleGroup(algorithms);
		quickSort.setToggleGroup(algorithms);
		mergeSort.setToggleGroup(algorithms);
//		timSort.setToggleGroup(algorithms);
		javaSort.setToggleGroup(algorithms);
		bogoSort.setToggleGroup(algorithms);
		trumpSort.setToggleGroup(algorithms);
		bernieSort.setToggleGroup(algorithms);
		hillarySort.setToggleGroup(algorithms);
		gravitySort.setToggleGroup(algorithms);
		radixSort.setToggleGroup(algorithms);
		countingSort.setToggleGroup(algorithms);
//		countingSortBad.setToggleGroup(algorithms);
		pigeonSort.setToggleGroup(algorithms);
		aashishSort1.setToggleGroup(algorithms);
		aashishSort2.setToggleGroup(algorithms);
		aashishSort5.setToggleGroup(algorithms);
		pancakeSort.setToggleGroup(algorithms);
		intelligentDesignSort.setToggleGroup(algorithms);
		flashSort.setToggleGroup(algorithms);
		dropSort.setToggleGroup(algorithms);

		alreadySorted.setToggleGroup(types);
		reverseOrder.setToggleGroup(types);
		randomOrder.setToggleGroup(types);


		goButton.setMinWidth(333);
		goButton.setMaxWidth(333);

		goButton.setMinHeight(111);
		goButton.setMaxHeight(111);
	}

	private static void setElementActions(){

		slowSort.setOnAction(sort->Sort.sortingMethod = "slowSort");
		cycleSort.setOnAction(sort->Sort.sortingMethod = "cycleSort");
		stoogeSort.setOnAction(sort->Sort.sortingMethod = "stoogeSort");
		selectionSort.setOnAction(sort->Sort.sortingMethod = "selectionSort");
		heapSort.setOnAction(sort->Sort.sortingMethod = "heapSort");
		bubbleSort.setOnAction(sort->Sort.sortingMethod = "bubbleSort");
		cocktailSort.setOnAction(sort->Sort.sortingMethod = "cocktailSort");
		oddEvenSort.setOnAction(sort->Sort.sortingMethod = "oddEvenSort");
		combSort.setOnAction(sort->Sort.sortingMethod = "combSort");
		insertionSort.setOnAction(sort->Sort.sortingMethod = "insertionSort");
		shellSort.setOnAction(sort->Sort.sortingMethod = "shellSort");
		quickSort.setOnAction(sort->Sort.sortingMethod = "quickSort");
		mergeSort.setOnAction(sort->Sort.sortingMethod = "mergeSort");
//		timSort.setOnAction(sort->Sort.sortingMethod = "timSort");
		javaSort.setOnAction(sort->Sort.sortingMethod = "javaSort");
		bogoSort.setOnAction(sort->Sort.sortingMethod = "bogoSort");
		trumpSort.setOnAction(sort->{
			if(!banned){
				alert("PLEASE READ!",
				      "This sort is entirely satire." + "\nPlease do not take it literally.",
				      "I myself am an immigrant." + "\nI have nothing against immigrants.",
				      "INFORMATION", true);
				banned = true;
			}

			Sort.sortingMethod = "trumpSort";
		});
		bernieSort.setOnAction(sort->Sort.sortingMethod = "bernieSort");
		hillarySort.setOnAction(sort->Sort.sortingMethod = "hillarySort");
		gravitySort.setOnAction(sort->Sort.sortingMethod = "gravitySort");
		radixSort.setOnAction(sort->Sort.sortingMethod = "radixSort");
		countingSort.setOnAction(sort->Sort.sortingMethod = "countingSort");
//		countingSortBad.setOnAction(sort->Sort.sortingMethod = "countingSortBad");
		pigeonSort.setOnAction(sort->Sort.sortingMethod = "pigeonSort");
		aashishSort1.setOnAction(sort->Sort.sortingMethod = "aashishSort1");
		aashishSort2.setOnAction(sort->Sort.sortingMethod = "aashishSort2");
		aashishSort5.setOnAction(sort->Sort.sortingMethod = "aashishSort5");
		pancakeSort.setOnAction(sort->Sort.sortingMethod = "pancakeSort");
		intelligentDesignSort.setOnAction(sort->Sort.sortingMethod = "intelligentDesignSort");
		flashSort.setOnAction(sort->Sort.sortingMethod = "flashSort");
		dropSort.setOnAction(sort->Sort.sortingMethod = "dropSort");

		alreadySorted.setOnAction(numbers->Sort.inputMethod = "alreadySorted");
		reverseOrder.setOnAction(numbers->Sort.inputMethod = "reverseOrder");
		randomOrder.setOnAction(numbers->Sort.inputMethod = "randomOrder");

		minInputSize.setOnKeyTyped(negatives->disableAppropriateItems());
		maxInputSize.setOnKeyTyped(negatives->disableAppropriateItems());

		goButton.setOnAction(letsGo->{
			try{
				Sort.minSize = Integer.parseInt(minInputSize.getText());
				Sort.maxSize = Integer.parseInt(maxInputSize.getText());

				Sort.letsSort(Integer.parseInt(inputSize.getText()),
				              Integer.parseInt(blockSize.getText()));
			}catch(NumberFormatException except){
				alert("Incorrect Input", "Invalid input in one of the fields.",
				      "Please enter an integer", "WARNING", false);
			}
		});

		printConsole.setOnAction(reduceOverhead->Sort.printArrays = printConsole.isSelected());
		offend.setOnAction(snowflake->{
			SortingSimulator.getTriggered = offend.isSelected();
			safeSpace();
		});
	}

	private static void safeSpace(){
		if(getTriggered){
			garbages.getChildren().add(trumpSort);
			garbages.getChildren().add(bernieSort);
			garbages.getChildren().add(hillarySort);
			garbages.getChildren().add(intelligentDesignSort);
		}
		else{
			if(trumpSort.isSelected() || bernieSort.isSelected() || hillarySort.isSelected() ||
					intelligentDesignSort.isSelected()){
				javaSort.setSelected(true);
				Sort.sortingMethod = "javaSort";
			}

			garbages.getChildren().remove(trumpSort);
			garbages.getChildren().remove(bernieSort);
			garbages.getChildren().remove(hillarySort);
			garbages.getChildren().remove(intelligentDesignSort);
		}
	}

	private static void disableNonNegatives(){
		gravitySort.setDisable(true);
		radixSort.setDisable(true);
		countingSort.setDisable(true);
//		countingSortBad.setDisable(true);
		aashishSort1.setDisable(true);

		if(gravitySort.isSelected() || radixSort.isSelected() || countingSort.isSelected() ||
				/*countingSortBad.isSelected() ||*/ aashishSort1.isSelected()){
			javaSort.setSelected(true);
			Sort.sortingMethod = "javaSort";
			alert("Algorithm Changed", "Your selected algorithm does not work with negatives.",
			      "The selection has been reverted to Java default Sort", "INFORMATION", false);
		}
	}

	private static void enableNonNegatives(){
		gravitySort.setDisable(false);
		radixSort.setDisable(false);
		countingSort.setDisable(false);
//		countingSortBad.setDisable(false);
		aashishSort1.setDisable(false);
	}

	private static void disableAppropriateItems(){
		try{
			if(Integer.parseInt(minInputSize.getText()) < 0 || Integer.parseInt(
					maxInputSize.getText()) < 0){
				disableNonNegatives();
			}
			else{
				enableNonNegatives();
			}
		}catch(NumberFormatException e){

		}
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
			case "ERROR":
				alert = new Alert(Alert.AlertType.ERROR);
				break;
			default:
				alert = new Alert(Alert.AlertType.NONE);
		}

		double height = Screen.getPrimary().getVisualBounds().getHeight();
		double width = Screen.getPrimary().getVisualBounds().getWidth();

		double windowHeight = Math.min(
				Math.max((height / 5) + Math.sqrt(content.length()) * Math.log1p(content.length()),
				         height / 5), height * 0.8);

		alert.setY((height - windowHeight) / 3);
		alert.setX(width / 3);

		alert.getDialogPane().setMinHeight(height / 5);

		if(height < 720){
			alert.getDialogPane().setMinHeight(height / 2);
		}
		alert.getDialogPane().setMaxHeight(height * 0.8);
		alert.getDialogPane().setPrefHeight(windowHeight);

		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		Toolkit.getDefaultToolkit().beep();

		alert.setResizable(true);

		if(wait){
			alert.showAndWait();
		}
		else{
			alert.show();
		}
	}
}

class SetGoState implements Runnable{

	boolean isDisabled;

	public SetGoState(boolean isDisabled){
		this.isDisabled = isDisabled;
	}


	@Override
	public void run(){
		GUI.goButton.setDisable(isDisabled);
		if(isDisabled){
			GUI.goButton.setText("Sorting...");
		}
		else{
			GUI.goButton.setText("Go");
		}
	}
}
