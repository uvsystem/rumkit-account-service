package com.dbsys.rs.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<com.dbsys.rs.account.entity.Token, String> {

	/**
	 * Kunci token.
	 * 
	 * @param tokenString
	 * @param lock
	 */
	@Modifying
	@Query("UPDATE Token token SET token.status = :status WHERE token.kode = :kode")
	void updateStatus(@Param("kode") String kode, @Param("status") com.dbsys.rs.account.entity.Token.StatusToken status);

}
