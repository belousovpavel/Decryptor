package com.example.atbashdecryptor.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleDecryptor {

    public String decrypt(String encryptedText) {
        // Создаем таблицу Атбаш для русского алфавита
        Map<Character, Character> atbashMapLower = new HashMap<>();
        Map<Character, Character> atbashMapUpper = new HashMap<>();
        String alphabetLower = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        String alphabetUpper = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        int length = alphabetLower.length();

        for (int i = 0; i < length; i++) {
            atbashMapLower.put(alphabetLower.charAt(i), alphabetLower.charAt(length - 1 - i));
            atbashMapUpper.put(alphabetUpper.charAt(i), alphabetUpper.charAt(length - 1 - i));
        }

        // Подстановка символов
        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (atbashMapLower.containsKey(c)) {
                decryptedText.append(atbashMapLower.get(c));
            } else if (atbashMapUpper.containsKey(c)) {
                decryptedText.append(atbashMapUpper.get(c));
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
}
