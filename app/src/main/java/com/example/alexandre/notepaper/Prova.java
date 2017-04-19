package com.example.alexandre.notepaper;

import java.util.Date;

public class Prova {
    String Materia;
    String Professor;
    float Valor;
    String Data;

    public Prova(){

    }

    public Prova(String data,String materia, String professor,float valor) {
        Materia = materia;
        Valor = valor;
        Professor = professor;
        Data = data;
    }

    void setMateria(String materia){
        this.Materia = materia;
    }

    String getMateria(){
        return Materia;
    }

    void setProfessor(String professor){
        this.Professor = professor;
    }

    String getProfessor(){
        return Professor;
    }

    void setValor(float valor){
        this.Valor = valor;
    }

    float getValor(){
        return Valor;
    }

    void setData(String data){
        this.Data = data;
    }

    String getData(){
        return Data;
    }
}
