public class AllChords.java {

  public static String getNoteName(int pitch) {

    String [] notes = { "A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab"};
    int startpitch = pitch;
    while (startpitch < 0) startpitch += 12;

    int index = startpitch % 12;

    return notes[index];
   

  }

  public static int getNoteNum(String note) {

    String [] notes = { "A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab"};

    int result = 0;
    for (int i=0; i<notes.length; i++) {
      if (notes[i].contains(note)) {result = i; break;};
    }
    return result;

  }


    public static double [] tone( double hz, double t) {

      int SAMPLING_RATE = 44100;
      int n = (int) (SAMPLING_RATE * t);
      double[] a = new double[n+1];
      for (int i = 0; i <= n; i++)
        a[i] = Math.sin(2 * Math.PI * i * (hz / SAMPLING_RATE));

      return a;
    }

    public static double [] superimpose (double[] a, double[] b, double[]c, double awt, double bwt, double cwt) {

      double[] o = new double [a.length];
      for (int i = 0; i < a.length; i++ )
        o[i] = a[i] * awt + b[i] * bwt + c[i] * cwt;

        // System.out.println(o[2]);
      return o;

    }

    public static void plotWave (double[] a) {
      int n = a.length;
      StdDraw.setCanvasSize(1200, 512);
      StdDraw.setXscale(-1, n/50);
      StdDraw.setYscale(-1.2, 1.2);
      StdDraw.line(0, 0, n/50, 0);
      StdDraw.line(0, 1, n/50, 1);
      StdDraw.line(0, -1, n/50, -1);
      // StdDraw.line(n/500, 1, n/500, -1);  // Draw milliseconds ???

      StdDraw.setPenRadius(0.0025);
      for (int i = 1; i < n/50; i++)
        {
          StdDraw.point(i, a[i]);
          StdDraw.line(i-1, a[i-1], i, a[i]);
        }

    }


    public static double[] makeMajor (double hz, int pitch, double duration) {
      double onehz = hz * Math.pow(2.0, pitch/12.0);
      double twohz = hz * Math.pow(2.0, (pitch+4)/12.0);
      double threehz = hz * Math.pow(2.0, (pitch+7)/12.0);

      System.out.println(getNoteName(pitch) + "Major Notes: " + getNoteName(pitch) + " " + getNoteName(pitch+4) + " " + getNoteName(pitch+7) );
      System.out.println("Major Freqs: " + onehz + " " + twohz + " " + threehz );

      double[] one = tone(onehz, duration);
      double[] two = tone(twohz, duration);
      double[] three = tone(threehz, duration);

      double [] toplay = superimpose(one, two, three, 1/3.0, 1/3.0, 1/3.0);

      return toplay;
    }

    public static double[] makeMinor (double hz, int pitch, double duration) {
      double onehz = hz * Math.pow(2.0, pitch/12.0);
      double twohz = hz * Math.pow(2.0, (pitch+3)/12.0);
      double threehz = hz * Math.pow(2.0, (pitch+7)/12.0);

      System.out.println(getNoteName(pitch) + "Minor Notes: " + getNoteName(pitch) + " " + getNoteName(pitch+3) + " " + getNoteName(pitch+7) );
      System.out.println("Minor Freqs: " + onehz + " " + twohz + " " + threehz);

      double[] one = tone(onehz, duration);
      double[] two = tone(twohz, duration);
      double[] three = tone(threehz, duration);

      double [] toplay = superimpose(one, two, three, 1/3.0, 1/3.0, 1/3.0);

      return toplay;
    }


    public static double[] makeHarmonic (double hz, int pitch, double duration) {
      double onehz = hz * Math.pow(2.0, pitch/12.0);
      double twohz = hz * Math.pow(2.0, (pitch-12)/12.0);
      double threehz = hz * Math.pow(2.0, (pitch+12)/12.0);

      System.out.println(getNoteName(pitch)+"Harmonic Notes: " + getNoteName(pitch) + " " + getNoteName(pitch-12) + " " + getNoteName(pitch+12));
      System.out.println("Harmonic Freqs: " + onehz + " " + twohz + " " + threehz );

      double[] one = tone(onehz, duration);
      double[] two = tone(twohz, duration);
      double[] three = tone(threehz, duration);

      double [] toplay = superimpose(one, two, three, 1/3.0, 1/3.0, 1/3.0);

      return toplay;
    }

    // int hz = 440;

    public static void main (String args[]) {

      double hz = 440.0;
      double duration = Double.parseDouble(args[0]);
      String note = args[1];
      int pitch =  getNoteNum(note);
      String mode = args[2];

      int SAMPLING_RATE = 44100;
      int n = (int) (SAMPLING_RATE * duration);

      double [] toplay = null;
  
      if (mode.equals("Major")) toplay = makeMajor(hz, pitch, duration);
      else if (mode.equals("Minor")) toplay = makeMinor(hz, pitch, duration);
      else if (mode.equals("Harmonic")) toplay = makeHarmonic(hz, pitch, duration);


      StdAudio.play(toplay);

      plotWave(toplay);   // comment this line if need to remove graph feature

      }




}
