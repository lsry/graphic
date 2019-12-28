package utils;

public class MyMath {
    public static int[] minMax(int... args) {
        int[] res = new int[]{args[0],args[0]};
        for (int i = 1;i < args.length;++i) {
            if (args[i] < res[0]) {
                res[0] = args[i];
            }
            if (args[i] > res[1]) {
                res[1] = args[i];
            }
        }
        return res;
    }
}