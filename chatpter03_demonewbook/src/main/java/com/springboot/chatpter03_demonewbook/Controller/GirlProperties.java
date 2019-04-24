package com.springboot.chatpter03_demonewbook.Controller;


import com.springboot.chatpter03_demonewbook.Object.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlProperties extends JpaRepository<Girl, Long> {


}
