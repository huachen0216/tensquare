package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "select * from tb_problem tpb, tb_pl tpl where tpb.id = tpl.problemid and tpl.labelid = ? order " +
            "by tpb.replytime DESC", nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem tpb, tb_pl tpl where tpb.id = tpl.problemid and tpl.labelid = ? order " +
            "by tpb.reply DESC", nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem tpb, tb_pl tpl where tpb.id = tpl.problemid and tpl.labelid = ? and " +
            "reply = 0 order by tpb.createtime DESC", nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
}
