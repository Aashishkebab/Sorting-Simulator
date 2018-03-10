/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting_Simulator;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sorting_algorithms.Sort;

import static Sorting_Simulator.SortingSimulator.alert;
import static Sorting_Simulator.SortingSimulator.banned;


/**
 * @author Aashish Bharadwaj
 */
public class GUI{

	static HBox elements = new HBox(0);
	static HBox leftCushion = new HBox();

	static VBox mainInterface = new VBox(14);
	static HBox topCushion = new HBox();

	static VBox algorithmBox = new VBox(1);
	static Label algorithmTitle = new Label("Sorting Algorithm");

	static ToggleGroup algorithms = new ToggleGroup();
	static RadioButton slowSort = new RadioButton("Slow Sort");
	static RadioButton cycleSort = new RadioButton("Cycle Sort");
	static RadioButton selectionSort = new RadioButton("Selection Sort");
	static RadioButton heapSort = new RadioButton("Heap Sort");
	static RadioButton bubbleSort = new RadioButton("Bubble Sort");
	static RadioButton cocktailSort = new RadioButton("Cocktail Sort");
	static RadioButton oddEvenSort = new RadioButton("Odd-Even Sort");
	static RadioButton combSort = new RadioButton("Comb Sort");
	static RadioButton insertionSort = new RadioButton("Insertion Sort");
	static RadioButton shellSort = new RadioButton("Shell Sort");
	static RadioButton quickSort = new RadioButton("Quick Sort");
	static RadioButton mergeSort = new RadioButton("Merge Sort");
	static RadioButton timSort = new RadioButton("Tim Sort");
	static RadioButton javaSort = new RadioButton("Java default sort");
	static RadioButton randomSort = new RadioButton("Randomness Sort");
	static RadioButton trumpSort = new RadioButton("Trump Sort (Illegal comparables)");
	static RadioButton bernieSort = new RadioButton("Bernie Sort (Democratic socialism)");
	static RadioButton hillarySort = new RadioButton("Hillary Sort (Wipe the server)");
	static RadioButton radixSort = new RadioButton("Radix Sort");
	static RadioButton bucketSort = new RadioButton("Bucket Sort");
	static RadioButton countingSort = new RadioButton("Counting Sort");
	static RadioButton pigeonSort = new RadioButton("Pigeonhole Sort");

	static VBox typeBox = new VBox(5);
	static Label typeTitle = new Label("Input Type");

	static ToggleGroup types = new ToggleGroup();
	static RadioButton alreadySorted = new RadioButton("Already sorted");
	static RadioButton reverseOrder = new RadioButton("Reverse order");
	static RadioButton randomOrder = new RadioButton("Random");

	static VBox sizeBox = new VBox(7);
	static HBox inputSizeBox = new HBox(17);
	static Label inputSizeTitle = new Label("Input Size");
	static TextField inputSize = new TextField("0");

	static HBox blockSizeBox = new HBox(17);
	static Label blockSizeTitle = new Label("Block Size");
	static TextField blockSize = new TextField("0");

	static Button goButton = new Button("Go");

	public static void createUI(){
		//System.out.println("Creating UI");

		addElementsToInterface();
		setElementSizing();
		setElementActions();
	}

