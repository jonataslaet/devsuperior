package capitulos.strings;

import java.util.regex.Pattern;

public class DominioEmail {

    public static class EmailInfo {
        public String usuario;
        public String dominio;
        public String brasileiro;

        public EmailInfo() {}

        @Override
        public String toString() {
            return "Usuario: " + usuario +
                    "\nDominio: " + dominio +
                    "\nBrasileiro: " + brasileiro;
        }
    }

    public static EmailInfo extractEmailInformation(String email) {
        EmailInfo emailInfo = new EmailInfo();
        emailInfo.usuario = email.split("@")[0];
        emailInfo.dominio = email.split("@")[1];
        emailInfo.brasileiro = email.split("@")[1].endsWith(".br") ? "sim" : "nao";

        return emailInfo;
    }

    public static void main(String[] args) {
        String email = "jonatasblendo@yahoo.com.br";
        System.out.println(extractEmailInformation(email));
    }
}
