package cf.dinhthanhphu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cf.dinhthanhphu.entity.NewEntity;

//JpaRepository 2 đối số là class và primary key của class đó
public interface NewRepository extends JpaRepository<NewEntity, Long>{

}
