package com.example.supplierManagement;

import org.springframework.data.jpa.repository.JpaRepository;
//crud function defien clz gannawa
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

	
}
