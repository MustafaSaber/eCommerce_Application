package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Store;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;

import java.util.Collection;
import java.util.Optional;

public interface StoreService {
    Optional<Store> getStoreByName(String name);
    Collection<Store> getStoresAccepted(Boolean check);

    //Add store as a suggested one till the admin approve it
    Store createStore(StoreForm storeForm);

    //
    Store acceptStore(Long id);
    Collection<Store> getStoresByUsername(RegisterForm form);
}

