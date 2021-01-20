public class Chromatic440
{
    public static void main(final String[] args) {
        int SAMPLING_RATE = 44100;
        double duration = Double.parseDouble(args[0]);
        double hz = 440.0;

        for (int i = 1; i <= 13; ++i) {
            final int n = (int)(SAMPLING_RATE * duration);
            final double[] a = new double[n + 1];
            for (int j = 0; j <= n; ++j) {
                a[j] = Math.sin(2 * Math.PI * j * (hz/SAMPLING_RATE));
            }

          System.out.println(hz + " " + i);
          StdAudio.play(a);
          hz *= Math.pow(2.0, 1/12.0);

        }
    }
}
