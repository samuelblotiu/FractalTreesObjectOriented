package fractalTrees;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.floor;
/*
Klasse, um effizient Hintergründe zu erzeugen.
 */
public class BackgroundCreator {
    /*
    Platziert die Sonne an der Stelle (x,y)
     */
    public static void PlaceSun(BufferedImage img, int x, int y) {
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setColor(new Color(255, 232, 124));
        g2d.fillOval(x - 250, y - 250, 500, 500);
        g2d.setColor(new Color(253, 208, 23));
        g2d.fillOval(x - 175, y - 175, 350, 350);
        g2d.setColor(new Color(240, 127, 0));
        g2d.fillOval(x - 100, y - 100, 200, 200);

    }

    /*
    Platziert die Sonne an einer zufälligen Stelle entlang hh
     */

    public static void PlaceRandomSun(BufferedImage img) {
        int rand = (int) (floor(Math.random() * 1600) + 200);

        PlaceSun(img, rand, hh(rand));
    }

    public static int hh(double x) {
        return (int) floor(750 + (x * (x - 2000)) / 2000);
    }

    public static double f(double x) {
        return (0.3 * Math.pow(x, 2) + 0.5);
    }

    public static double g(double x) {
        return (0.2 * (Math.log(Math.pow(x, 5) + 0.8)) + 0.3);
    }

    public static double h(double x) {
        return (0.2 * (Math.sqrt(x) + Math.pow(x, 2) - Math.pow(x, 3)));
    }

    public static double[] Coordinates(double[] pixels) {
        double[] coordinates = new double[2];
        double x = pixels[0] / 2000;
        double y = 1 - pixels[1] / 2000;
        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }




    //VERSION 1.2

    /*DIE 4 JAHRESZEITEN
     */

