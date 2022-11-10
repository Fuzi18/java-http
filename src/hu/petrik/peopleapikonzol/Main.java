package hu.petrik.peopleapikonzol;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String url = "https://retoolapi.dev/x24Cku/people";
    public static void main(String[] args) {
        try {
            newPersonFromConsole();
            Response people = RequestHandler.get(url);
            System.out.println(people);
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private static void newPersonFromConsole() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a nevét: ");
        String name = sc.nextLine();
        System.out.println("Adja meg az e-mail címét: ");
        String email= sc.nextLine();
        System.out.println("Adja meg az életkorát: ");
        String age= sc.nextLine();
        String json = String.format("{\"name\": \"%s\", \"email\": \"%s\", \"age\": \"%s\"}", name, email, age);
        RequestHandler.post(url , json);

    }
}
