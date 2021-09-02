package lesson7.reflection.staticfinal;

public class Knowledge {
    private static final Integer ANSWER = 42;

    public String askQuestion(String question) {
        return "The answer to '" + question + "' is: " + ANSWER;
    }

    public static void main(String[] args) {
        System.out.println(new Knowledge().askQuestion("В чем смысл бытия?"));
    }
}