package fractalTrees;

import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.floor;
/*
Klasse für einen einzelnen Ast mit Wurzelkoordinaten rootx, rooty, Länge l und Winkel zu {x = 0} angle gemessen in Positiver Orientierung und Bogenmaß
 */
public class Branch {

    public int rootx;
    public int  rooty;
    public double length;
    public double angle;

    public Branch(int x, int y, double l, double a){
        rootx = x;
        rooty = y;
        length = l;
        angle = a;
    }


    /*
    Gibt Koordinaten der Astspitze zurück
    public int getTipx(){
        return (int) floor(this.rootx - this.length*Math.sin(this.angle));
    }

    public int getTipy(){
        return (int) floor(this.rooty - this.length*Math.cos(this.angle));
    }*/


    /*
    Malt den Ast
     */

    public void drawBranch(Graphics g){
        int X = (int) floor(this.rootx - this.length*Math.sin(this.angle));
        int Y = (int) floor(this.rooty - this.length*Math.cos(this.angle));

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(this.rootx, this.rooty, X, Y));    }





    public static void main(String[] args) {
    }

}
