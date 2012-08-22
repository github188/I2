package com.bullx.database;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * EquipmentInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.EquipmentInfo
 * @author MyEclipse Persistence Tools
 */

public class EquipmentInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EquipmentInfoDAO.class);
	// property constants
	public static final String EQ_TYPE = "eqType";
	public static final String EQ_NAME = "eqName";

	public void save(EquipmentInfo transientInstance) {
		log.debug("saving EquipmentInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EquipmentInfo persistentInstance) {
		log.debug("deleting EquipmentInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EquipmentInfo findById(java.lang.String id) {
		log.debug("getting EquipmentInfo instance with id: " + id);
		try {
			EquipmentInfo instance = (EquipmentInfo) getSession().get(
					"com.bullx.database.EquipmentInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<EquipmentInfo> findByExample(EquipmentInfo instance) {
		log.debug("finding EquipmentInfo instance by example");
		try {
			List<EquipmentInfo> results = (List<EquipmentInfo>) getSession()
					.createCriteria("com.bullx.database.EquipmentInfo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EquipmentInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EquipmentInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<EquipmentInfo> findByEqType(Object eqType) {
		return findByProperty(EQ_TYPE, eqType);
	}

	public List<EquipmentInfo> findByEqName(Object eqName) {
		return findByProperty(EQ_NAME, eqName);
	}

	public List findAll() {
		log.debug("finding all EquipmentInfo instances");
		try {
			String queryString = "from EquipmentInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EquipmentInfo merge(EquipmentInfo detachedInstance) {
		log.debug("merging EquipmentInfo instance");
		try {
			EquipmentInfo result = (EquipmentInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EquipmentInfo instance) {
		log.debug("attaching dirty EquipmentInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EquipmentInfo instance) {
		log.debug("attaching clean EquipmentInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}