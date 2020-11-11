package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/10
 * @version: V1.0
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    private final EntityManager entityManager;

    public List<Item> list() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
        final Root<Item> root = query.from(Item.class);
        query.select(root)
            .where(criteriaBuilder.gt(root.get("itemPrice"), 1000),
            criteriaBuilder.lt(root.get("itemPrice"), 1000),
            criteriaBuilder.like(root.get("itemName"), "%chair%"),
            criteriaBuilder.between(root.get("itemPrice"), 100, 200),
            criteriaBuilder.isNull(root.get("itemDescription")),
            criteriaBuilder.isNotNull(root.get("itemDescription")))
            .orderBy(criteriaBuilder.asc(root.get("itemName")),
                criteriaBuilder.desc(root.get("itemPrice")));
        final TypedQuery<Item> tradeQuery = entityManager.createQuery(query);
        return tradeQuery.getResultList();
    }
}
