package ecs100;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/** Provides static methods to get a file name using the standard
 * swing file dialog box.
 * Does not throw errors, but returns the null string if user cancels.
 */

public class UIFileChooser implements Runnable {

    /** Constructor is private to prevent user from constructing an instance of this class */
    private UIFileChooser(){
    }
    
    private static String filePath;
    private static String chooserTitle = null;
    private static boolean saving = false;
    
    @Override
	public void run() {
    	JFileChooser chooser = new JFileChooser(".");
    	if (chooserTitle != null) {
    		chooser.setDialogTitle(chooserTitle);
    	}
    	int returnVal = 0;
    	if (saving) {
    		returnVal = chooser.showSaveDialog(null);
    	} else {
    		returnVal =  chooser.showOpenDialog(null);   // was (UI.getFrame()) mac problems?
    	}
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		    filePath = chooser.getSelectedFile().getPath();
		else
		    filePath = null;
	}

    /** Opens a file chooser dialog box to allow the user to select an existing file to open.
	Returns a string that is the path to the file, or null if the user cancelled. */
    public static String open(){
    	filePath = "nothing";
    	saving = false;
    	try {
			SwingUtilities.invokeAndWait(new UIFileChooser());
		} catch (InvocationTargetException | InterruptedException e) {
			// Do nothing
		}
    	return filePath;
    }
    

    /** Opens a file chooser dialog box with a specified title.
	Allows the user to select an existing file to open.
	Returns a string that is the name of the file, or null if the user cancelled. */
    public static String open(String title){
    	filePath = "nothing";
    	saving = false;
    	chooserTitle = title;
    	try {
			SwingUtilities.invokeAndWait(new UIFileChooser());
		} catch (InvocationTargetException | InterruptedException e) {
			// Do nothing
		}
    	chooserTitle = null;
    	return filePath;
    }

    /** Opens a file chooser dialog box to allow the user to select a file (possibly new) to save to.
	Returns a string that is the name of the file, or null if the user cancelled. */
    public static String save(){
    	filePath = "nothing";
    	saving = true;
    	try {
			SwingUtilities.invokeAndWait(new UIFileChooser());
		} catch (InvocationTargetException | InterruptedException e) {
			// Do nothing
		}
    	return filePath;
    }

    /** Opens a file chooser dialog box with a specified title.
	Allows the user to select a file (possibly new) to save to.
	Returns a string that is the name of the file, or null if the user cancelled. */
    public static String save(String title){
    	filePath = "nothing";
    	saving = true;
    	chooserTitle = title;
    	try {
			SwingUtilities.invokeAndWait(new UIFileChooser());
		} catch (InvocationTargetException | InterruptedException e) {
			// Do nothing
		}
    	chooserTitle = null;
    	return filePath;
    }


}
