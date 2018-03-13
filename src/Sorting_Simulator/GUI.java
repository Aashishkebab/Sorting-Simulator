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
	static VBox topCushion = new VBox();

	static VBox mainInterface = new VBox(37);

	static HBox algorithmBox = new HBox(55);
	static Label algorithmTitle = new Label("Sorting Algorithm");

	static VBox iteratives = new VBox(7);
	static Label iterativeLabel = new Label("Iterative Algorithms");

	static VBox recursives = new VBox(7);
	static Label recursiveLabel = new Label("Recursive Algorithms");

	static VBox mathematicals = new VBox(7);
	static Label mathematicalLabel = new Label("Mathematical (non-comparitive) Algorithms");

	static VBox garbages = new VBox(7);
	static Label garbageLabel = new Label("Garbage Algorithms");

	static ToggleGroup algorithms = new ToggleGroup();
	static RadioButton slowSort = new RadioButton("Slow Sort");
	static RadioButton cycleSort = new RadioButton("Cycle Sort");
	static RadioButton stoogeSort = new RadioButton("Stooge Sort");
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
	//	static RadioButton timSort = new RadioButton("Tim Sort");
	static RadioButton javaSort = new RadioButton("Java default sort");
	static RadioButton randomSort = new RadioButton("Randomness Sort");
	static RadioButton trumpSort = new RadioButton("Trump Sort");
	static RadioButton bernieSort = new RadioButton("Bernie Sort");
	static RadioButton hillarySort = new RadioButton("Hillary Sort");
	static RadioButton gravitySort = new RadioButton("Gravity/Bead Sort");
	static RadioButton radixSort = new RadioButton("Radix Sort");
	static RadioButton bucketSort = new RadioButton("Bucket Sort");
	static RadioButton countingSort = new RadioButton("Counting Sort");
	static RadioButton pigeonSort = new RadioButton("Pigeonhole Sort");
	static RadioButton aashishSort1 = new RadioButton("Aashish Sort 1");
	static RadioButton aashishSort2 = new RadioButton("Aashish Sort 2");
	static RadioButton aashishSort5 = new RadioButton("Aashish Sort 5");
	static RadioButton aashishSort4 = new RadioButton("Aashish Sort 4");

	static VBox typeBox = new VBox(9);
	static Label typeTitle = new Label("Input Type");

	static ToggleGroup types = new ToggleGroup();
	static RadioButton alreadySorted = new RadioButton("Already sorted");
	static RadioButton reverseOrder = new RadioButton("Reverse order");
	static RadioButton randomOrder = new RadioButton("Random");

	static HBox bottomItems = new HBox(44);

	static HBox sizeBox = new HBox(23);
	static Label inputLabel = new Label("Input Parameters");

//	static HBox inputSizeBox = new HBox(13);


//	static HBox minInputSizeBox = new HBox(13);

	static VBox sizeLabels = new VBox(17);
	static Label inputSizeTitle = new Label("Input Size");
	static Label minInputSizeTitle = new Label("Smallest Number");
	static Label maxInputSizeTitle = new Label("Largest Number");
	static Label blockSizeTitle = new Label("Block Size");

	static VBox sizeFields = new VBox(7);
	static TextField inputSize = new TextField("0");
	static TextField minInputSize = new TextField("0");
	static TextField maxInputSize = new TextField("0");
	static TextField blockSize = new TextField("0");

//	static HBox maxInputSizeBox = new HBox(13);


//	static HBox blockSizeBox = new HBox(13);


	public static Button goButton = new Button("Go");

	static HBox printConsoleBox = new HBox(4);
	static Label printConsoleLabel = new Label("Display array");
	static CheckBox printConsole = new CheckBox();

	public static void createUI(){
		//System.out.println("Creating UI");

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
		iteratives.getChildren().add(aashishSort4);


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
		mathematicals.getChildren().add(radixSort);
		mathematicals.getChildren().add(bucketSort);
		mathematicals.getChildren().add(countingSort);
		mathematicals.getChildren().add(pigeonSort);
		mathematicals.getChildren().add(aashishSort1);


		algorithmBox.getChildren().add(garbages);
		garbages.getChildren().add(garbageLabel);

		iteratives.getChildren().add(aashishSort2);
		garbages.getChildren().add(randomSort);
		garbages.getChildren().add(trumpSort);
		garbages.getChildren().add(bernieSort);
		garbages.getChildren().add(hillarySort);


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
		randomSort.setToggleGroup(algorithms);
		trumpSort.setToggleGroup(algorithms);
		bernieSort.setToggleGroup(algorithms);
		hillarySort.setToggleGroup(algorithms);
		gravitySort.setToggleGroup(algorithms);
		radixSort.setToggleGroup(algorithms);
		bucketSort.setToggleGroup(algorithms);
		countingSort.setToggleGroup(algorithms);
		pigeonSort.setToggleGroup(algorithms);
		aashishSort1.setToggleGroup(algorithms);
		aashishSort2.setToggleGroup(algorithms);
		aashishSort5.setToggleGroup(algorithms);
		aashishSort4.setToggleGroup(algorithms);

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
		randomSort.setOnAction(sort->Sort.sortingMethod = "randomSort");
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
		bucketSort.setOnAction(sort->Sort.sortingMethod = "bucketSort");
		countingSort.setOnAction(sort->Sort.sortingMethod = "countingSort");
		pigeonSort.setOnAction(sort->Sort.sortingMethod = "pigeonSort");
		aashishSort1.setOnAction(sort->Sort.sortingMethod = "aashishSort1");
		aashishSort2.setOnAction(sort->Sort.sortingMethod = "aashishSort2");
		aashishSort5.setOnAction(sort->Sort.sortingMethod = "aashishSort5");
		aashishSort4.setOnAction(sort->Sort.sortingMethod = "aashishSort4");

		alreadySorted.setOnAction(numbers->Sort.inputMethod = "alreadySorted");
		reverseOrder.setOnAction(numbers->Sort.inputMethod = "reverseOrder");
		randomOrder.setOnAction(numbers->Sort.inputMethod = "randomOrder");

		minInputSize.setOnKeyTyped(negatives->{
			disableAppropriateItems();
		});
		maxInputSize.setOnKeyTyped(negatives->{
			disableAppropriateItems();
		});

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
	}

	private static void disableNonNegatives(){
		gravitySort.setDisable(true);
		radixSort.setDisable(true);
		bucketSort.setDisable(true);
		countingSort.setDisable(true);
		aashishSort1.setDisable(true);

		if(gravitySort.isSelected() || radixSort.isSelected() || bucketSort.isSelected() ||
				countingSort.isSelected() || aashishSort1.isSelected()){
			javaSort.setSelected(true);
			Sort.sortingMethod = "javaSort";
			alert("Algorithm Changed", "Your selected algorithm does not work with negatives.",
			      "The selection has been reverted to Java default Sort", "INFORMATION", false);
		}
	}

	private static void enableNonNegatives(){
		gravitySort.setDisable(false);
		radixSort.setDisable(false);
		bucketSort.setDisable(false);
		countingSort.setDisable(false);
		aashishSort1.setDisable(false);
	}

	private static void disableAppropriateItems(){
		try{
			if(Integer.parseInt(minInputSize.getText()) < 0 || Integer.parseInt(
					maxInputSize.getText()) < 0){
				disableNonNegatives();
			}else{
				enableNonNegatives();
			}
		}catch(NumberFormatException e){

		}
	}
}
