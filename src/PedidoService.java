import exception.PedidoInvalidoException;
import model.Pedido;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

public class PedidoService {
    public void processarPedido(){
    List<Pedido> pedidos = Arrays.asList(
            new Pedido(1, 200.0, true),
            new Pedido(2, 500.0, false),
            new Pedido(3, 0.0, false),
            new Pedido(4, 1500.0, false),
            new Pedido(5, 300.0, true)
    );
    try{
        double resultadoNaoProcessado = pedidos.stream()
                .filter(ped -> !ped.isProcessado())
                .mapToDouble(ped ->{
                    if (ped.getPreco() <= 0) {
                        throw new PedidoInvalidoException("Valor do pedido inválido: R$ " + ped.getPreco());
                    }
                    return ped.getPreco();
    })
                        .sum();

        System.out.println("Total de pedidos não processados: " + resultadoNaoProcessado);

    }catch(PedidoInvalidoException e){
        System.out.println(e.getMessage());
    }
}
// Precisa do main porque somente ele consegue executar a app
public static void main(String [] args) {
    PedidoService serv = new PedidoService();
    serv.processarPedido();
}}