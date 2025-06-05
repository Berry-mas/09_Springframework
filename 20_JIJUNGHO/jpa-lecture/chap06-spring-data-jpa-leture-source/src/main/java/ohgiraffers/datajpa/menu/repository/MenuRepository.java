package ohgiraffers.datajpa.menu.repository;

import ohgiraffers.datajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
