package com.epam.morse.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EngineEncryption {

    File englishToMorseFile = new File("resource/englishToMorse.txt");
    File morseToEnglishFile = new File("resource/morseToEnglish.txt");

    public void englishToMorse() {

        String englishText = "";

        try {
            Scanner scanner = new Scanner(englishToMorseFile);
            while (scanner.hasNextLine()) {
                englishText += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        englishText = englishText.toUpperCase();
        char[] charText = englishText.toCharArray();
        String morseText = "";

        for (int i = 0; i < charText.length; i++) {
            for (int j = 0; j < AlphabetEng.ENGLISH.length; j++) {
                if (charText[i] == AlphabetEng.ENGLISH[j]) {
                    morseText = morseText + AlphabetEng.MORSE[j] + " ";
                    break;
                }
            }
        }

        try(FileWriter writer = new FileWriter(morseToEnglishFile, false))
        {
            writer.write(morseText);
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void morseToEnglish () {

        String morseText = "";

        try {
            Scanner scanner = new Scanner(morseToEnglishFile);
            while (scanner.hasNextLine()) {
                morseText += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String englishText = "";
        String[] letters = new String[100];

        // NullPointerException предотвращение
        for(int i = 0; i < letters.length; i++) {
            letters[i] = "";
        }

        int k = 0;
        for (String letter : morseText.split(" ")) {
            letters[k] = letter;
            k++;
        }

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < AlphabetEng.MORSE.length; j++) {
                String let = letters[i];
                if (let.equals(AlphabetEng.MORSE[j])) {
                    englishText = englishText + AlphabetEng.ENGLISH[j];
                    break;
                }
            }
        }

        try(FileWriter writer = new FileWriter(englishToMorseFile, false))
        {
            writer.write(englishText);
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}