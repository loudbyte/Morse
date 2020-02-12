package com.epam.morse.main;

import com.epam.morse.process.EngineEncryption;

public class ToMorseRunner {
    public static void main(String[] args) {
        EngineEncryption encryption = new EngineEncryption();
        encryption.englishToMorse();
    }
}
