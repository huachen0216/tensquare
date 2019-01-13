package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author huachen
 * @create 2018-12-09 13:58
 */

public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
