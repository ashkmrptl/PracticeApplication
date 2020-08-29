package com.akp.interview.jpmc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FrownySmileys {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        /*while ((line = in.readLine()) != null) {
            System.out.println(line);
        }*/

        line = in.readLine();

        final Set<Character> eyebrows = Collections.singleton('>');
        final Set<Character> eyes = new HashSet<>(Arrays.asList(':', ';', '8'));
        final Set<Character> cry = Collections.singleton('\'');
        final Set<Character> nose = new HashSet<>(Arrays.asList('-', 'o', '~'));
        final Set<Character> mouth = new HashSet<>(Arrays.asList('(', 'C', '<', '[', '{', '@'));

        final char[] array = line.toCharArray();
        int count = 0;
        int i = 0;
        while(i < array.length) {
            if (eyebrows.contains(array[i]) || eyes.contains(array[i])) {
                if (eyebrows.contains(array[i])) { // Contains eyebrows
                    i++;
                }
                if (eyes.contains(array[i])) { // Contains eyes
                    i++;
                    if (cry.contains(array[i])) { // Contains cry
                        i++;
                    }
                    if (nose.contains(array[i])) { // Contains nose
                        i++;
                    }
                    if (mouth.contains(array[i])) { // Contains mouth
                        count++;
                    }
                }
            }
            i++;
        }

        System.out.println(count);
    }
}
