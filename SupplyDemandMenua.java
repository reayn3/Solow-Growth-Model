import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.applet.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SupplyDemandMenua extends Applet implements ItemListener
{

// private static final long serialVersionUID = 1L;


String xlabel = "Quantity";
String ylabel = "Price";
String xlabel1 = "Q*";
String ylabel1 = "P*";
String ldemand = "D*";
String lsupply = "S*";

String ldemand0 = "D*";
String ldemand1 = "D'";
String lsupply1 = "S'";

String xlabel2 = "Q1";
String ylabel2 = "P1";

private Font font;
private Font font2;
private Font font3;
private Font font4;
int xbeg = 50;
int ybeg = 50;
int xend = 350;
int yend = 350;
int xmiddle = ((xend-xbeg)/2)+xbeg;
int ymiddle = ((yend-ybeg)/2)+ybeg;

List lst;

BasicStroke stroke = new BasicStroke(2.0f);
BasicStroke wide = new BasicStroke(4.0f);

float dash1[ ] = {6.0f};

BasicStroke dashed = new BasicStroke(2.0f,
BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
2.0f, dash1, 3.0f);

double PV, FV, r, n, c;

public void init()
{
font = new Font("Helvetica", Font.BOLD, 14);
font2 = new Font("Helvetica", Font.BOLD, 20);
font3 = new Font("Helvetica", Font.PLAIN, 12);
font4 = new Font("Helvetica", Font.PLAIN, 100);

setLayout(null);
lst = new List();
lst.add("Equilibrium");
lst.add("Increase Demand");
lst.setBounds(xend+90, ybeg-10, 250, 90);
lst.select(0);
add(lst);
lst.addItemListener(this);

}

// This part creates the initial graph showing an equilibrium - the default before a choice is made from the menu


public void paint(Graphics g) 
{
Graphics2D g2 = (Graphics2D) g;
g2.setColor(Color.black);

/* drawLine ( x1, y1, x2, y2) */

g2.setStroke(wide);

/* x-axis */

g2.draw(new Line2D.Double(xbeg, yend , xend + 30, yend));

/* y-axis */

g2.draw(new Line2D.Double(xbeg, ybeg , xbeg, yend)); 

/* demand curve */

g2.setStroke(stroke);
g2.setColor(Color.green);
g2.draw(new Line2D.Double(xbeg + 20, ybeg + 20, xend - 20, yend - 20)); 

/* supply curve */

g2.setStroke(stroke);
g2.setColor(Color.blue);
g2.draw(new Line2D.Double(xbeg + 20, yend - 20, xend - 20, ybeg + 20)); 

/* Equilibrium Price and Quantity */

g2.setStroke(dashed);
g2.setColor(Color.red);
g2.draw(new Line2D.Double(xbeg, ymiddle, xmiddle, ymiddle)); 
g2.draw(new Line2D.Double(xmiddle, yend, xmiddle, ymiddle)); 

/* drawString ( String str, x, y) */

g2.setColor(Color.black);
g2.setFont(font);
g2.drawString(xlabel, xend-50, yend+15); 
g2.drawString(ylabel, xbeg-40, ybeg+15); 
g2.drawString(xlabel1, xmiddle-5, yend+15); 
g2.drawString(ylabel1, xbeg-20, ymiddle+2); 
g2.drawString(ldemand, xend-25, yend-30); 
g2.drawString(lsupply, xend-18, ybeg+40); 

//  This part creates the equilibrium graph from the menu - the same as the default


if(lst.getSelectedIndex()==0)
{

    /* drawLine ( x1, y1, x2, y2) */

    g2.setStroke(wide);

    /* x-axis */

    g2.draw(new Line2D.Double(xbeg, yend , xend + 30, yend));

    /* y-axis */

    g2.draw(new Line2D.Double(xbeg, ybeg , xbeg, yend)); 

    /* demand curve */

    g2.setStroke(stroke);
    g2.setColor(Color.green);
    g2.draw(new Line2D.Double(xbeg + 20, ybeg + 20, xend - 20, yend - 20)); 

    /* supply curve */

    g2.setStroke(stroke);
    g2.setColor(Color.blue);
    g2.draw(new Line2D.Double(xbeg + 20, yend - 20, xend - 20, ybeg + 20)); 

    /* Equilibrium Price and Quantity */

    g2.setStroke(dashed);
    g2.setColor(Color.red);
    g2.draw(new Line2D.Double(xbeg, ymiddle, xmiddle, ymiddle)); 
    g2.draw(new Line2D.Double(xmiddle, yend, xmiddle, ymiddle)); 

    /* drawString ( String str, x, y) */

    g2.setColor(Color.black);
    g2.setFont(font);
    g2.drawString(xlabel, xend-50, yend+15); 
    g2.drawString(ylabel, xbeg-40, ybeg+15); 
    g2.drawString(xlabel1, xmiddle-5, yend+15); 
    g2.drawString(ylabel1, xbeg-20, ymiddle+2); 
    g2.drawString(ldemand, xend-25, yend-30); 
    g2.drawString(lsupply, xend-18, ybeg+40); 

}

//  This part creates the increase in demand graph from the menu

if(lst.getSelectedIndex()==1)
{
    g2.setStroke(wide);

    g2.draw(new Line2D.Double(xbeg, yend , xend, yend));

    g2.draw(new Line2D.Double(xbeg, ybeg , xbeg, yend)); 

    /* demand curve 1 */

    g2.setStroke(stroke);
    g2.setColor(Color.green);
    g2.draw(new Line2D.Double(xbeg + 20, ybeg + 20, xend - 20, yend - 20)); 

    /* demand curve 2 */

    g2.setStroke(stroke);
    g2.setColor(Color.DARK_GRAY);
    g2.draw(new Line2D.Double(xbeg + 100, ybeg + 20, xend + 30, yend - 50)); 

    /* supply curve */

    g2.setStroke(stroke);
    g2.setColor(Color.blue);
    g2.draw(new Line2D.Double(xbeg + 20, yend - 20, xend - 20, ybeg + 20)); 

    /* Equilibrium Price and Quantity */

    g2.setStroke(dashed);
    g2.setColor(Color.red);
    g2.draw(new Line2D.Double(xbeg, ymiddle, xmiddle, ymiddle)); 
    g2.draw(new Line2D.Double(xmiddle, yend, xmiddle, ymiddle)); 

    /* New Equilibrium Price and Quantity */

    g2.setStroke(dashed);
    g2.setColor(Color.gray);
    g2.draw(new Line2D.Double(xbeg, ymiddle-40, xmiddle+40, ymiddle-40)); 
    g2.draw(new Line2D.Double(xmiddle+40, yend, xmiddle+40, ymiddle-40)); 

    /* drawString ( String str, x, y) */

    g2.setColor(Color.black);
    g2.setFont(font);
    g2.drawString(xlabel, xend-50, yend+15); 
    g2.drawString(ylabel, xbeg-40, ybeg+15); 
    g2.drawString(xlabel1, xmiddle-5, yend+15); 
    g2.drawString(ylabel1, xbeg-20, ymiddle+2); 
    g2.drawString(xlabel2, xmiddle+35, yend+15); 
    g2.drawString(ylabel2, xbeg-20, ymiddle-35); 
    g2.drawString(ldemand0, xend-25, yend-30); 
    g2.drawString(ldemand1, xend+10, yend-75);
    g2.drawString(lsupply, xend-18, ybeg+40); 

g2.setStroke(stroke);
g2.setFont(font3);
g2.setColor(Color.black);
g2.drawRect(xend+90, ybeg+90, 250, 250);
g.drawString("This figure shows a general model of ", xend+105, ybeg+105);
g.drawString("an increase in the demand for goods", xend+105, ybeg+117);
g.drawString("and services.", xend+105, ybeg+129);
g.drawString("Factors that increase demand include:", xend+105, ybeg+149);
g.drawString("* an increase in income,", xend+105, ybeg+166);
g.drawString("* an increase in the price of substitute", xend+105, ybeg+183);
g.drawString(" goods,", xend+105, ybeg+200);
g.drawString("* a decrease in the price of", xend+105, ybeg+217);
g.drawString(" complementary goods.", xend+105, ybeg+234);

}
}

public void itemStateChanged(ItemEvent arg0) {

this.repaint();

}
}