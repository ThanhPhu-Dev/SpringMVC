package cf.dinhthanhphu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cf.dinhthanhphu.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
