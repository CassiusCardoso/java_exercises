import exception.LivroInvalidoException;
import model.Livro;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BibliotecaService {
    public void gerarRelatorioLivrosPorAutor() {
        List<Livro> livros = Arrays.asList(
                new Livro("Java Basics", "John Doe", 2015),
                new Livro("Advanced Java", "John Doe", 2020),
                new Livro("Python Guide", "Jane Smith", 2018),
                new Livro("Old Book", "Jane Smith", 1800),
                new Livro("Modern Java", "Alice Brown", 2023)
        );

        try {
            Map<String, List<String>> livrosPorAutor = livros.stream()
                    .filter(livro -> {
                        try {
                            if (livro.getAno() < 1900) {
                                throw new LivroInvalidoException("Ano inválido para o livro: " + livro.getTitulo());
                            }
                            return true;
                        } catch (LivroInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                            return false;
                        }
                    })
                    .collect(Collectors.groupingBy(
                            Livro::getAutor,
                            Collectors.mapping(Livro::getTitulo, Collectors.toList())
                    ));

            System.out.println("Exercício 3 - Livros por autor:");
            livrosPorAutor.forEach((autor, titulos) ->
                    System.out.println(autor + ": " + String.join(", ", titulos)));
        } catch (Exception e) {
            System.out.println("Erro inesperado no Exercício 3: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();
        service.gerarRelatorioLivrosPorAutor();
    }
}