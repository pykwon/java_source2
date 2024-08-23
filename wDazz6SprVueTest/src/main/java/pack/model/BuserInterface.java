package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Buser;

public interface BuserInterface extends JpaRepository<Buser, String> {

}
