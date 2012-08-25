package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnSenv entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnSenv
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnSenvDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnSenvDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnSenv transientInstance) {
		log.debug("saving ConfigLnSenv instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnSenv persistentInstance) {
		log.debug("deleting ConfigLnSenv instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnSenv findById(java.lang.Integer id) {
		log.debug("getting ConfigLnSenv instance with id: " + id);
		try {
			ConfigLnSenv instance = (ConfigLnSenv) getSession().get(
					"com.bullx.database.ConfigLnSenv", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnSenv> findByExample(ConfigLnSenv instance) {
		log.debug("finding ConfigLnSenv instance by example");
		try {
			List<ConfigLnSenv> results = (List<ConfigLnSenv>) getSession()
					.createCriteria("com.bullx.database.ConfigLnSenv")
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
		log.debug("finding ConfigLnSenv instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnSenv as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnSenv> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnSenv> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnSenv> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnSenv> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnSenv instances");
		try {
			String queryString = "from ConfigLnSenv";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnSenv merge(ConfigLnSenv detachedInstance) {
		log.debug("merging ConfigLnSenv instance");
		try {
			ConfigLnSenv result = (ConfigLnSenv) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnSenv instance) {
		log.debug("attaching dirty ConfigLnSenv instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnSenv instance) {
		log.debug("attaching clean ConfigLnSenv instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/*
	 * 
	 * This class returns the latest instance in the database
	 */
	public ConfigLnSenv getLatestInstance(){
		try {
			String queryString = "from ConfigLnSenv";
			Query queryObject = getSession().createQuery(queryString);
			List<ConfigLnSenv> list = queryObject.list();
			if (list.size() < 1) throw new RuntimeException("No ConfigLnSenv found!");
			if (list.size() > 1) log.warn("ConfigLnSenv has multiply numbers!");
			return list.get(list.size() - 1);
		} catch (RuntimeException er) {
			log.error("No instance of ConfigCac found", er);
			throw er;
		}
	}
}