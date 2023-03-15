package jp.co.sss.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sss.training.entity.Food;


public interface FoodRepository extends JpaRepository<Food, Integer> {
	@Query("SELECT f FROM Food f WHERE f.name LIKE %:keyword%")
	public List<Food> findByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT count(f.id) FROM Food f")
	public int countFoodNumber();
	
	Food findById(int id);
}
