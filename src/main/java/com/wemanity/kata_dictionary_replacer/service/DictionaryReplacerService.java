package com.wemanity.kata_dictionary_replacer.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryReplacerService {
    public String replaceWords(String text, Map<String, String> dictionary) {
        if (text == null || text.isEmpty() || dictionary == null || dictionary.isEmpty()) {
            return text;
        }

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String key = "$" + entry.getKey() + "$";
            text = text.replace(key, entry.getValue());
        }
        return text;
    }
}