package org.example.persistenza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.shared.Contatore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileHelper {
    private static FileHelper instance;
    public static FileHelper getInstance() {
        if (instance == null) {
            instance = new FileHelper();
        }
        return instance;
    }
    private FileHelper(){}

    private final String FILENAME = "contatori.json";

    public void salvaContatore(Contatore contatore) {
        try (Writer writer = new FileWriter(FILENAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(contatore, writer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }


    public Contatore caricaContatore(int matricola) {
        try (FileReader reader = new FileReader(FILENAME)){
            Gson gson = new Gson();
            Contatore[] contatori = gson.fromJson(reader, Contatore[].class);
            Arrays.stream(contatori)
                    .filter(contatore -> contatore.getMatricola() == matricola)
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
