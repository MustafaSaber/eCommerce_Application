package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Store;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.forms.StoreForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    public StoreServiceImp(StoreRepository storeRepository) { this.storeRepository = storeRepository; }

    @Override
    public Optional<Store> getStoreByName(String name)
    {
        return storeRepository.findOneByName(name);
    }

    @Override
    public Collection<Store> getStoresAccepted(Boolean check) {
        return storeRepository.findAllBySuggested(check);
    }

    @Override
    public Store createStore(StoreForm storeForm) {
        Store store = new Store();
        store.setName(storeForm.getName());
        return store;
    }
}
