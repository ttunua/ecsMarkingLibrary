package ecs100;

import ecs100.*;

import java.awt.Color;
import javax.swing.JOptionPane;
/**  */
// Main

public class testEcs100{

    public static void main(String[] arguments){
	new testEcs100().test3();
    }

    public void test(){
	UI.addButton("Tryit", () -> UI.askInt("prompt"));
    }

    public void test3 (){
	//Trace.setVisible();
	//UI.sleep(500);
	UI.println("Hello world");
	/*
	  String name = UI.askString("what is your name");
	  int age = UI.askInt("How old are you, "+name);
	  UI.printf("Happy %d birthday, %s\n", age, name);
	  UI.println();
	  UI.print("Enter remaining words (end with boo):");
	  String tok = "";
	  do {
	  tok = UI.next();
	  UI.println(">"+tok);
	  }while (!tok.equals("boo"));
	  UI.println("DONE");
	  if (UI.askBoolean("Quit now")){
	  UI.quit();
	  return;
	  }
	*/
	UI.setColor(Color.blue);
	UI.drawLine(90.3, 30.53, 100.3, 30.5);
	UI.drawLine(100.3, 30.53, 100.3, 20.5);
	UI.drawLine(150.3, 52.53, 160.3, 52.5);
	UI.drawLine(150.3, 52.53, 150.3, 62.5);
	UI.setColor(Color.black);
	UI.drawRect(100.3, 30.53, 50.3, 22);
	UI.fillRect(300.3, 30.53, 50.3, 22);
	UI.drawPolygon(new double[]{200, 230, 260, 270, 250, 220},
		       new double[]{100, 100, 140, 120, 130, 105}, 6);
	UI.fillPolygon(new double[]{200, 230, 260, 270, 250, 220},
		       new double[]{160, 160, 200, 180, 190, 165}, 6);
	UI.drawOval(100.3, 130.53, 50.3, 22);
	UI.fillOval(300.3, 130.53, 50.3, 22);


	UI.printMessage("there should be a rectangle.....");
	UI.setMouseListener((action, x, y) -> doMouse(action, x, y));
	UI.setKeyListener((k) -> UI.println("key="+k));
	UI.addButton("black", () -> {UI.setColor(Color.black); UI.fillRect(100, 30.5, 50, 22);});
	UI.addButton("red", () -> {UI.setColor(Color.red); UI.fillRect(160, 30.5, 50, 22);});
	UI.addButton("white", () -> {UI.eraseRect(100, 30.5, 50, 22); UI.setColor(Color.black); UI.drawRect(220, 30.5, 50, 22);});
	UI.addButton("oval", () -> doButton("oval"));
	UI.addTextField("name", (v) -> UI.println("You entered "+v));
	UI.addTextField("age", (v) -> UI.drawString(v, 100, 100));
	UI.addSlider("size", 0, 100, (v) -> {
	    UI.eraseRect(200, 200, 400, 400);
	    UI.setColor(Color.green);
	    UI.fillRect(200, 200, v, v);
	    UI.setColor(Color.black);
	});
	UI.addSlider("repetitions", 10, 20, 15, (v) -> {
	    UI.println("-----------------");
	    for (int i=0; i<v; i++){UI.printf("now doing it: %d .\n", i);}
	    });
	UI.addButton("clear", () -> doButton("clear"));
	UI.addButton("hello", () -> doButton("hello"));
    }

    public void test2 (){
	UI.setMouseListener((action, x, y) -> doMouse(action, x, y));
	UI.println("Hello world");
	UI.sleep(2000);
	JOptionPane.showMessageDialog(UI.getFrame(), "now draw?");
	UI.drawRect(100, 30.5, 50, 22);
	UI.printMessage("there should be a rectangle");
	UI.sleep(5000);
	UI.addButton("black", () -> doButton("black"));
	UI.addButton("red", () -> doButton("red"));
	UI.addButton("white", () -> doButton("white"));
	JOptionPane.showMessageDialog(UI.getFrame(), "now Trace?");
	Trace.setVisible(true);
	for (int i=0; i<100; i++){
	    Trace.println("now doing it: "+i);
	    Trace.setVisible(i<20 || i>60);
	}
    }	
    
    public void doButton(String button){
	if (button.equals("hello")){
	    int age = UI.askInt("how old");
	    String name = UI.askString("name");
	    UI.println("Hello "+ name);
	    UI.println("You are "+ age + " years old");
	}
	else if (button.equals("black")){
	    UI.setColor(Color.black);
	    UI.fillRect(100, 30.5, 50, 22);
	}
	else if (button.equals("red")){
	    UI.setColor(Color.red);
	    UI.fillRect(160, 30.5, 50, 22);
	}
	if (button.equals("white")){
	    UI.eraseRect(100, 30.5, 50, 22);
	    UI.setColor(Color.black);
	    UI.drawRect(220, 30.5, 50, 22);
	}
	if (button.equals("oval")){
	    UI.setColor(Color.green);
	    UI.drawOval(100, 30.5, 50, 22);
	    UI.eraseOval(160, 30.5, 50, 22);
	}
	if (button.equals("clear")){
	    UI.clearGraphics();
	}
    }


    private double lastx, lasty;
    
    public void doMouse(String action, double x, double y){
	if (action.equals("pressed")){
	    lastx = x; lasty = y;
	}
	else if  (action.equals("released")){
	    UI.drawLine(lastx, lasty, x, y);
	}
    }

    public void keyPerformed(String key){
	UI.println("Key pressed: "+key);
    }


}
