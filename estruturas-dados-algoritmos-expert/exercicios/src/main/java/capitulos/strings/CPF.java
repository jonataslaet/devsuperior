package capitulos.strings;

public class CPF {

    public static String removeNonDigits(String str) {
        String regex = "\\D";
        return str.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        String cpf = "874092172-93";
        System.out.println(removeNonDigits(cpf));
    }
}
