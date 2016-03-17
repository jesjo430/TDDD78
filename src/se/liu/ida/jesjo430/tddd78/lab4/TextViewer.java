package se.liu.ida.jesjo430.tddd78.lab4;

import javax.swing.*;
import java.awt.*;

public class TextViewer extends JComponent {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;

    final int LEFT_ALLIGNMENT = 0;
    final int FONT_SIZE = 12;

    final int startX = LEFT_ALLIGNMENT;

    public int paragraph = 0;
    public int PARAGRAPH_DISTANCE = 4;

    public int row = 0;
    public int ROW_DISTANCE = 4;


    public TextViewer() throws HeadlessException {
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public static void main(String[] args) {
	JFrame frame = new JFrame("TextViewer");
	frame.add(new TextViewer());
	frame.pack();
	frame.setVisible(true);
    }

    protected void drawRow(Graphics g, String text) {
	g.drawString(text, startX, (row+1)*FONT_SIZE+row*ROW_DISTANCE+paragraph*PARAGRAPH_DISTANCE);
	row += 1;
    }

    protected void paintComponent(final Graphics g) {

	g.setColor(Color.BLACK);
	g.setFont(new Font("serif", Font.PLAIN, FONT_SIZE));

	drawRow(g, "This is the first line of the first paragraph of text.");
	drawRow(g, "It is followed by the second line of text.");
	drawRow(g, "Which is followed by the third line of text.");

	paragraph += 1;

	drawRow(g, "Start of the second paragraph of text.");
	drawRow(g, "Continuation of the second paragraph of text.");
	drawRow(g, "Conclusion of the second paragraph of text.");

	paragraph += 1;

	drawRow(g, "Start of the third paragraph of text.");
	drawRow(g, "Continuation of the third paragraph of text.");
	drawRow(g, "Conclusion of the third paragraph of text.");
    }
}