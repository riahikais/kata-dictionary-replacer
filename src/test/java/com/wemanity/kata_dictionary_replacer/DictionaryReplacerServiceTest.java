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

    @Test
    public void testEmptyStringAndDictionary() {
        Map<String, String> dictionary = new HashMap<>();
        String result = replacerService.replaceWords("", dictionary);
        assertEquals("", result);
    }

    @Test
    public void testSinglePlaceholderReplacement() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");

        String result = replacerService.replaceWords("$temp$", dictionary);
        assertEquals("temporary", result);
    }

    @Test
    public void testMultiplePlaceholderReplacement() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("temp", "temporary");
        dictionary.put("name", "John Doe");

        String result = replacerService.replaceWords("$temp$ here comes the name $name$", dictionary);
        assertEquals("temporary here comes the name John Doe", result);
    }
}
