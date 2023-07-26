package com.BackEnd;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserInterfaceService {
    private URLConnectionService connectionService;
    private TextProcessingService textService;

    public UserInterfaceService() {
        this.connectionService = new URLConnectionService();
        this.textService = new TextProcessingService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o URL: ");
        String url = scanner.nextLine();

        System.out.print("Digite uma frase composta por N palavras: ");
        String frase = scanner.nextLine();

        try {
            String pageContent = connectionService.getPageContent(url);

            int totalOccurrences = textService.countOccurrences(pageContent, frase);
            System.out.println("\"" + frase + "\" => repete " + totalOccurrences + " vezes");

            String[] words = frase.split("\\s+");
            Map<String, Integer> wordOccurrences = textService.countWordOccurrences(pageContent, words);
            for (var entry : wordOccurrences.entrySet()) {
                System.out.println("\"" + entry.getKey() + "\" => repete " + entry.getValue() + " vezes");
            }
        } catch (IOException e) {
            System.err.println("Erro ao conectar ao URL: " + e.getMessage());
        }
    }
}
