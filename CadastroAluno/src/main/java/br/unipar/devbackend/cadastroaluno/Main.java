package br.unipar.devbackend.cadastroaluno;

import br.unipar.devbackend.cadastroaluno.dao.AlunoDAO;
import br.unipar.devbackend.cadastroaluno.model.Aluno;
import br.unipar.devbackend.cadastroaluno.model.Endereco;
import br.unipar.devbackend.cadastroaluno.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        EntityManagerUtil.getEmf();    //Abre o sitema e a conexão com o banco de dados

        Aluno aluno = new Aluno();
        aluno.setNome("Juvenal Amaral");
        aluno.setRa("60004869");
        aluno.setTelefone("(45) 98593-2694");
        aluno.setEmail("jujuamal@gmail.com");
        aluno.setData_nasc(new Date("01/09/2007"));

        //criamos o bojeto DAO responsável pelas transações
        AlunoDAO alunoDao = new AlunoDAO(EntityManagerUtil.getEntityManager());
        alunoDao.inserirAluno(aluno);



        EntityManagerUtil.closeEntityManagerFactory(); //Fecha o sistema e a conexão com o banco de dados
    }
}
