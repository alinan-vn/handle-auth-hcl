package org.hcl.handleauthentication.crudRepository;

import org.hcl.handleauthentication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepo extends CrudRepository<UserEntity, Long>{

}
