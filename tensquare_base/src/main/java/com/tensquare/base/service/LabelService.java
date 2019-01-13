package com.tensquare.base.service;

import com.fathua.util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huachen
 * @create 2018-12-09 13:59
 */

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             *
             * @param root  根对象
             * @param query 封装查询关键字
             * @param cb    封装查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate =
                            cb.like(root.get("labelname").as(String.class),
                                    "%" + label.getLabelname() + "%");// labelname like '%小明%'
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate =
                            cb.like(root.get("state").as(String.class),
                                    label.getState() + "%");// state = "1"
                    list.add(predicate);
                }
                Predicate[] parr =
                        list.toArray(new Predicate[list.size()]);
                return cb.and(parr);

            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        // 封装分页对象
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             *
             * @param root  根对象
             * @param query 封装查询关键字
             * @param cb    封装查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate =
                            cb.like(root.get("labelname").as(String.class),
                                    "%" + label.getLabelname() + "%");// labelname like '%小明%'
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate =
                            cb.like(root.get("state").as(String.class),
                                    label.getState() + "%");// state = "1"
                    list.add(predicate);
                }
                Predicate[] parr =
                        list.toArray(new Predicate[list.size()]);
                return cb.and(parr);
            }
        }, pageable);
    }
}
