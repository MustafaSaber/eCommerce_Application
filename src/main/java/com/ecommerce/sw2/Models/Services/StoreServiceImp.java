package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.Store;
import com.ecommerce.sw2.Models.Domain.StoreOwner;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.StoreForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

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
        Optional<User> temp = userRepository.findOneByUsername(storeForm.getStore_owner_name());
        if(temp.isPresent())
        {
            if(!temp.get().getRole().contains(Role.STORE_OWNER))
                temp.get().addRole(Role.STORE_OWNER);

            if(temp.get().getStoreOwner() == null)
            {
                temp.get().setStoreOwner(new StoreOwner());
                temp.get().getStoreOwner().setUser(temp.get());
            }

            store.setStoreOwner(temp.get().getStoreOwner());
        }
        return storeRepository.save(store);
    }

    @Override
    public Store acceptStore(Long id) {
        Optional<Store> s = (storeRepository.findStoreById(id));
        if (!s.isPresent())
            return null;
        s.get().setSuggested(true);
        storeRepository.save(s.get());
        return s.get();
    }


}
