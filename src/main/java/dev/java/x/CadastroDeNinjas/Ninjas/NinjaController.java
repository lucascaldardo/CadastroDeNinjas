package dev.java.x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // CRUD CREATE READ UPDATE DELETE

    // Criar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninjas";
    }

    // Mostrar Ninja por ID (CREATE)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }

}
