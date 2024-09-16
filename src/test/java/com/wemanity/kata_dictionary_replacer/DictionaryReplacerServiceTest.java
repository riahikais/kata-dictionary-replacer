package com.wemanity.kata_dictionary_replacer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

public class DictionaryReplacerServiceTest {
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
    }
}
