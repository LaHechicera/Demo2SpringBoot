package com.example.API_DEMO_1.controller;

import org.springframework.web.bind.annotation.*;

//1. Esta clase completa se va amanejar mediante protocolo http (Vamos a crear  el metadato @RestController)
@RestController

//2. Ruta base para acceder a mi api
@RequestMapping("/api/v1/controlador")
public class OperacionesController {

    //3. Agregamos saludo
    @GetMapping("/saludo")
    public String saludo(){
        return "Bienvenido a mi API demo la mas kul";
    }

    //4. Saludaremos recibiendo un parametro mediante la url //Entre llaves lle decimos a la url que vamos a recibir algo
    @GetMapping("/hello/{nombre}")
    public String saludoDinamico(@PathVariable String nombre){
        return "Hola a todos mi nombre es : " +  nombre;
    }

    //5. Operaciones aritmeticas suma
    @GetMapping("/suma")
    public String suma(){
        int resultado = 5+3;
        return "El resultado de la suma es: " + resultado;
    }
    //6. Operacion resta
    @GetMapping("/resta")
    public String resta(){
        int resultado = 5-3;
        return "El resultado de la resta es: " + resultado;
    }
    //7. Operacion Multiplicacion
    @GetMapping("/multiplicacion")
    public String multiplicacion(){
        int resultado = 5*3;
        return "El resultado de la multiplicacion es: " + resultado;
    }
    //8. Operacion Division
    @GetMapping("/division")
    public String division(){
        int resultado = 5/3;
        return "El resultado de la division es: " + resultado;
    }
    //9. suma recibiendo parametros
    @GetMapping("/suma/{a}/{b}")
    public String sumaConParametros(@PathVariable int a, @PathVariable int b){
        return "El resultado de la suma de "+ a + " + " + b + " es: " + (a+b);
    }
    //10. resta recibiendo parametros
    @GetMapping("/resta/{a}/{b}")
    public String restaConParametros(@PathVariable int a, @PathVariable int b){
        return "El resultado de la resta de "+ a + " - " + b + " es: " + (a-b);
    }
    //11. multiplicacion recibiendo parametros
    @GetMapping("/multiplicacion/{a}/{b}")
    public String multiplicacionConParametros(@PathVariable int a, @PathVariable int b){
        return "El resultado de la multiplicacion de "+ a + " * " + b + " es: " + (a*b);
    }
    //12. division recibiendo parametros
    @GetMapping("/division/{a}/{b}")
    public String divisionConParametros(@PathVariable int a, @PathVariable int b){
        if (b==0){
            return "No se puede dividir por cero señor";
        }
        return "El resultado de la division de "+ a + " / " + b + " es: " + (a/b);
    }

    //13. Ejemplo de uso de encabezados HTTP para obtener informacion del cliente (Navegador)
    @GetMapping("/uso-agente")
    public String obtenerInfoAgente(@RequestHeader(value = "User-Agent",defaultValue = "Desconocido no capto bro") String userAgent){
        return "La información mediante la cabecera de head es: " + userAgent;
    }
}
