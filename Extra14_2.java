package P05;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.*;

public class Extra14_2 extends Application {
	
	private static Circle circles[] = new Circle[4];

	/**
	 * Sets the attributes for a randomly generated circle.
	 * @return Returns the finished circle.
	 */
	
	public Circle drawCircle(double height, double width) {
		
		Circle circle = new Circle();
		Random generator = new Random();
		circle.setCenterX((generator.nextInt((int)width))+25);
		circle.setCenterY((generator.nextInt((int)height))+25);
		// Detect if the circle will be off screen, and shifts it
		// back onto the screen.
		if(circle.getCenterX() > (width - 25)) {
			circle.setCenterX(circle.getCenterX() - 25);
		}
		if(circle.getCenterY() > (height - 25)) {
			circle.setCenterY(circle.getCenterY() - 25);
		}
		circle.setRadius(10.0);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		return circle;
	}
	
	/**
	 * Adds the Line objects to the pane.
	 * @param pane The pane for the GUI view.
	 * @param circles The circles to be used to make lines.
	 * @return The pane after the lines are added.
	 */
	
	public Pane setLines(Pane pane) {
		
		// Originally used an array of lines with a loop that set
		// everything nicely without brute-forcing things, but
		// it seems that JavaFX really doesn't like arrays.
		Line line1 = new Line();
		Line line2 = new Line();
		Line line3 = new Line();
		Line line4 = new Line();
		Line line5 = new Line();
		Line line6 = new Line();
		line1.setStartX(circles[0].getCenterX());
		line1.setStartY(circles[0].getCenterY());
		line1.setEndX(circles[1].getCenterX());
		line1.setEndY(circles[1].getCenterY());
		line2.setStartX(circles[1].getCenterX());
		line2.setStartY(circles[1].getCenterY());
		line2.setEndX(circles[2].getCenterX());
		line2.setEndY(circles[2].getCenterY());
		line3.setStartX(circles[2].getCenterX());
		line3.setStartY(circles[2].getCenterY());
		line3.setEndX(circles[3].getCenterX());
		line3.setEndY(circles[3].getCenterY());
		line4.setStartX(circles[3].getCenterX());
		line4.setStartY(circles[3].getCenterY());
		line4.setEndX(circles[0].getCenterX());
		line4.setEndY(circles[0].getCenterY());
		line5.setStartX(circles[0].getCenterX());
		line5.setStartY(circles[0].getCenterY());
		line5.setEndX(circles[2].getCenterX());
		line5.setEndY(circles[2].getCenterY());
		line6.setStartX(circles[1].getCenterX());
		line6.setStartY(circles[1].getCenterY());
		line6.setEndX(circles[3].getCenterX());
		line6.setEndY(circles[3].getCenterY());
		pane.getChildren().add(line1);
		pane.getChildren().add(line2);
		pane.getChildren().add(line3);
		pane.getChildren().add(line4);
		pane.getChildren().add(line5);
		pane.getChildren().add(line6);
		
		
		return pane;
		
	}
	
	/**
	 * Adds the Circle objects to the pane.
	 * @param pane The pane for the GUI view.
	 * @param circles The circles to be added.
	 * @return The pane after the circles are added.
	 */
	
	public Pane setCircles(Pane pane) {
		
		for(int i = 0; i < 4; i++) {
			pane.getChildren().add(circles[i]);
		}
		
		return pane;
		
	}
	
	/**
	 * Builds the GUI stage.
	 */
	
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		for(int i = 0; i < 4; i++) {
			circles[i] = drawCircle(350, 350);
		}

		this.setLines(pane);
		this.setCircles(pane);
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Circles");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Unsure if we covered Event Listeners yet, but from searching around
		// this seemed like the best implementation of this requirement.
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
			for(int i = 0; i < 4; i++) {
				circles[i] = drawCircle(primaryStage.heightProperty().getValue() - 50, primaryStage.widthProperty().getValue() - 50);
			}
			pane.getChildren().clear();
			this.setLines(pane);
			this.setCircles(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		     // Do whatever you want
		});

		primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
			for(int i = 0; i < 4; i++) {
				circles[i] = drawCircle(primaryStage.heightProperty().getValue() - 50, primaryStage.widthProperty().getValue() - 50);
			}
			pane.getChildren().clear();
			this.setLines(pane);
			this.setCircles(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		     // Do whatever you want
		});
		
	}
	
	/**
	 * Main method that acts as a driver.
	 * @param args ARG!
	 */
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
