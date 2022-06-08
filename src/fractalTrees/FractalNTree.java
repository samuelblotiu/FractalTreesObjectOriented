package fractalTrees;

import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.floor;

/*
Klasse eines FRAKTALEN N-BAUMS. Ein FRAKTALER N-BAUM besteht aus folgenden Daten:
- Baumstamm = Branch
- Anzahl der Äste = N
- Liste mit Winkeln \in [0, 2\pi], die die Winkel der Baumstämme der Kinder festlegt
- Liste mit Längen \in (0,1), die Längenverhältnisse der Kinder zum "Mutterast" festlegt
- Baumhöhe h \in \N, Anzahl der Generationen
- Liste von Kindern, jedes von ihnen ein FRAKTALER N-BAUM mit den selben Daten aber h--.
 */

public class FractalNTree {
    public Branch rootbranch;
    public int N;
    public double[] splitangles;
    public double[] splitrates;
    public int height;
    public FractalNTree[] children;

    public FractalNTree(Branch branch, int n, double[] angles, double[] rates, int h) {
        if (h > 0) {
            rootbranch = branch;
            N = n;
            splitangles = angles;
            splitrates = rates;
            height = h;
            int X = (int) floor(branch.rootx - branch.length * Math.sin(branch.angle));
            int Y = (int) floor(branch.rooty - branch.length * Math.cos(branch.angle));
            children = new FractalNTree[n];

            for (int i = 0; i < n; i++) {
                Branch rootbranch = new Branch(X, Y, branch.length * rates[i], branch.angle + angles[i]);
                FractalNTree f = new FractalNTree(rootbranch, n, angles, rates, h - 1);
                children[i] = f;
            }
        }
    }
    /*
    Methode, die checkt, ob Baum keine Kinder hat ==> Wichtig für Rekursionsprozesse
     */
    public boolean isLeaf(){
        return this.height == 1;
    }

    /*
    Malt den FRAKZTALEN N-BAUM uf die Grafikkomponente g in Farbe rgb(R,G,B).
     */

    public void drawFractalNTree(Graphics g, int R, int G, int B){
        g.setColor(new Color(R, G, B));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(1000, 2000, 1000, 1600));
        if(rootbranch == null){
        }
        else{
            if (isLeaf()) {
                rootbranch.drawBranch(g);
                }
            else{
                rootbranch.drawBranch(g);
                for (int i = 0; i < N; i++){
                    children[i].drawFractalNTree(g, R, G, B);
                }
            }
        }
    }



    /*
    Ein REGULÄRER N-BAUM ist ein FRAKTALER N-BAUM, bei dem die Winkel gleichmäßig im Intervall [-maxangle, maxangle] angelegt sind.
     */
    public static FractalNTree RegularNTree(int N, double rate, double maxangle,  int h){
        Branch root = new Branch(1000, 2000, 400, 0);

        double[] angles = new double[N];
        double[] rates = new double[N];

        for (int i = 0; i < N; i++){
            angles[i] = HelpFunctions.LinearMap(i, 0, N-1, -maxangle, maxangle);
            rates[i] = rate;
        }

        return new FractalNTree(root, N, angles, rates, h);

    }

    /*
    Generiert ZUFÄLLIGEN N-BAUM
     */

    public static FractalNTree RandomNTree(int N, int height){
        Branch root = new Branch(1000, 2000, 400, 0);
        double[] angles = HelpFunctions.RandomArray(N, -Math.PI / 3, Math.PI / 3);
        double[] rates = HelpFunctions.RandomList(N, 0.8);
        FractalNTree tree = new FractalNTree(root, N, angles, rates, height);
        return tree;
    }
    public static void main(String[] args) {
    }

}
