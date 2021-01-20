public class ChordMajor {


    public static double [] tone( double hz, double t) {

      int SAMPLING_RATE = 44100;
      int n = (int) (SAMPLING_RATE * t);
      double[] a = new double[n+1];
      for (int i = 0; i <= n; i++)
        a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);

      // System.out.println(a[2]);
      return a;
    }

    public static double [] superimpose (double[] a, double[] b, double[]c, double awt, double bwt, double cwt) {

      double[] o = new double [a.length];
      for (int i = 0; i < a.length; i++ )
        o[i] = a[i]*awt + b[i]*bwt + c[i]*cwt;

        // System.out.println(o[2]);
      return o;

    }

    // int hz = 440;

    public static void main (String args[]) {

      double hz = 440.0;
      int pitch =  Integer.parseInt(args[0]);
      double duration = Double.parseDouble(args[1]);
      double onehz = hz*Math.pow(2.0, pitch/12.0);
      double twohz = hz*Math.pow(2.0, (pitch+4)/12.0);
      double threehz = hz*Math.pow(2.0, (pitch+7)/12.0);
      System.out.println(onehz + " " + twohz + " " + threehz + " " );

      double[] one = tone(onehz, duration);
      double[] two = tone(twohz, duration);
      double[] three = tone(threehz, duration);

      double [] toplay = superimpose(one, two, three, 1/3.0, 1/3.0, 1/3.0);
      StdAudio.play(toplay);

      }




}
