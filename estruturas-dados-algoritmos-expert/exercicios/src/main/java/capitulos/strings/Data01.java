package capitulos.strings;

public class Data01 {

    public static class DateInfo {
        public Integer dia;
        public Integer mes;
        public Integer ano;

        public DateInfo() {}

        @Override
        public String toString() {
            return "Dia: " + dia +
                    "\nMês: " + mes +
                    "\nAno: " + ano;
        }
    }

    public static DateInfo extractDateData(String date) {
        DateInfo dateInfo = new DateInfo();
        dateInfo.dia = Integer.valueOf(date.split("/")[0]);
        dateInfo.mes = Integer.valueOf(date.split("/")[1]);
        dateInfo.ano = Integer.valueOf(date.split("/")[2]);

        return dateInfo;
    }

    public static void main(String[] args) {
        String date = "05/03/1993";
        System.out.println(extractDateData(date));
    }
}
