package com.wemanity.kata_dictionary_replacer.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryReplacerService {
    // Méthode principale pour remplacer les mots dans le texte
    public String replaceWords(String text, Map<String, String> dictionary) {
        // Validation : Vérifie si le texte est nul
        if (text == null) {
            throw new IllegalArgumentException("Le texte ne peut pas être nul.");
        }

        // Validation : Vérifie si le dictionnaire est nul
        if (dictionary == null) {
            throw new IllegalArgumentException("Le dictionnaire ne peut pas être nul.");
        }

        // Si le texte ou le dictionnaire est vide, retourner le texte inchangé
        if (text.isEmpty() || dictionary.isEmpty()) {
            return text;
        }

        // Remplacement des mots clés entourés de '$' dans le texte
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            // Construction de la clé entourée de '$'
            String key = "$" + entry.getKey() + "$";
            // Remplacement dans le texte
            text = text.replace(key, entry.getValue());
        }

        return text;
    }
}