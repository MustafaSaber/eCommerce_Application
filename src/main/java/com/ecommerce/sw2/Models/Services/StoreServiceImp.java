package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.*;
//import com.ecommerce.sw2.Models.Domain.StoreOwner;
import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ActionRepository actionRepository;

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
    public Store createStore(StoreForm storeForm)
    {
        Store store = new Store();
        store.setName(storeForm.getName());
        Optional<User> temp = userRepository.findOneByUsername(storeForm.getStore_owner_name());

        if(temp.isPresent())
        {
            User user = temp.get();
            if(!user.getRole().contains(Role.STORE_OWNER))
                user.addRole(Role.STORE_OWNER);

            /*
            if(user.getStoreOwner() == null)
            {
                StoreOwner storeOwner = new StoreOwner(user);
                //storeOwner.setId((long) 5);
                user.setStoreOwner(storeOwner);
                //user.getStoreOwner().setUser(user);
                System.out.println(user.getStoreOwner().getId() + " WTF");
            }
            System.out.println(user.getId() + " Im not null " );
            */
            user.addstore(store);
            user = userRepository.save(user);
            store.setStoreOwner(user);
        }
        return storeRepository.save(store);
    }

    @Override
    public Store acceptStore(String name) {
        Optional<Store> s = (storeRepository.findOneByName(name));
        if (!s.isPresent())
            return null;
        s.get().setSuggested(true);
        storeRepository.save(s.get());
        return s.get();
    }

    @Override
    public Collection<Store> getStoresByUsername(RegisterForm form)
    {
        Optional<User> user = userService.getUserByUsername(form.getUsername());
        return storeRepository.findByStoreOwner_Id(user.get().getId());
    }

    @Override
    public Collection<Store> getStoresforStoreOwner(RegisterForm form) {
        /*
        This will handle returning all stores of the user, his stores and collaborated stores.
         */
        Optional<User> user = userService.getUserByUsername(form.getUsername());
        Collection<Store> stores = storeRepository.findByStoreOwner_IdAndAndSuggested(user.get().getId() , true);
        Collection<Store> stores1 = new ArrayList<>();
        for(Store store: stores)
        {
            Store s = new Store();
            s.setName(store.getName());
            s.setStoreOwner(s.getStoreOwner());
            stores1.add(s);
        }
        for(Store store: user.get().getCollaboratedStores())
        {
            Store s = new Store();
            s.setName(store.getName());
            s.setStoreOwner(s.getStoreOwner());
            stores1.add(s);
        }

        return stores1;
    }

    @Override
    public Collection<Store> getStoresforAdmin(RegisterForm form) {
        Optional<User> user = userService.getUserByUsername(form.getUsername());
        return storeRepository.findBySuggested(false);
    }

    @Override
    public User addcollab(String username, String storename)
    {
        //System.out.println("Im here");
        Optional<Store> store = getStoreByName(storename);
        Optional<User> collabuser = userService.getUserByUsername(username);
        if(store.isPresent() && collabuser.isPresent())
        {
            //System.out.println("YES");
            Store currstore = store.get();
            User collab = collabuser.get();
            if(collab.getCollaboratedStores().contains(currstore))
                return null;
            collab.AddCollaboratedStore(currstore);
            currstore.addCollaborator(collab);
            if(!collab.getRole().contains(Role.STORE_OWNER))
                collab.addRole(Role.STORE_OWNER);
            storeRepository.save(currstore);
            return userRepository.save(collab);
        }
        return null;
    }

    @Override
    public Collection<User> viewcollab(String storename) {
        Optional<Store> s = (storeRepository.findOneByName(storename));
        if (!s.isPresent())
            return null;
        return s.get().getCollaborators();
    }

    @Override
    public Collection<ActionHistory> viewactions(String storename) {
        Optional<Store> s = (storeRepository.findOneByName(storename));
        if (!s.isPresent())
            return null;
        Collection<Action> actions = s.get().getActions();
        Collection<ActionHistory> ac = new ArrayList<ActionHistory>();


        for(Action action:actions)
        {
            ActionHistory ah = new ActionHistory();
            System.out.println("id = "+ action.getId());
            ah.setId(action.getId());

            if(action instanceof RemoveProduct)
                ah.setAction_type("remove product");
            else if(action instanceof AddProduct)
                ah.setAction_type("add product");
            else if(action instanceof EditProduct)
                ah.setAction_type("edit product");

            ah.setProduct_backup_id(action.getProductBackup().getMy_id());
            ah.setProduct_name(action.getProductBackup().getName());

            ac.add(ah);
        }
        return  ac;
    }
}
