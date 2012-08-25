package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnSpdc entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnSpdc
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnSpdcDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnSpdcDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String PA_DSCH_TH = "paDschTh";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnSpdc transientInstance) {
		log.debug("saving ConfigLnSpdc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnSpdc persistentInstance) {
		log.debug("deleting ConfigLnSpdc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnSpdc findById(java.lang.Integer id) {
		log.debug("getting ConfigLnSpdc instance with id: " + id);
		try {
			ConfigLnSpdc instance = (ConfigLnSpdc) getSession().get(
					"com.bullx.database.ConfigLnSpdc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnSpdc> findByExample(ConfigLnSpdc instance) {
		log.debug("finding ConfigLnSpdc instance by example");
		try {
			List<ConfigLnSpdc> results = (List<ConfigLnSpdc>) getSession()
					.createCriteria("com.bullx.database.ConfigLnSpdc")
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
		log.debug("finding ConfigLnSpdc instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnSpdc as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnSpdc> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnSpdc> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnSpdc> findByPaDschTh(Object paDschTh) {
		return findByProperty(PA_DSCH_TH, paDschTh);
	}

	public List<ConfigLnSpdc> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnSpdc> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnSpdc instances");
		try {
			String queryString = "from ConfigLnSpdc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnSpdc merge(ConfigLnSpdc detachedInstance) {
		log.debug("merging ConfigLnSpdc instance");
		try {
			ConfigLnSpdc result = (ConfigLnSpdc) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnSpdc instance) {
		log.debug("attaching dirty ConfigLnSpdc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnSpdc instance) {
		log.debug("attaching clean ConfigLnSpdc instance");
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
	public ConfigLnSpdc getLatestInstance(){
		try {
			String queryString = "from ConfigLnSpdc";
			Query queryObject = getSession().createQuery(queryString);
			List<ConfigLnSpdc> list = queryObject.list();
			if (list.size() < 1) throw new RuntimeException("No ConfigLnSpdc found!");
			if (list.size() > 1) log.warn("ConfigLnSpdc has multiply numbers!");
			return list.get(list.size() - 1);
		} catch (RuntimeException er) {
			log.error("No instance of ConfigLnSpdc found", er);
			throw er;
		}
	}
}