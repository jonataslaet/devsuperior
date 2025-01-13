package capitulos.recursion;

import java.util.List;

public class VendasDepartamento {

    public double[] totalSales(List<String> sales, String department){
        double[] result = new double[2];
        getResult(0, sales, department, result);
        return result;
    }

    private void getResult(int i, List<String> sales, String department, double[] result) {
        if (i >= sales.size()) return;
        String[] x = sales.get(i).split(",");
        String currentDepartament = x[3];
        if (currentDepartament.equalsIgnoreCase(department)) {
            double value = Double.parseDouble(x[2]);
            result[0] += 1.0;
            result[1] += value;
        }
        getResult(i+1, sales, department, result);
    }

    public static void main(String[] args) {
        String[] sales = {
            "8349,14/09/2024,899.9,ESPORTE",
            "4837,17/09/2024,530.0,VESTUARIO",
            "15281,21/09/2024,1253.99,ESPORTE",
            "15344,27/09/2024,1000.9,VESTUARIO",
            "18317,04/10/2024,250.4,VESTUARIO",
            "18972,11/10/2024,385.5,JARDINAGEM"
        };
        String department = "VESTUARIO";
        VendasDepartamento vendasDepartamento = new VendasDepartamento();
        double[] result = vendasDepartamento.totalSales(List.of(sales), department);
        System.out.println(String.format("%.0f", result[0]) + " VENDAS \nTOTAL = $ " + String.format("%.2f", result[1]));
    }
}
