package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SaveableDictionary {

    private Map<String, String> translations;
    private String file;

    public SaveableDictionary() {
        this.translations = new LinkedHashMap<>();
        this.file = null;
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public void add(String word, String translation) {
        if (this.translations.containsKey(word) || this.translations.containsKey(translation)) {
            return;
        }

        this.translations.put(word, translation);
        this.translations.put(translation, word);
    }

    public String translate(String word) {
        return this.translations.get(word);
    }

    public void delete(String word) {
        String translation = this.translations.get(word);
        if (translation == null) {
            return;
        }

        this.translations.remove(word);
        this.translations.remove(translation);
    }

    public boolean load() {
        if (this.file == null) {
            return false;
        }

        File dictionaryFile = new File(this.file);
        if (!dictionaryFile.exists()) {
            return true;
        }

        try (Scanner fileReader = new Scanner(dictionaryFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean save() {
        if (this.file == null) {
            return false;
        }

        try (FileWriter writer = new FileWriter(new File(this.file))) {
            Set<String> saved = new HashSet<>();

            for (String word : this.translations.keySet()) {
                String translation = this.translations.get(word);
                if (saved.contains(word) || saved.contains(translation)) {
                    continue;
                }

                writer.write(word + ":" + translation + "\n");
                saved.add(word);
                saved.add(translation);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
