package br.unipar.devbackend.cadastroaluno.dao;
import br.unipar.devbackend.cadastroaluno.model.Endereco;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EnderecoDAO {
    EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

public List<Endereco> findAll(){
        return em.createQuery("SELECT E FROM Endereco e", Endereco.class)
                .getResultList();
}
public Endereco findById(int id){
        return em.find(Endereco.class, id);
}

public Endereco inserirEndereco(Endereco endereco){
        try{
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
            return endereco;
        } catch (Exception ex){
            em.getTransaction().rollback();
            System.out.println("Algo de errado não está certo!" + ex.getMessage());
            return null;
    }finally {
        if(em.isOpen()){
            em.close();
            System.out.println("EntityManager Fechado com Sucesso!");
        }
    }
}


public Endereco editarEndereco(Endereco endereco){
        try{
            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();
            return endereco;
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.out.println("Algo de errado não está certo!" + ex.getMessage());
            return null;
        }finally{
            if(em.isOpen()){
                em.close();
                System.out.println("EntityManager Fechado com Sucesso!");
            }
        }
}
public Boolean deleteEndereco(Endereco  endereco){
    try{
        em.getTransaction().begin();
        em.remove(endereco);
        em.getTransaction().commit();
        return true;
    } catch (Exception ex){
        em.getTransaction().rollback();
        System.out.println("Algo de errado não está certo!" + ex.getMessage());
        return null;
    }finally {
        if(em.isOpen()){
            em.close();
            System.out.println("EntityManager Fechado com Sucesso!");
        }
    }
}
}
