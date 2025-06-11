import exception.TransacaoInvalidaException;
import model.Transacao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransacaoService {
    public void analisarTransacoes() {
        List<Transacao> transacoes = Arrays.asList(
                new Transacao("T1", 1000.0, "Vendas"),
                new Transacao("T2", -50.0, "Devoluções"),
                new Transacao("T3", 2000.0, "Vendas"),
                new Transacao("T4", 500.0, "Serviços"),
                new Transacao("T5", 300.0, "Vendas")
        );

        try {
            Map<String, Double> somaPorCategoria = transacoes.stream()
                    .filter(t -> {
                        try {
                            if (t.getValor() < 0) {
                                throw new TransacaoInvalidaException("Valor negativo na transação " + t.getNome());
                            }
                            return true;
                        } catch (TransacaoInvalidaException e) {
                            System.out.println("Erro: " + e.getMessage());
                            return false;
                        }
                    })
                    .collect(Collectors.groupingBy(
                            Transacao::getCategoria,
                            Collectors.summingDouble(Transacao::getValor)
                    ));

            System.out.println("Exercício 4 - Soma de transações por categoria:");
            somaPorCategoria.forEach((categoria, soma) ->
                    System.out.println(categoria + ": R$" + soma));
        } catch (Exception e) {
            System.out.println("Erro inesperado no Exercício 4: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransacaoService service = new TransacaoService();
        service.analisarTransacoes();
    }
}