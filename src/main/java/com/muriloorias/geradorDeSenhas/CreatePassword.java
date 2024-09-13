package com.muriloorias.geradorDeSenhas;

import java.security.SecureRandom;
import java.util.Scanner;

public class CreatePassword {
    static SecureRandom random = new SecureRandom();
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    static void create() {
        Scanner scanner = new Scanner(System.in);
        int securityLevel;
        String passwordIdeaTxt;
        int passwordIdeaNumber;
        System.out.println("Qual o nível de segurança que você quer? (o nível vai de 1 a 2, preencha apenas com números)");
        int userSecurityLevel = scanner.nextInt();
        scanner.nextLine();
        if (userSecurityLevel > 2) {
            System.out.println("Falha, nenhum nível encontrado");
            CreatePassword.create();
            return;
        }
        securityLevel = userSecurityLevel;
        System.out.println("Alguma ideia de texto? (é necessário que seja preenchido)");
        passwordIdeaTxt = scanner.nextLine();
        if (passwordIdeaTxt.isEmpty()) {
            System.out.println("Falha: ideia de texto não pode ser vazia");
            CreatePassword.create();
            return;
        }
        System.out.println("Alguma ideia de número? (é necessário que seja preenchido)");
        passwordIdeaNumber = scanner.nextInt();

        if (securityLevel == 1) {
            CreatePassword.levelOne(passwordIdeaTxt, passwordIdeaNumber);
        } else {
            CreatePassword.levelTwo(passwordIdeaTxt, passwordIdeaNumber);
        }
    }

    static void levelOne(String passwordIdeaTxt, int passwordIdeaNumber) {
        System.out.println(passwordIdeaTxt + passwordIdeaNumber);
        System.out.println("Lembrando que esta senha é fraca!");
        CreatePassword.create();
    }

    static void levelTwo(String passwordIdeaTxt, int passwordIdeaNumber) {
        StringBuilder password = new StringBuilder();
        password.append(passwordIdeaTxt);
        password.append(passwordIdeaNumber);

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(SPECIAL_CHARACTERS.length());
            password.append(SPECIAL_CHARACTERS.charAt(index));
        }

        System.out.println("Senha gerada: " + password);
        System.out.println("Essa senha é mais forte.");
        CreatePassword.create();
    }
}
