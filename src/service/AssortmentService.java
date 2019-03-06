package service;

import dao.AssortmentRepository;
import domain.Assortment;
import domain.Purchase;
import domain.User;
import exceptions.ExistsException;
import assortment.StateMachine;
import impl.AssortmentImplRepository;

import java.util.List;

public class AssortmentService{

    private final AssortmentRepository assortmentRepository;
    private final StateMachine stateMachine;

    public AssortmentService(AssortmentRepository assortmentRepository, StateMachine stateMachine) {
        this.assortmentRepository = assortmentRepository;
        this.stateMachine = stateMachine;
    }

    public Assortment createAssortment(Assortment assortment, User user){
        null_Id(assortment.getId(),"Already have ID");
        assortment.setSaler(user);
        return assortmentRepository.save(assortment);
    }

    private void null_Id(Long id, String message){
        if(id != null){
            throw new ExistsException(message);
        }
    }

    public List<Assortment> allAsortment(){
        return this.assortmentRepository.findAll();
    }

    public List<Assortment> userAssortment(User user){
        return  this.assortmentRepository.findByUser(user);
    }

    private Assortment assortmenById(Long id){
        return assortmentRepository.findById(id);
    }

    public void upload(Long id){
        Assortment assortment = assortmenById(id);
        stateMachine.upload(assortment);
        assortmentRepository.save(assortment);
    }

    public void remove(Long id){
        Assortment assortment = assortmenById(id);
        stateMachine.remove(assortment);
        assortmentRepository.save(assortment);
    }

    public void sales(Long id){
        Assortment assortment = assortmenById(id);
        stateMachine.sales(assortment);
        assortmentRepository.save(assortment);
    }

    public void favorites(Long id){
        Assortment assortment = assortmenById(id);
        stateMachine.favorites(assortment);
        assortmentRepository.save(assortment);
    }

    public void inTheBasket(Long id){
        Assortment assortment = assortmenById(id);
        stateMachine.inTheBasket(assortment);
        assortmentRepository.save(assortment);
    }

    public void usePurchase(Long id, Integer amount, User user){
        Assortment assortment = assortmenById(id);
        stateMachine.usePurchase(assortment, new Purchase(assortment,user,amount));
        //stateMachine.usePurchase(assortment, user, amount);
        assortmentRepository.save(assortment);
    }
}
