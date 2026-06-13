import java.lang.reflect.Method;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        try {

            // Carrega a classe ArrayList
            Class<?> classeLista = Class.forName("java.util.ArrayList");

            // Instancia a lista via Reflection
            Object lista = classeLista.getDeclaredConstructor().newInstance();

            // Método add(Object)
            Method metodoAdd = classeLista.getMethod("add", Object.class);

            // Adicionando elementos
            metodoAdd.invoke(lista, "Guilherme");
            metodoAdd.invoke(lista, "Java");
            metodoAdd.invoke(lista, 2026);
            metodoAdd.invoke(lista, true);

            // Método iterator()
            Method metodoIterator = classeLista.getMethod("iterator");

            // Obtendo iterator
            Iterator<?> iterator = (Iterator<?>) metodoIterator.invoke(lista);

            System.out.println("Valores da lista:");

            // Iterando normalmente
            while (iterator.hasNext()) {

                Object valor = iterator.next();

                System.out.println(valor);
            }

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}