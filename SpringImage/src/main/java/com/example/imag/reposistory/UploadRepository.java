
package com.example.imag.reposistory;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.imag.model.Image;

@Repository 
public interface UploadRepository  extends JpaRepository<Image, Integer>{
	Optional<Image> findByEmail(String email);

}