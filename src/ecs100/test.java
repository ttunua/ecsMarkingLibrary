/* Code for ECS100 Assignment
 * Name:
 * Usercode:
 * ID:
 */

 

import ecs100.UI;

import java.awt.Color;
import java.util.*;
import java.io.*;


/** Test   */

public class test{


    /** Construct a new Test object */
    public test(){
	UI.initialise();
	setup();
    }
    private void setup(){
	UI.setMouseListener(this::doMouse);
	UI.addButton("DOIT", this::doButton);
	UI.addButton("hide text", ()->UI.setDivider(0.0));
	UI.addButton("hide graphics", ()->UI.setDivider(1.0));
	UI.addButton("show default", ()->UI.setDivider(-1));
	UI.addButton("show narrow text", ()->UI.setDivider(0.2));
	UI.addButton("messy ask", ()->{for (int i=UI.askInt("start:"); i>=0; i--){
		    UI.println("Counting down: "+i);
		    UI.sleep(100);
		}});
	UI.addButton("messy", ()->{for (int i=10; i>=0; i--){
		    UI.println("Counting down: "+i);
		}});
	UI.addButton("resize", ()->{
		UI.initialise();
		UI.addButton("do",this::setup);
		UI.setWindowSize(300, 300);
	    });
	UI.addButton("Clear", UI::clearPanes);
	UI.addButton("Quit", UI::quit);
	UI.setWindowSize(700, 700);
    }

    public void doButton(){
	int wd = UI.askInt("Enter size");
	for (int i=0; i<1000; i++){
	    UI.drawRect(Math.random()*400, Math.random()*400, wd, wd);
	    UI.sleep(100);
	}
    }

    public void doMouse(String action, double x, double y){
	if (action.equals("pressed")){
	    UI.fillRect(x-6, y-6, 12, 12);
	}
	else if (action.equals("released")){
	    UI.drawOval(x-10, y-10, 20, 20);
	}
    }


    public static void main(String[] arguments){
	new test();
    }	


}
