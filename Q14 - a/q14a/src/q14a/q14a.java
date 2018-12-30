package q14a;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class q14a extends Applet implements MouseListener, MouseMotionListener {
	
	int startX, startY, x, y, height, width;
	
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getX() >= startX) {x = startX; height = e.getX() - startX; }
		else {x = e.getX(); height = startX - e.getX(); }
		
		if(e.getY() >= startY) {y = startY; width = e.getY() - startY; }
		else {y = e.getY(); width = startY - e.getY(); }
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(x,  y, width, height);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}