package br.com.gustavo.todo_list.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> tratarErro(MethodArgumentNotValidException erro) {

        Map<String, String> resposta = new HashMap<>();

        erro.getBindingResult()
                .getFieldErrors()
                .forEach(campo -> {
                 resposta.put(campo.getField(), campo
                         .getDefaultMessage());
        });

        return resposta;
    }
}
