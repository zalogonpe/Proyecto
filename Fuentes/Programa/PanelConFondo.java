package Programa;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelConFondo extends JPanel {
  private Image fondo;
  
  public PanelConFondo(String archivo) throws IOException {
	fondo=ImageIO.read(new File(archivo));
  }
  public void paint(Graphics g) {
	g.drawImage(fondo, 0, 0, this);
	setOpaque(false);
	super.paint(g);
  }
}