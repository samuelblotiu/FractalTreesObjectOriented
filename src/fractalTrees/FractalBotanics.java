package fractalTrees;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/*
Mit dieser Klasse werden Bilder erzeugt.
 */
public class FractalBotanics{

    public FractalNTree tree;

    public FractalBotanics(FractalNTree t){
        tree = t;

    }
 /*
 Speichert ein Bild des FRAKTALEN N-BAUMS t im Schema k im Folder foldername ab
  */
    public static void SaveFractalNSummerTree(FractalNTree t, int k, String foldername) throws IOException{
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateBackground(image, k);
        Graphics g =  image.createGraphics();
        t.drawFractalNTree(g, 0, 0, 0);
        StringBuilder filename = new StringBuilder();
        filename.append("Summer|");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitrates[i], 3));
            filename.append(",");
        }
        ImageIO.write(image, "PNG", new File(
                "/Users/samuelblotiu/Desktop/FractalTreesObjectOriented/" + foldername + "/" + filename + ".png"));

    }

    /*
 Speichert ein Bild des FRAKTALEN N-BAUMS t bei Nacht im Folder foldername ab
  */
    public static void SaveFractalNNightTree(FractalNTree t,  String foldername) throws IOException{
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateNightSky(image);
        Graphics g = image.createGraphics();

        t.drawFractalNTree(g, 255, 255, 255);
        StringBuilder filename = new StringBuilder();
        filename.append("Night|");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitrates[i], 3));
            filename.append(",");
        }
        ImageIO.write(image, "PNG", new File(
                "/Users/samuelblotiu/Desktop/FractalTreesObjectOriented/" + foldername + "/" + filename + ".png"));

    }

    /*
 Speichert ein Bild des FRAKTALEN N-BAUMS t im Winter im Folder foldername ab
  */
    public static void SaveFractalNWinterTree(FractalNTree t,  String foldername) throws IOException{
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateWinter(image);
        Graphics g = image.createGraphics();

        t.drawFractalNTree(g, 0, 0, 0);
        StringBuilder filename = new StringBuilder();
        filename.append("Winter|");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitrates[i], 3));
            filename.append(",");
        }
        ImageIO.write(image, "PNG", new File(
                "/Users/samuelblotiu/Desktop/FractalTreesObjectOriented/" + foldername + "/" + filename + ".png"));

    }

    /*
 Speichert ein Bild des FRAKTALEN N-BAUMS t im Herbst im Folder foldername ab
  */

    public static void SaveFractalNFallTree(FractalNTree t,  String foldername) throws IOException{
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateFall(image);
        Graphics g = image.createGraphics();

        t.drawFractalNTree(g, 1, 50, 32);
        StringBuilder filename = new StringBuilder();
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitrates[i], 3));
            filename.append(",");
        }
        ImageIO.write(image, "PNG", new File(
                "/Users/samuelblotiu/Desktop/FractalTreesObjectOriented/" + foldername + "/" + filename + ".png"));

    }

     /*
 Speichert ein Bild des FRAKTALEN N-BAUMS t in Raw im Folder foldername ab
  */

    public static void SaveRawFractalNTree(FractalNTree t, String foldername) throws IOException{
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        Graphics g =  image.createGraphics();
        g.fillRect(0,0,2000, 2000);

        t.drawFractalNTree(g, 0, 0, 0);
        StringBuilder filename = new StringBuilder();
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t.N; i++){
            filename.append(HelpFunctions.round(t.splitrates[i], 3));
            filename.append(",");
        }
        ImageIO.write(image, "PNG", new File(
                "/Users/samuelblotiu/Desktop/FractalTreesObjectOriented/" + foldername + "/" + filename + ".png"));

    }


    /* Speichert einen REGULÄREN N-BAUM im Ordner foldername ab
     */
    public static void SaveRegularNSummerTree(int N, double rate,double maxangle, int height, int k, String foldername) throws IOException{

        FractalNTree t = FractalNTree.RegularNTree(N, rate, maxangle, height);

        SaveFractalNSummerTree(t, k, foldername);

    }
    /*
Generiert zu der Liste NList für alle i pics FRAKTALEN Nlist[i]-BAUM in allen Schemen und speichert diese im Ordner foldername ab.
 */
    public static void GenerateRandomNSummerTrees(int pics, int[] NList, int k) throws IOException {
        for (int t= 0; t < pics; t++){
            Branch root = new Branch(1000, 2000, 400, 0);
            for (int N : NList) {
                int H = ThreadLocalRandom.current().nextInt(6, 11);
                FractalNTree tree = FractalNTree.RandomNTree(N, H);
                SaveFractalNSummerTree(tree, k, "RandomNSummerTrees");
            }
        }
    }

    public static void GenerateRawRandomNTrees(int pics, int[] NList) throws IOException {
        for (int t= 0; t < pics; t++){
            Branch root = new Branch(1000, 2000, 400, 0);
            for (int N : NList) {
                int H = ThreadLocalRandom.current().nextInt(6, 11);
                FractalNTree tree = FractalNTree.RandomNTree(N, H);
                SaveRawFractalNTree(tree, "RawRandomNTrees");
            }
        }
    }

    /*
Generiert zu der Liste NList für alle i pics FRAKTALEN Nlist[i]-BAUM bei Nacht und speichert diese im Ordner foldername ab.
 */

    public static void GenerateRandomNNightTrees(int pics, int[] NList) throws IOException {
        for (int t= 0; t < pics; t++){
            Branch root = new Branch(1000, 2000, 400, 0);
            for (int N : NList) {
                double[] angles = HelpFunctions.RandomArray(N, -Math.PI / 3, Math.PI / 3);
                double[] rates = HelpFunctions.RandomList(N, 0.8);
                FractalNTree tree = new FractalNTree(root, N, angles, rates, 10);
                SaveFractalNNightTree(tree, "RandomNNightTrees");
            }
        }
    }

    /*
Generiert zu der Liste NList für alle i pics FRAKTALEN Nlist[i]-BAUM im Winter und speichert diese im Ordner foldername ab.
 */
    public static void GenerateRandomNWinterTrees(int pics, int[] NList) throws IOException {
        for (int t= 0; t < pics; t++){
            Branch root = new Branch(1000, 2000, 400, 0);
            for (int N : NList) {
                double[] angles = HelpFunctions.RandomArray(N, -Math.PI / 3, Math.PI / 3);
                double[] rates = HelpFunctions.RandomList(N, 0.8);
                FractalNTree tree = new FractalNTree(root, N, angles, rates, 10);
                SaveFractalNWinterTree(tree, "RandomNWinterTrees");
            }
        }
    }

    public static void GenerateRandomNFallTrees(int pics, int[] NList) throws IOException{
        for (int t= 0; t < pics; t++){
            Branch root = new Branch(1000, 2000, 400, 0);
            for (int N : NList) {
                double[] angles = HelpFunctions.RandomArray(N, -Math.PI / 3, Math.PI / 3);
                double[] rates = HelpFunctions.RandomList(N, 0.8);
                FractalNTree tree = new FractalNTree(root, N, angles, rates, 10);
                SaveFractalNFallTree(tree, "RandomNFallTrees");
            }
        }
    }


    /*
    Führt den FRAKTALEN N-BAUM t1 als GIF in den FRAKTALEN N-BAUM t2 um
     */

    public static void TreeMorphism(FractalNTree t1, FractalNTree t2, int pics, int k) throws IOException{
        BufferedImage[] array = new BufferedImage[2 * pics];

        StringBuilder filename = new StringBuilder();
        filename.append("Gifs/");
        filename.append(k + "|");
        for (int i = 0; i < t1.N; i++){

            filename.append(HelpFunctions.round(t1.splitangles[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t1.N; i++){
            filename.append(HelpFunctions.round(t1.splitrates[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitrates[i], 3));
            filename.append(",");
        }
        filename.append(".gif");
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateBackground(image, k);
        //ImageIO.write(image, "PNG", new File("Gifs/background.png"));
        for (int t = 0; t < pics; t++){
            BufferedImage img = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(image, 0, 0, null);
            double[] lengths = new double[t1.splitrates.length];
            double[] angles = new double[t1.splitangles.length];
            for (int i = 0; i < t1.N; i++) {
                lengths[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitrates[i], t2.splitrates[i]);
                angles[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitangles[i], t2.splitangles[i]);
            }
            FractalNTree tt = new FractalNTree(t1.rootbranch, t1.N, angles, lengths, t1.height);
            tt.drawFractalNTree(g, 0, 0, 0);
            array[t] = img;
            array[2*pics - t - 1] = img;


        }

        Giffer.generateFromBI(array,"" + filename, 3, true);
    }

    public static void TreeMorphismNight(FractalNTree t1, FractalNTree t2, int pics) throws IOException{
        BufferedImage[] array = new BufferedImage[2 * pics];

        StringBuilder filename = new StringBuilder();
        filename.append("Gifs/");
        filename.append("Night|");
        for (int i = 0; i < t1.N; i++){
            filename.append(HelpFunctions.round(t1.splitangles[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t1.N; i++){
            filename.append(HelpFunctions.round(t1.splitrates[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitrates[i], 3));
            filename.append(",");
        }
        filename.append(".gif");
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateNightSky(image);
        //ImageIO.write(image, "PNG", new File("Gifs/background.png"));
        for (int t = 0; t < pics; t++){
            BufferedImage img = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(image, 0, 0, null);
            double[] lengths = new double[t1.splitrates.length];
            double[] angles = new double[t1.splitangles.length];
            for (int i = 0; i < t1.N; i++) {
                lengths[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitrates[i], t2.splitrates[i]);
                angles[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitangles[i], t2.splitangles[i]);
            }
            FractalNTree tt = new FractalNTree(t1.rootbranch, t1.N, angles, lengths, t1.height);
            tt.drawFractalNTree(g, 255, 255, 255);
            array[t] = img;
            array[2*pics - t - 1] = img;


        }

        Giffer.generateFromBI(array,"" + filename, 3, true);
    }

    public static void TreeMorphismWinter(FractalNTree t1, FractalNTree t2, int pics) throws IOException{
        BufferedImage[] array = new BufferedImage[2 * pics];

        StringBuilder filename = new StringBuilder();
        filename.append("Gifs/");
        filename.append("Winter|");
        for (int i = 0; i < t1.N; i++){
            filename.append(HelpFunctions.round(t1.splitangles[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < t1.N; i++){
            filename.append(HelpFunctions.round(t1.splitrates[i], 3));
            filename.append("-" + HelpFunctions.round(t2.splitrates[i], 3));
            filename.append(",");
        }
        filename.append(".gif");
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        BackgroundCreator.CreateWinter(image);
        //ImageIO.write(image, "PNG", new File("Gifs/background.png"));
        for (int t = 0; t < pics; t++){
            BufferedImage img = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(image, 0, 0, null);
            double[] lengths = new double[t1.splitrates.length];
            double[] angles = new double[t1.splitangles.length];
            for (int i = 0; i < t1.N; i++) {
                lengths[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitrates[i], t2.splitrates[i]);
                angles[i] = HelpFunctions.LinearMap(t, 0, pics, t1.splitangles[i], t2.splitangles[i]);
            }
            FractalNTree tt = new FractalNTree(t1.rootbranch, t1.N, angles, lengths, t1.height);
            tt.drawFractalNTree(g, 255, 255, 255);
            array[t] = img;
            array[2*pics - t - 1] = img;


        }

        Giffer.generateFromBI(array,"" + filename, 3, true);
    }

    public static void SnowFallGif(FractalNTree T, int pics) throws IOException{
        BufferedImage[] array = new BufferedImage[pics];

        StringBuilder filename = new StringBuilder();
        filename.append("Gifs/SnowFallGifs/");
        filename.append("SnowFall|");
        for (int i = 0; i < T.N; i++){
            filename.append(HelpFunctions.round(T.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < T.N; i++){
            filename.append(HelpFunctions.round(T.splitrates[i], 3));
            filename.append(",");
        }


        int N = ThreadLocalRandom.current().nextInt(10, 21);

        int[] SnowflakeCoordinatesandSize = new int[3 * N];

        for (int i = 0; i < 3*N; i+= 3){
            int lambda_i = (int) (Math.random()*2000);
            int eta_i = (int) (Math.random() * 900);
            SnowflakeCoordinatesandSize[i] = lambda_i;
            SnowflakeCoordinatesandSize[i + 1] = eta_i;
            SnowflakeCoordinatesandSize[i + 2] = (int) (Math.random() * 20 + 10);;
        }

        for (int t = 0; t < pics; t++) {
            BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
            BackgroundCreator.CreateWinterNoSnowflakes(image);
            Graphics g = image.getGraphics();
            int tt = (int) (HelpFunctions.LinearMap(t, 0, pics, 0, 1000));
            for (int i = 0; i < 3*N; i+= 3) {
                BackgroundCreator.DrawSnowflake(image, SnowflakeCoordinatesandSize[i], (SnowflakeCoordinatesandSize[i+1] + +tt+ 1000) % 2000,SnowflakeCoordinatesandSize[i+2], 2);
                BackgroundCreator.DrawSnowflake(image, SnowflakeCoordinatesandSize[i], SnowflakeCoordinatesandSize[i+1]+tt,SnowflakeCoordinatesandSize[i+2], 2);
                T.drawFractalNTree(g, 0,0,0);
            }
            array[t] = image;
        }

        Giffer.generateFromBI(array, ""+filename, 3, true);

    }

    public static void FallRainGif(FractalNTree T, int pics) throws IOException{
        BufferedImage[] array = new BufferedImage[pics];

        StringBuilder filename = new StringBuilder();
        filename.append("Gifs/FallRainGifs/");
        filename.append("FallRain|");
        for (int i = 0; i < T.N; i++){
            filename.append(HelpFunctions.round(T.splitangles[i], 3));
            filename.append(",");
        }
        filename.append("||");
        for (int i = 0; i < T.N; i++){
            filename.append(HelpFunctions.round(T.splitrates[i], 3));
            filename.append(",");
        }
        filename.append(".gif");


        int N = ThreadLocalRandom.current().nextInt(20, 31);

        int[] SnowflakeCoordinatesandSize = new int[3 * N];

        for (int i = 0; i < 3*N; i+= 3){
            int lambda_i = (int) (Math.random()*2000);
            int eta_i = (int) (Math.random() * 500);
            SnowflakeCoordinatesandSize[i] = lambda_i;
            SnowflakeCoordinatesandSize[i + 1] = eta_i;
            SnowflakeCoordinatesandSize[i + 2] = (int) (Math.random() * 50 + 10);;
        }

        for (int t = 0; t < pics; t++) {
            BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
            BackgroundCreator.CreateFall(image);
            Graphics g = image.getGraphics();
            int tt = (int) (HelpFunctions.LinearMap(t, 0, pics, 0, 1000));
            for (int i = 0; i < 3*N; i+= 3) {
                BackgroundCreator.DrawRaindrop(image, SnowflakeCoordinatesandSize[i], SnowflakeCoordinatesandSize[i+1]+tt,SnowflakeCoordinatesandSize[i+2]);
                BackgroundCreator.DrawRaindrop(image, SnowflakeCoordinatesandSize[i], (SnowflakeCoordinatesandSize[i+1] + +tt+ 500) % 2000,SnowflakeCoordinatesandSize[i+2]);
                BackgroundCreator.DrawRaindrop(image, SnowflakeCoordinatesandSize[i], (SnowflakeCoordinatesandSize[i+1] + +tt+ 1000) % 2000,SnowflakeCoordinatesandSize[i+2]);
                BackgroundCreator.DrawRaindrop(image, SnowflakeCoordinatesandSize[i], (SnowflakeCoordinatesandSize[i+1] + +tt+ 1500) % 2000,SnowflakeCoordinatesandSize[i+2]);
                T.drawFractalNTree(g, 1, 50, 32);
            }
            BackgroundCreator.AddFallClouds(image);
            array[t] = image;
        }

        Giffer.generateFromBI(array, ""+filename, 3, true);

    }

    public static void GenerateRandomSnowFallGifs(int gifs) throws IOException{
        for (int i = 0; i < gifs; i++){
            int N = ThreadLocalRandom.current().nextInt(3, 6);
            int H = ThreadLocalRandom.current().nextInt(5,10);
            FractalNTree t = FractalNTree.RandomNTree(N, H);
            SnowFallGif(t, 100);
        }
    }

    public static void GenerateRandomFallRainGifs(int gifs) throws IOException{
        for (int i = 0; i < gifs; i++){
            int N = ThreadLocalRandom.current().nextInt(3, 6);
            int H = ThreadLocalRandom.current().nextInt(5,10);
            FractalNTree t = FractalNTree.RandomNTree(N, H);
            FallRainGif(t, 25);
        }
    }

    public static void main(String[] args) throws IOException {

        int[] list = {3,4,5};
        GenerateRandomNSummerTrees(50, list, 1);
        GenerateRandomNSummerTrees(50, list, 2);
        GenerateRandomNSummerTrees(50, list, 3);
        GenerateRandomNSummerTrees(50, list, 4);

        GenerateRawRandomNTrees(50, list);

        GenerateRandomNNightTrees(50, list);

        GenerateRandomNFallTrees(50, list);

        GenerateRandomNWinterTrees(50, list);


    }
}
