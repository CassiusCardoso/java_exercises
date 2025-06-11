import exception.SalarioInvalidoException;
import model.Funcionario;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Mário", "TI", 3200.0),
                new Funcionario("Joana", "Gastronomia", 1250.0),
                new Funcionario("Júlio", "Administrativo", 2300.0),
                new Funcionario("Alex Teixeira", "TI", -6000.0),
                new Funcionario("Veggeti", "Farmácia", -1500.0),
                new Funcionario("Leixão", "Auxiliar geral", 10000.0)
        );

        // Exercício 1: Filtrar funcionários com salário > 3000 e tratar salários negativos
        try {
            List<String> resultado = funcionarios.stream()
                    .filter(func -> {
                        if (func.getSalario() < 0) {
                            throw new SalarioInvalidoException("Salário inválido para " + func.getNome());
                        }
                        return func.getSalario() > 3000.0;
                    })
                    .map(func -> func.getNome() + " (" + func.getDepartamento() + "): R$" + func.getSalario())
                    .collect(Collectors.toList());

            System.out.println("Exercício 1 - Funcionários com salário alto:");
            resultado.forEach(System.out::println);
        } catch (SalarioInvalidoException e) {
            System.out.println("Erro no Exercício 1: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado no Exercício 1: " + e.getMessage());
        }
    }
}