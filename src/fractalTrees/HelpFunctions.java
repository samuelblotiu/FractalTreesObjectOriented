package fractalTrees;

public class HelpFunctions {
    public static double LinearMap(double x, double amin, double amax, double bmin, double bmax){
        return((x - amin) / (amax - amin) * (bmax - bmin) + bmin);
    }

    public static double[] RandomArray(int N, double amin, double amax){
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Math.random() * (amax - amin) + amin;
        }
        return arr;
    }

    public static double[] RandomDistribution(double a, double b, int N){
        double l = (b-a) / N;
        double[] list = new double[N];

        for (int i = 0; i < N; i++){
            list[i] = i * l + Math.random() * l;
        }

        return list;
    }

    public static double[] RandomList(int N, double r){
        double[] list = new double[N];
        for (int i = 0; i < N; i++){
            list[i] = Math.random()*r;
        }
        return list;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}
