package cn.liuyiyou.springboot.sql.jpa.repository;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/4
 * @version: V1.0
 */
public class NextSimpleJpaReository<T, ID> extends SimpleJpaRepository<T, ID>  {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;

    @Autowired
    public NextSimpleJpaReository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }

    public List<T> pageList(final Example<T> example, final Pageable pageable) {
        Class<T> probeType = example.getProbeType();
        TypedQuery<T> query = getQuery(new ExampleSpecification<>(example, EscapeCharacter.DEFAULT), probeType, pageable);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    public List<T> pageList(Specification<T> spec, Pageable pageable) {
        TypedQuery<T> query = getQuery(spec, pageable);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    public Long pageCount(Specification<T> spec,Pageable pageable) {
        TypedQuery<Long> query = getCountQuery(spec, getDomainClass());
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(1001);
        return query.getSingleResult();
    }


    public Long pageCount(final Example<T> example) {
        ExampleSpecification<T> spec = new ExampleSpecification<>(example, EscapeCharacter.DEFAULT);
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        return em.createQuery(query).getSingleResult();
    }

    private <T> Root<T> applySpecificationToCriteria(Specification<T> spec, Class<T> domainClass,
        CriteriaQuery<T> query) {

        Assert.notNull(domainClass, "Domain class must not be null!");
        Assert.notNull(query, "CriteriaQuery must not be null!");

        Root<T> root = query.from(domainClass);

        if (spec == null) {
            return root;
        }

        CriteriaBuilder builder = em.getCriteriaBuilder();
        Predicate predicate = spec.toPredicate(root, query, builder);

        if (predicate != null) {
            query.where(predicate);
        }

        return root;
    }

    private static long executeCountQuery(TypedQuery<Long> query) {

        Assert.notNull(query, "TypedQuery must not be null!");

        List<Long> totals = query.getResultList();
        long total = 0L;

        for (Long element : totals) {
            total += element == null ? 0 : element;
        }

        return total;
    }


    private static class ExampleSpecification<T> implements Specification<T> {

        private static final long serialVersionUID = 1L;

        private final Example<T> example;
        private final EscapeCharacter escapeCharacter;

        /**
         * Creates new {@link SimpleJpaRepository.ExampleSpecification}.
         */
        ExampleSpecification(Example<T> example, EscapeCharacter escapeCharacter) {

            Assert.notNull(example, "Example must not be null!");
            Assert.notNull(escapeCharacter, "EscapeCharacter must not be null!");

            this.example = example;
            this.escapeCharacter = escapeCharacter;
        }

        /*
         * (non-Javadoc)
         * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
         */
        @Override
        public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            return QueryByExamplePredicateBuilder.getPredicate(root, cb, example, escapeCharacter);
        }
    }
}