    public static void CreateSpringSky(BufferedImage img){
        Color color1 = new Color(81, 52, 46);
        Color color2 = new Color(163, 210, 237);
        Color color3 = new Color(214, 153, 181);
        Color color4 = new Color(242, 218, 232);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        if (color4 != null) {
                            img.setRGB(x, y, color4.getRGB());
                        }
                    }
                    if (yy <= f(xx)) {
                        if (color3 != null) {
                            img.setRGB(x, y, color3.getRGB());
                        }
                    }
                    if (yy <= g(xx)) {
                        if (color2 != null) {
                            img.setRGB(x, y, color2.getRGB());
                        }
                    }
                    if (yy <= h(xx)) {
                        if (color1 != null) {
                            img.setRGB(x, y, color1.getRGB());
                        }
                    }
                }
            }
        }
    }

    public static void CreateSummerSky(BufferedImage img){
        Color color1 = new Color(254, 203 ,139);
        Color color2 = new Color(151 ,191 ,203);
        Color color3 = new Color(255 ,140 ,140);
        Color color4 = new Color(247 ,188 ,172);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        if (color4 != null) {
                            img.setRGB(x, y, color4.getRGB());
                        }
                    }
                    if (yy <= f(xx)) {
                        if (color3 != null) {
                            img.setRGB(x, y, color3.getRGB());
                        }
                    }
                    if (yy <= g(xx)) {
                        if (color2 != null) {
                            img.setRGB(x, y, color2.getRGB());
                        }
                    }
                    if (yy <= h(xx)) {
                        if (color1 != null) {
                            img.setRGB(x, y, color1.getRGB());
                        }
                    }
                }
            }
        }
    }

    public static void CreateFallSky(BufferedImage img){

        Color color1 = new Color(153, 102, 85);
        Color color2 = new Color(204, 102, 51);
        Color color3 = new Color(204, 136, 68);
        Color color4 = new Color(170, 204, 204);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        if (color4 != null) {
                            img.setRGB(x, y, color4.getRGB());
                        }
                    }
                    if (yy <= f(xx)) {
                        if (color3 != null) {
                            img.setRGB(x, y, color3.getRGB());
                        }
                    }
                    if (yy <= g(xx)) {
                        if (color2 != null) {
                            img.setRGB(x, y, color2.getRGB());
                        }
                    }
                    if (yy <= h(xx)) {
                        if (color1 != null) {
                            img.setRGB(x, y, color1.getRGB());
                        }
                    }
                }
            }
        }
    }

    public static void CreateWinterSky(BufferedImage img){

        Color color1 = new Color(128, 166, 206);
        Color color2 = new Color(179, 218, 241);
        Color color3 = new Color(132, 165, 184);
        Color color4 = new Color(66, 104, 124);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        if (color4 != null) {
                            img.setRGB(x, y, color4.getRGB());
                        }
                    }
                    if (yy <= f(xx)) {
                        if (color3 != null) {
                            img.setRGB(x, y, color3.getRGB());
                        }
                    }
                    if (yy <= g(xx)) {
                        if (color2 != null) {
                            img.setRGB(x, y, color2.getRGB());
                        }
                    }
                    if (yy <= h(xx)) {
                        if (color1 != null) {
                            img.setRGB(x, y, color1.getRGB());
                        }
                    }
                }
            }
        }
    }











    //VERSION 1.1

    public static void CreateBackground(BufferedImage img, int k) {
        CreateSky(img, k);
        AddClouds(img,255,255,255);
        PlaceRandomSun(img);
        Graphics2D g = (Graphics2D) img.getGraphics();
        DrawRandomBirds(g);
        AddClouds(img,255,255,255);
        DrawRandomBirds(g);

    }

    public static void CreateSky(BufferedImage img, int k) {
        Color color1 = null;
        Color color2 = null;
        Color color3 = null;
        Color color4 = null;
        if (k == 1) {
            color1 = new Color(8, 96, 168);
            color2 = new Color(80, 133, 188);
            color3 = new Color(128, 166, 206);
            color4 = new Color(191, 209, 229);
        } else if (k == 2) {
            color1 = new Color(255, 135, 0);
            color2 = new Color(254, 179, 37);
            color3 = new Color(254, 196, 54);
            color4 = new Color(254, 227, 128);
        } else if (k == 3) {
            color1 = new Color(65, 170, 76);
            color2 = new Color(115, 195, 108);
            color3 = new Color(166, 218, 149);
            color4 = new Color(204, 235, 197);

        } else if (k == 4) {
            color1 = new Color(131, 55, 127);
            color2 = new Color(160, 99, 156);
            color3 = new Color(193, 153, 190);
            color4 = new Color(217, 204, 216);

        }

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        if (color4 != null) {
                            img.setRGB(x, y, color4.getRGB());
                        }
                    }
                    if (yy <= f(xx)) {
                        if (color3 != null) {
                            img.setRGB(x, y, color3.getRGB());
                        }
                    }
                    if (yy <= g(xx)) {
                        if (color2 != null) {
                            img.setRGB(x, y, color2.getRGB());
                        }
                    }
                    if (yy <= h(xx)) {
                        if (color1 != null) {
                            img.setRGB(x, y, color1.getRGB());
                        }
                    }
                }
            }
        }
    }

    public static void CreateNightSky(BufferedImage img) {
        CreateNight(img);
        AddClouds(img,255,255,255);
        PlaceRandomMoon(img);
        AddClouds(img,255,255,255);
    }

    public static void CreateNight(BufferedImage img) {
        Color color1 = new Color(128, 166, 206);
        Color color2 = new Color(40, 62, 102);
        Color color3 = new Color(24, 41, 88);
        Color color4 = new Color(9, 20, 70);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        img.setRGB(x, y, color4.getRGB());
                    }
                    if (yy <= f(xx)) {
                        img.setRGB(x, y, color3.getRGB());
                    }
                    if (yy <= g(xx)) {
                        img.setRGB(x, y, color2.getRGB());
                    }
                    if (yy <= h(xx)) {
                        img.setRGB(x, y, color1.getRGB());
                    }

                    double rand = Math.random();

                    if (rand <= 0.0008 && y <= 800) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    }
                    if (rand <= 0.0005 && 800 < y && y <= 1000) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    }
                    if (rand <= 0.00025 && 1000 < y && y <= 1200) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    }
                    if (rand <= 0.00005 && 1200 < y && y <= 1300) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    }


                }
            }
        }

    }

    public static void PlaceMoon(BufferedImage img, int x, int y) {
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setColor(new Color(244, 238, 225));
        g2d.fillOval(x - 250, y - 250, 500, 500);
        g2d.setColor(new Color(210, 220, 220));
        g2d.fillOval(x - 170, y - 220, 200, 200);
        g2d.fillOval(x + 50, y + 100, 100, 100);
        g2d.fillOval(x - 50, y + 80, 80, 80);
        g2d.fillOval(x + 120, y - 20, 100, 100);
        g2d.fillOval(x + 20, y - 20, 50, 50);
    }

    public static void PlaceRandomMoon(BufferedImage img) {
        int rand = (int) (floor(Math.random() * 1600) + 200);

        PlaceMoon(img, rand, hh(rand));
    }

    public static void PlaceCloud1(BufferedImage img, int x, int y, int r, int g, int b) {
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setColor(new Color(r,g,b));
        g2d.fillOval(x - 200, y - 100, 400, 200);

        g2d.fillOval(x + 200, y, 100, 100);

        g2d.fillOval(x + 140, y, 100, 100);

        g2d.fillOval(x + 120, y - 80, 150, 150);

        g2d.fillOval(x + 50, y - 10, 200, 200);
        g2d.fillOval(x - 30, y - 20, 150, 160);
        g2d.fillOval(x - 100, y - 150, 200, 200);
        g2d.fillOval(x + 120, y - 80, 150, 150);
    }

    public static void PlaceCloud2(BufferedImage img, int x, int y, int r, int g, int b) {
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setColor(new Color(r,g,b));

        g2d.setColor(new Color(255, 255, 255));
        g2d.fillOval(x - 300, y - 150, 600, 300);


        g2d.fillOval(x - 200, y, 100, 100);

        g2d.fillOval(x - 240, y, 200, 200);

        g2d.fillOval(x + 170, y - 80, 250, 250);

        g2d.fillOval(x + 50, y + 10, 100, 100);
        g2d.fillOval(x - 30, y - 100, 150, 160);
        g2d.fillOval(x - 100, y - 250, 200, 200);
        g2d.fillOval(x + 120, y + 80, 150, 150);
        g2d.fillOval(x - 200, y - 200, 150, 150);


    }

    public static void PlaceCloud3Prime(BufferedImage img, int x, int y, int r, int g, int b) {
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setColor(new Color(r,g,b));
        g2d.fillOval(x - 200, y - 100, 400, 200);
        g2d.fillOval(x - 100, y - 150, 200, 200);
        g2d.fillOval(x - 100, y, 200, 200);
        g2d.fillOval(x - 170, y, 200, 200);
        g2d.fillOval(x + 100, y - 50, 200, 200);
    }

    public static void PlaceCloud3(BufferedImage img, int x, int y, int r, int g, int b) {
        PlaceCloud3Prime(img, x, y,r,g,b);
        PlaceCloud3Prime(img, x + 50, y - 20,r,g,b);
    }

    public static void AddClouds(BufferedImage img, int r, int g, int b) {
        int i1 = ThreadLocalRandom.current().nextInt(0, 3);
        int i2 = ThreadLocalRandom.current().nextInt(0, 3);
        int i3 = ThreadLocalRandom.current().nextInt(0, 3);

        for (int i = 0; i < i1; i++) {
            PlaceCloud1(img, (int) (Math.random() * 2000), 10, r, g, b);
        }
        for (int i = 0; i < i2; i++) {
            PlaceCloud2(img, (int) (Math.random() * 2000), 300, r, g, b);
        }

        for (int i = 0; i < i3; i++) {
            PlaceCloud3(img, (int) (Math.random() * 2000), 500, r, g, b);
        }

    }

    public static void AddFallClouds(BufferedImage img){

        PlaceCloud1(img, 0, 43, 160, 160, 160);
        //PlaceCloud1(img, 100, 100);
        //PlaceCloud1(img, 200, 50);
        //PlaceCloud1(img, 300, 50);
        PlaceCloud3(img, 400, 54,211,211,211);
        //PlaceCloud1(img, 500, 50);
        //PlaceCloud1(img, 600, 50);
        //PlaceCloud1(img, 700, 50);
        //PlaceCloud1(img, 800, 50);
        PlaceCloud1(img, 900, 45, 192, 192, 192);
        //PlaceCloud1(img, 1000, 50);
        //PlaceCloud1(img, 1100, 50);
        PlaceCloud3(img, 1200, 53,169, 169, 169);
        //PlaceCloud1(img, 1300, 50);
        //PlaceCloud1(img, 1400, 50);
        PlaceCloud1(img, 1500, 57,220,220,220);
        //PlaceCloud1(img, 1600, 50);
        PlaceCloud3(img, 1700, 43,160,160,160);
        //PlaceCloud1(img, 1800, 50);
        //PlaceCloud1(img, 1900, 50);
        PlaceCloud1(img, 2000, 44,220,220,220);

    }

    public static void DrawBird(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.fillOval(x - 4, y - 4, 8, 8);
        g2d.drawLine(x, y, x - 20, y - 10);
        g2d.drawLine(x, y, x + 20, y - 10);
        g2d.drawLine(x - 20, y - 10, x - 40, y - 5);
        g2d.drawLine(x + 20, y - 10, x + 40, y - 5);
    }

    public static void DrawRandomBird(Graphics2D g) {
        int x = (int) (Math.random() * 1800 + 100);
        int y = (int) (1000 - Math.random() * 900);
        DrawBird(g, x, y);
    }

    public static void DrawRandomBirds(Graphics2D g) {
        int N = ThreadLocalRandom.current().nextInt(0, 21);
        for (int i = 0; i < N; i++) {
            DrawRandomBird(g);
        }

    }

    public static void DrawSnowflake(BufferedImage img, int x, int y, int size, int level) {
        for (int a = 0; a < 360; a += 60) {
            double rad = a * Math.PI / 180;
            int x2 = (int) (x + Math.cos(rad) * size);
            int y2 = (int) (y + Math.sin(rad) * size);
            Graphics2D g = (Graphics2D) img.getGraphics();
            g.drawLine(x, y, x2, y2);
            if (level > 0) {
                DrawSnowflake(img, x2, y2, size / 3, level - 1);
            }
        }
    }

    public static void DrawRandomSnowflake(BufferedImage img, int x, int y) {
        int width = img.getWidth();
        int height = img.getHeight();
        int s = (int) (Math.random() * 20 + 10);

        double r = Math.random();

        if (r < 0.000024 && y < 800) {
            DrawSnowflake(img, x, y, s, 2);
        }
        if (r < 0.000012 && 800 < y && y < 1100) {
            DrawSnowflake(img, x, y, s, 2);
        }
        if (r < 0.000006 && 1100 < y && y < 1400) {
            DrawSnowflake(img, x, y, s, 2);
        }
        if (r < 0.000003 && 1400 < y) {
            DrawSnowflake(img, x, y, s, 2);
        }
    }

    public static void CreateWinterNoSnowflakes(BufferedImage img) {
        Color color1 = new Color(128, 166, 206);
        Color color2 = new Color(179, 218, 241);
        Color color3 = new Color(132, 165, 184);
        Color color4 = new Color(66, 104, 124);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        img.setRGB(x, y, color4.getRGB());
                    }
                    if (yy <= f(xx)) {
                        img.setRGB(x, y, color3.getRGB());
                    }
                    if (yy <= g(xx)) {
                        img.setRGB(x, y, color2.getRGB());
                    }
                    if (yy <= h(xx)) {
                        img.setRGB(x, y, color1.getRGB());
                    }

                }
            }
        }
    }

    public static void CreateWinter(BufferedImage img) {
        Color color1 = new Color(128, 166, 206);
        Color color2 = new Color(179, 218, 241);
        Color color3 = new Color(132, 165, 184);
        Color color4 = new Color(66, 104, 124);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        img.setRGB(x, y, color4.getRGB());
                    }
                    if (yy <= f(xx)) {
                        img.setRGB(x, y, color3.getRGB());
                    }
                    if (yy <= g(xx)) {
                        img.setRGB(x, y, color2.getRGB());
                    }
                    if (yy <= h(xx)) {
                        img.setRGB(x, y, color1.getRGB());
                    }

                }
            }
        }
        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    DrawRandomSnowflake(img, x, y);
                }
            }
        }


    }

    public static void CreateFall(BufferedImage img) {
        //Baumfarbe: Color(1, 50, 32)
        Color color1 = new Color(212, 41, 0);
        Color color2 = new Color(232, 79, 11);
        Color color3 = new Color(255, 115, 38);
        Color color4 = new Color(255, 133, 63);

        for (int y = 0; y < 2000; y++) {
            for (int x = 0; x < 2000; x++) {
                {
                    double[] pixels = new double[2];
                    pixels[0] = x;
                    pixels[1] = y;
                    double[] coordinates = Coordinates(pixels);
                    double xx = coordinates[0];
                    double yy = coordinates[1];

                    if (f(xx) <= yy) {
                        img.setRGB(x, y, color4.getRGB());
                    }
                    if (yy <= f(xx)) {
                        img.setRGB(x, y, color3.getRGB());
                    }
                    if (yy <= g(xx)) {
                        img.setRGB(x, y, color2.getRGB());
                    }
                    if (yy <= h(xx)) {
                        img.setRGB(x, y, color1.getRGB());
                    }
                }
            }
        }
        for (int y = 2000; y > -1; y--){
            for (int x = 0; x < 2000; x++){
                double r = Math.random();
                if (r <= 0.00003){
                    int l = (int) (Math.random()* 50 + 10);
                    DrawRaindrop(img, x, y, l);
                }
            }

        }
        AddFallClouds(img);
    }


    public static void DrawRaindrop(BufferedImage img, int x, int y, int l){
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.setColor(new Color(6, 77, 135));
        g.setStroke(new BasicStroke(5));
        g.drawLine(x, y, x, y+l);
    }



    public static void main(String[] args) throws IOException {
        BufferedImage img = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        CreateWinterSky(img);
        DrawRaindrop(img, 1000, 1000, 100);
        ImageIO.write(img, "PNG", new File(
                "Winter.png"));

    }



}
