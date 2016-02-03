/**
 * GenericHibernateDAOImpl.java
 * Fecha de creación: 22/04/2010, 17:51:20
 *
 * Copyright (c) 2010 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.hibernate.comun;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.criterion.Example;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;

/**
 * Clase base implementada para el acceso a base de datos con Hibernate 4
 * @author Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
 * @author Jorge Rodríguez Campos,actualizacion de código: 06/12/2012
 * @version 1.0
 * @since SIIRFE 5.1
 */
public abstract class GenericHibernateDAOImpl implements GenericHibernateDAO {

    @Resource
    private SessionFactory sessionFactory;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#get(java.lang.Class, long)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Serializable id) {

        return (T) getCurrentSession().get(clazz, id);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#get(java.lang.Class, java.lang.String, java.lang.String[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> clazz, String query, Object... params) {
        Query hqlQuery;
        hqlQuery = getCurrentSession().createQuery(query);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                hqlQuery.setParameter(i, params[i]);
            }
        }

        try {
            return (T) hqlQuery.uniqueResult();
        } catch (NonUniqueResultException e) {
            throw new IncorrectResultSizeDataAccessException(e.getMessage(), 1, e);
        }

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#load(java.lang.Class, long)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T load(Class<T> clazz, Serializable id) {
        return (T) getCurrentSession().load(clazz, id);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#find(java.lang.String, java.lang.Object[])
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> find(String query, Object... params) {

        Query hQuery = getCurrentSession().createQuery(query);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                hQuery.setParameter(i, params[i]);
            }
        }
        return hQuery.list();
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#findPaginado(java.lang.String, int, int, java.lang.Object[])
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findPaginado(String query, int paginaActual, int numFilas,
        Object... params) {
        SQLQuery sql;

        sql = getCurrentSession().createSQLQuery(query.toString());

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                sql.setParameter(i, params[i]);
            }
        }

        sql.setFirstResult(numFilas * (paginaActual - 1));
        sql.setMaxResults(numFilas);

        return sql.list();
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#queryForEntity(java.lang.String, java.lang.Object[])
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T queryForEntity(String query, Object... params) {

        Query hQuery = getCurrentSession().createQuery(query);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                hQuery.setParameter(i, params[i]);
            }
        }
        return (T) DataAccessUtils.requiredSingleResult(hQuery.list());
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#queryForEntity(java.lang.Object)
     */
    @Override
    public <T> T queryForEntity(T entityExample) {

        return DataAccessUtils.requiredSingleResult(queryByExample(entityExample));
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#queryForEntity(org.hibernate.criterion.Example, java.lang.Class)
     */
    @Override
    public <T> T queryForEntity(Example example, Class<T> clazz) {

        return DataAccessUtils.requiredSingleResult(queryByExample(example, clazz));
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#findAll(java.lang.Class)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> clazz) {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#save(java.io.Serializable)
     */
    @Override
    public void save(Serializable entity) {
        getCurrentSession().save(entity);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#saveOrUpdate(java.io.Serializable)
     */
    @Override
    public void saveOrUpdate(Serializable entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#merge(java.lang.Object)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T merge(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#update(java.lang.Object)
     */
    @Override
    public <T> void update(T entity) {
        getCurrentSession().update(entity);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#delete(java.lang.Object)
     */
    @Override
    public <T> void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#update(java.lang.String, java.lang.Object[])
     */
    @Override
    public int update(String query, Object... params) {

        Query hqlQuery = getCurrentSession().createQuery(query);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                hqlQuery.setParameter(i, params[i]);
            }
        }
        return hqlQuery.executeUpdate();

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#refresh(java.io.Serializable)
     */
    @Override
    public void refresh(Serializable entity) {
        getCurrentSession().refresh(entity);

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#queryByExample(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByExample(T entityExample) {

        Example example = Example.create(entityExample);
        return (List<T>) queryByExample(example, entityExample.getClass());

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#queryByExample(org.hibernate.criterion.Example)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByExample(Example example, Class<T> clazz) {
        return getCurrentSession().createCriteria(clazz).add(example).list();

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#construyeCriterio(java.lang.Class)
     */
    @Override
    public Criteria construyeCriteria(Class<?> clazz) {
        return getCurrentSession().createCriteria(clazz);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.org.ife.siirfe.comun.dao.hibernate.GenericHibernateDAO#flush()
     */
    @Override
    public void flush() {
        sessionFactory.getCurrentSession().flush();

    }

    /**
     * Obtiene la sesion actual, es decir, la mahejada por {@link CurrentSessionContext}
     * @autor Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
     * @return la sesion actual
     */
    protected final Session getCurrentSession() {

        if (sessionFactory.isClosed()) {
            sessionFactory.openSession();
        }

        return sessionFactory.getCurrentSession();
    }

}
