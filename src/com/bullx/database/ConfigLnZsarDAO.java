package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnZsar entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnZsar
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnZsarDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnZsarDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String TOT_ATH = "totAth";
	public static final String RIS_ATH = "risAth";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnZsar transientInstance) {
		log.debug("saving ConfigLnZsar instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnZsar persistentInstance) {
		log.debug("deleting ConfigLnZsar instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnZsar findById(java.lang.Integer id) {
		log.debug("getting ConfigLnZsar instance with id: " + id);
		try {
			ConfigLnZsar instance = (ConfigLnZsar) getSession().get(
					"com.bullx.database.ConfigLnZsar", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnZsar> findByExample(ConfigLnZsar instance) {
		log.debug("finding ConfigLnZsar instance by example");
		try {
			List<ConfigLnZsar> results = (List<ConfigLnZsar>) getSession()
					.createCriteria("com.bullx.database.ConfigLnZsar")
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
		log.debug("finding ConfigLnZsar instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnZsar as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnZsar> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnZsar> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnZsar> findByTotAth(Object totAth) {
		return findByProperty(TOT_ATH, totAth);
	}

	public List<ConfigLnZsar> findByRisAth(Object risAth) {
		return findByProperty(RIS_ATH, risAth);
	}

	public List<ConfigLnZsar> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnZsar> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnZsar instances");
		try {
			String queryString = "from ConfigLnZsar";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnZsar merge(ConfigLnZsar detachedInstance) {
		log.debug("merging ConfigLnZsar instance");
		try {
			ConfigLnZsar result = (ConfigLnZsar) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnZsar instance) {
		log.debug("attaching dirty ConfigLnZsar instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnZsar instance) {
		log.debug("attaching clean ConfigLnZsar instance");
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
	public ConfigLnZsar getLatestInstance(){
		try {
			String queryString = "from ConfigLnZsar";
			Query queryObject = getSession().createQuery(queryString);
			List<ConfigLnZsar> list = queryObject.list();
			if (list.size() < 1) throw new RuntimeException("No ConfigLnZsar found!");
			if (list.size() > 1) log.warn("ConfigLnZsar has multiply numbers!");
			return list.get(list.size() - 1);
		} catch (RuntimeException er) {
			log.error("No instance of ConfigLnZsar found", er);
			throw er;
		}
	}
}