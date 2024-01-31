package com.vehicule.api.services;

import com.vehicule.api.entity.Commission;
import com.vehicule.api.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionService {
    private final CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    public Commission saveCommission(double valeur){
        Commission commission = new Commission();
        commission.setValeur(valeur);
        commission = commissionRepository.save(commission);
        return commission;
    }

    public void deleteCommission(Long id){
        commissionRepository.deleteById(id);
    }

    public Commission updateCommission(Long id, Commission v){
        v.setIdCommission(id);
        commissionRepository.save(v);
        return v;
    }
}
