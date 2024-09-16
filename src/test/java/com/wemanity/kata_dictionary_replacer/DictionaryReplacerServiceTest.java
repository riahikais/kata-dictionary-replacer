package com.wemanity.kata_dictionary_replacer;

import com.wemanity.kata_dictionary_replacer.service.DictionaryReplacerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DictionaryReplacerServiceTest {
    @Autowired
    private DictionaryReplacerService replacerService;

    // Test pour le cas où la chaîne d'entrée et le dictionnaire sont vides.
    @Test
    public void testEmptyStringAndDictionary() {
        Map<String, String> dictionary = new HashMap<>();
        String result = replacerService.replaceWords("", dictionary);
        assertEquals("", result);
    }

    // Test pour le cas où un seul mot clé est remplacé.
    @Test
    public void testSinglePlaceholderReplacement() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");

        String result = replacerService.replaceWords("$temp$", dictionary);
        assertEquals("temporary", result);
    }

    // Test pour le cas où plusieurs mots clés sont remplacés.
    @Test
    public void testMultiplePlaceholderReplacement() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");
        dictionary.put("name", "John Doe");

        String result = replacerService.replaceWords("$temp$ here comes the name $name$", dictionary);
        assertEquals("temporary here comes the name John Doe", result);
    }

    // Test avec une chaîne sans aucun mot-clé
    @Test
    public void testNoPlaceholders() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");

        String result = replacerService.replaceWords("No placeholders here", dictionary);
        assertEquals("No placeholders here", result);
    }

    // Test avec des mots-clés dans le dictionnaire non entourés de $
    @Test
    public void testDictionaryWithoutDollarSigns() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");

        String result = replacerService.replaceWords("This is $temp$", dictionary);
        assertEquals("This is temporary", result);
    }

    // Test avec une chaîne contenant des mots-clés non définis dans le dictionnaire
    @Test
    public void testUndefinedPlaceholder() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John Doe");

        String result = replacerService.replaceWords("Hello $temp$, meet $name$", dictionary);
        assertEquals("Hello $temp$, meet John Doe", result);
    }

    // Test avec des mots-clés adjacents
    @Test
    public void testAdjacentPlaceholders() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("one", "1");
        dictionary.put("two", "2");

        String result = replacerService.replaceWords("$one$$two$", dictionary);
        assertEquals("12", result);
    }

}
