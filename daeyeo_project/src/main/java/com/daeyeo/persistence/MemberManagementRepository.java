package com.daeyeo.persistence;


import com.daeyeo.entity.MemberManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MemberManagementRepository extends JpaRepository<MemberManagement,String> {
    public List<MemberManagement> findAll();
}