	private static void addElementsToInterface(){
		elements.getChildren().add(leftCushion);
		mainInterface.getChildren().add(topCushion);

		elements.getChildren().add(mainInterface);
		mainInterface.getChildren().add(algorithmBox);
		algorithmBox.getChildren().add(algorithmTitle);

		algorithmBox.getChildren().add(slowSort);
		algorithmBox.getChildren().add(cycleSort);
		algorithmBox.getChildren().add(selectionSort);
		algorithmBox.getChildren().add(heapSort);
		algorithmBox.getChildren().add(bubbleSort);
		algorithmBox.getChildren().add(cocktailSort);
		algorithmBox.getChildren().add(oddEvenSort);
		algorithmBox.getChildren().add(combSort);
		algorithmBox.getChildren().add(insertionSort);
		algorithmBox.getChildren().add(shellSort);
		algorithmBox.getChildren().add(quickSort);
		algorithmBox.getChildren().add(mergeSort);
		algorithmBox.getChildren().add(timSort);
		algorithmBox.getChildren().add(javaSort);
		algorithmBox.getChildren().add(randomSort);
		algorithmBox.getChildren().add(trumpSort);
		algorithmBox.getChildren().add(bernieSort);
		algorithmBox.getChildren().add(hillarySort);
		algorithmBox.getChildren().add(radixSort);
		algorithmBox.getChildren().add(bucketSort);
		algorithmBox.getChildren().add(countingSort);
		algorithmBox.getChildren().add(pigeonSort);

		javaSort.setSelected(true);

		mainInterface.getChildren().add(typeBox);
		typeBox.getChildren().add(typeTitle);
		typeBox.getChildren().add(alreadySorted);
		typeBox.getChildren().add(reverseOrder);
		typeBox.getChildren().add(randomOrder);

		randomOrder.setSelected(true);

		mainInterface.getChildren().add(sizeBox);
		sizeBox.getChildren().add(inputSizeBox);
		inputSizeBox.getChildren().add(inputSizeTitle);
		inputSizeBox.getChildren().add(inputSize);
		sizeBox.getChildren().add(blockSizeBox);
		blockSizeBox.getChildren().add(blockSizeTitle);
		blockSizeBox.getChildren().add(blockSize);

		mainInterface.getChildren().add(goButton);
	}

	private static void setElementSizing(){
		leftCushion.setMinWidth(17);
		topCushion.setMinHeight(1);

		slowSort.setToggleGroup(algorithms);
		cycleSort.setToggleGroup(algorithms);
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
		timSort.setToggleGroup(algorithms);
		randomSort.setToggleGroup(algorithms);
		javaSort.setToggleGroup(algorithms);
		trumpSort.setToggleGroup(algorithms);
		bernieSort.setToggleGroup(algorithms);
		hillarySort.setToggleGroup(algorithms);
		radixSort.setToggleGroup(algorithms);
		bucketSort.setToggleGroup(algorithms);
		countingSort.setToggleGroup(algorithms);
		pigeonSort.setToggleGroup(algorithms);

		alreadySorted.setToggleGroup(types);
		reverseOrder.setToggleGroup(types);
		randomOrder.setToggleGroup(types);

		goButton.setMinWidth(299);
	}

	private static void setElementActions(){

		slowSort.setOnAction(sort->Sort.sortingMethod = "cycleSort");
		cycleSort.setOnAction(sort->Sort.sortingMethod = "cycleSort");
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
		timSort.setOnAction(sort->Sort.sortingMethod = "timSort");
		randomSort.setOnAction(sort->Sort.sortingMethod = "randomSort");
		javaSort.setOnAction(sort->Sort.sortingMethod = "javaSort");
		trumpSort.setOnAction(sort->{
			if(!banned){
				alert("PLEASE READ!", "This sort is entirely satire.\nPlease do not take it literally.",
				      "I myself am an immigrant.\nI have nothing against immigrants.", "INFORMATION", true
				);
				banned = true;
			}

			Sort.sortingMethod = "trumpSort";
		});
		bernieSort.setOnAction(sort->Sort.sortingMethod = "bernieSort");
		hillarySort.setOnAction(sort->Sort.sortingMethod = "hillarySort");
		radixSort.setOnAction(sort->Sort.sortingMethod = "radixSort");
		bucketSort.setOnAction(sort->Sort.sortingMethod = "bucketSort");
		countingSort.setOnAction(sort->Sort.sortingMethod = "countingSort");
		pigeonSort.setOnAction(sort->Sort.sortingMethod = "pigeonSort");

		alreadySorted.setOnAction(numbers->Sort.inputMethod = "alreadySorted");
		reverseOrder.setOnAction(numbers->Sort.inputMethod = "reverseOrder");
		randomOrder.setOnAction(numbers->Sort.inputMethod = "randomOrder");

		goButton.setOnAction(letsGo->{
			try{
				Sort.letsSort(Integer.parseInt(inputSize.getText()), Integer.parseInt(blockSize.getText()));
			}catch(NumberFormatException except){
				alert("Incorrect Input", "You have not entered an integer.", "Please enter a positive integer",
				      "WARNING", false
				);
			}
		});
	}
}