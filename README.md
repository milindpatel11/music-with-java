# music-with-java
Some fun exercises from java lessons



Some exercises to practice java arrays and StdAudio library from Princeton University 
https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdAudio.html


Requires to have StdAudio.java (if want graph from AllChords.java, also need StdDraw.java) files in same directory to use as well. (StdOut.java and StdOut.class files added in repo for ease - Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.)


This repo is to host some exercises that I though of coding while reading some concepts and basic code for simpler problem from booksite - https://introcs.cs.princeton.edu/java/home/ .


1. Chromatic440.java --- takes one command line argument duration and plays 12 notes (+1 from octave above) from Chromatic scale of ConcertA
    e.g. java Chromatic440 0.25 ; java Chromatic440 1 ;

2. AllChords.java -- Three command line arguments 
    1. duartion in seconds (ideally between 0.5 and 4 sec)
    2. Name of chord (in form A, A# etc - Reference valid notes are A, A#, B, C, C#, D, D#, E, F, F#, G, G#) - Invalid notes will use "A"  by default.
    3. Type of chord (Major, Minor or Harmonic)
    
 Output gives names of notes in the chord, frequencies of these notes, plays the chord and then draws graph for 1/50th duration mentioned in argument.
 
 to disable graph - comment out line 145  --- plotWave(toplay) ---
 

