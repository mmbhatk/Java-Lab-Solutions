package q4a;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class q4a extends Applet implements KeyListener {
	
	Label enter = new Label("Enter text: ");
	TextField t = new TextField();
	Label status = new Label();
	
	public void init() {
		setLayout(new GridLayout(3, 1));
		add(enter);
		add(t);
		add(status);
		t.addKeyListener(this);
		setVisible(true);
	}
	
	public boolean isPalindrome(String s) {
		String s2 = "";
		for(int i = 0; i<s.length(); i++) s2 += s.charAt(s.length()-i-1);
		if(s.equals(s2)) return true;
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='p') {
			if(isPalindrome(t.getText())) showStatus("Palindrome.");
			else showStatus("Not a palindrome.");
		}
	}
}