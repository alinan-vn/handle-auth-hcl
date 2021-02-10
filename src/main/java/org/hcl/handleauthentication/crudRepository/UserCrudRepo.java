package org.hcl.handleauthentication.crudRepository;

import org.hcl.handleauthentication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserCrudRepo extends CrudRepository<UserEntity, Long>{
	
	public UserEntity findByName(String name);

}
