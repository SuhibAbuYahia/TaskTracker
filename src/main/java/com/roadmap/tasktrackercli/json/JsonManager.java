package com.roadmap.tasktrackercli.json;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManager<T> {

    private final Gson gson = new Gson();
    private final String filePath;
    private final Type listType;

    public JsonManager(String filePath, Type listType) {
        this.filePath = filePath;
        this.listType = listType;
    }

    public void save(List<T> list) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
            System.out.println("✅ Saved to " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Error saving JSON: " + e.getMessage());
        }
    }

    public List<T> load() {

        File file = new File(filePath);

        // 🔹 If file does not exist, create it with an empty list
        if (!file.exists()) {
            System.out.println("⚠️ JSON file not found. Creating new one...");
            List<T> emptyList = new ArrayList<>();
            save(emptyList);
            return emptyList;
        }

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("⚠️ Error loading JSON: " + e.getMessage());
            return null;
        }
    }
}
