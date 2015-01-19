//: com:bruceeckel:swing:Console.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Tool for running Swing demos from the
// console, both applets and JFrames.
package com.bruceeckel.swing;
import javax.swing.*;
import java.awt.event.*;

public class Console 
{
  // Create a title string from the class name:
  public static String title(Object o) 
  {
    String t = o.getClass().toString();//这里获取是全称，比如class com.xxx.xxx
    // Remove the word "class":
    if(t.indexOf("class") != -1)
      t = t.substring(6);
    return t;
  }
  
  public static void setupClosing(JFrame frame) 
  {
    // The JDK 1.2 Solution as an 
    // anonymous inner class:
	/*
	 * WindowAdapter是个抽象类，里面对接口WindowListener的方法都进行了空实现。
		这样编程时不需要自己再去实现全部接口WindowListener里的方法。只需覆写自己需要的方法，其他的方法
		WindowAdapter都实现了。
	 */
    frame.addWindowListener(new WindowAdapter() 
    {
    	//Invoked when a window is in the process of being closed.
      public void windowClosing(WindowEvent e) 
      {
        System.exit(0);
      }
    });
    // The improved solution in JDK 1.3:
    // frame.setDefaultCloseOperation(
    //     EXIT_ON_CLOSE);
  }
  public static void 
  run(JFrame frame, int width, int height) {
    setupClosing(frame);
    frame.setSize(width, height);
    frame.setVisible(true);
  }
  public static void 
  run(JApplet applet, int width, int height) {
    JFrame frame = new JFrame(title(applet));
    setupClosing(frame);
    frame.getContentPane().add(applet);
    frame.setSize(width, height);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
  public static void 
  run(JPanel panel, int width, int height) {
    JFrame frame = new JFrame(title(panel));
    setupClosing(frame);
    frame.getContentPane().add(panel);
    frame.setSize(width, height);
    frame.setVisible(true);
  }
} ///:~