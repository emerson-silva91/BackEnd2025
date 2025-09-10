package br.unipar.devbackend.cadastroaluno.dao;

import br.unipar.devbackend.cadastroaluno.model.Aluno;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlunoDAO {  //(data access object)

    //metodos de crud
    //create / read / update / delete

    EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }

    public List<Aluno> findAll(){
        return em.createQuery("SELECT A FROM Aluno a", Aluno.class)
                .getResultList();
    }

    public Aluno findByRA(String RA) {
        return em.createQuery("SELECT A FROM Aluno a WHERE a.ra = :ra", Aluno.class)
                .setParameter("ra", RA).getSingleResult();
    }

    public Aluno findById(Long id) {
        return em.find(Aluno.class,id);
    }

    public Aluno inserirAluno(Aluno aluno) {
        try{
            em.getTransaction().begin();//abrimos a transação com o banco de dados
            em.persist(aluno); //insert - inserindo o aluno no banco de dados
            em.getTransaction().commit(); //
            return aluno;
        } catch (Exception ex) {
            em.getTransaction().rollback(); //desfazer a operação
            System.out.println("Algo de errado não está certo!" + ex.getMessage());
            return null;
        }finally{
            if(em.isOpen()){
                em.close();
                System.out.println("EntityManager Fechado com sucesso!");
            }
        }
    }
    public Aluno editarAluno(Aluno aluno) {
        try{
            em.getTransaction().begin();//abrimos a transação com o banco de dados
            em.merge(aluno); //insert - inserindo o aluno no banco de dados
            em.getTransaction().commit(); //
            return aluno;
        } catch (Exception ex) {
            em.getTransaction().rollback(); //desfazer a operação
            System.out.println("Algo de errado não está certo!" + ex.getMessage());
            return null;
        }finally{
            if(em.isOpen()){
                em.close();
                System.out.println("EntityManager Fechado com sucesso!");
            }
        }
    }

    public Boolean deletarAluno(Aluno aluno) {
        try{
            em.getTransaction().begin();//abrimos a transação com o banco de dados
            em.remove(aluno); //delete - remove  o aluno no banco de dados
            em.getTransaction().commit(); //
            return true;  //retorna que deu certo a exclusão
        } catch (Exception ex) {
            em.getTransaction().rollback(); //desfazer a operação
            System.out.println("Algo de errado não está certo!" + ex.getMessage());
            return false;
        }finally{
            if(em.isOpen()){
                em.close();
                System.out.println("EntityManager Fechado com sucesso!");
            }
        }
    }
}
