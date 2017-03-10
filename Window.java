package bologheanu_florin_30224_tema_1;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

import com.sun.javafx.scene.paint.GradientUtils.Point;


public class Window extends JFrame {
	
	Window(){
		super();
		setTitle("Polynomial Calculator");
		setSize(600, 300);
		centerFrame();
	}
	
	
	
	private void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
}
}
