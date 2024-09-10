import java.util.ArrayList;
import java.util.List;
public class combinarlistas {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Por favor, ingrese dos listas de números separadas por comas.");
            return;
        }
        // Convertir las cadenas de entrada en listas de enteros
        List<Integer> list1 = convertToList(args[0]);
        List<Integer> list2 = convertToList(args[1]);

        // Llamar al método merge para combinar las listas
        List<Integer> result = merge(list1, list2);
        System.out.println(result);
    }

    // Método para convertir una cadena de números separados por comas a una lista de enteros
    public static List<Integer> convertToList(String input) {
        String[] numbers = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (String num : numbers) {
            list.add(Integer.parseInt(num.trim()));
        }
        return list;
    }

    // Método que combina dos listas ordenadas en una sola lista ordenada
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar las listas manteniendo el orden
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de list1 o list2
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        return mergedList;
    }
}
