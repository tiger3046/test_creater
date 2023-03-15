package jp.co.sss.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.training.entity.TrainingUser;

public interface UserRepository extends JpaRepository<TrainingUser, Long> {
	TrainingUser findByUserIdAndPassword(String userId,String password);
	TrainingUser findById(int id);
}
