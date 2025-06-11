import exception.TarefaInvalidaException;
import model.Tarefa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Contexto: Um sistema de gerenciamento de tarefas precisa listar tarefas
// não concluídas, ordenadas por prioridade, ignorando prioridades inválidas (< 0).
//Tópicos:
//Stream: Filtra tarefas não concluídas e ordena por prioridade.
//Lambda: Usada na ordenação e filtro.
//Exceptions: Lança TarefaInvalidaException para prioridades inválidas.
//Lists: Usa List como entrada e saída.
//Collections: Usa Collectors.toList() para o resultado.
public class TarefaService {
    public void processarTarefa(){
        List<Tarefa> tarefas = Arrays.asList(
                new Tarefa("Corrigir bug", 3, false),
                new Tarefa("Escrever relatório", 1, true),
                new Tarefa("Testar API", 2, false),
                new Tarefa("Reunião", 4, true),
                new Tarefa("Invalidar tarefa", -1, false)
        );
        List<String> tarefasOrdenadas = tarefas.stream()
                .filter(tarefasPrioridade -> {
                    try{
                        if(tarefasPrioridade.getPrioridade() < 0){
                            throw new TarefaInvalidaException("Tarefas com prioridade negativa" + tarefasPrioridade.getPrioridade() + tarefasPrioridade.getDescricao());
                        }
                    return !tarefasPrioridade.isConcluida();
                }catch(TarefaInvalidaException e){
                        System.out.println(e.getMessage());
                        return false;
                    }
        })
                .sorted((t1,t2) -> Integer.compare(t2.getPrioridade(), t1.getPrioridade()))
                .map(Tarefa::getDescricao)
                .collect(Collectors.toList());
        System.out.println("Exercício 5 - Tarefas não concluídas ordenadas por prioridade:");
        tarefasOrdenadas.forEach(System.out::println);
    }


    public static void main(String[] args){
        TarefaService tarefaService = new TarefaService();

    }
}
