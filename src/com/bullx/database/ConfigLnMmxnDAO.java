package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnMmxn entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnMmxn
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnMmxnDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnMmxnDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String AMP_TH = "ampTh";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnMmxn transientInstance) {
		log.debug("saving ConfigLnMmxn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnMmxn persistentInstance) {
		log.debug("deleting ConfigLnMmxn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnMmxn findById(java.lang.Integer id) {
		log.debug("getting ConfigLnMmxn instance with id: " + id);
		try {
			ConfigLnMmxn instance = (ConfigLnMmxn) getSession().get(
					"com.bullx.database.ConfigLnMmxn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnMmxn> findByExample(ConfigLnMmxn instance) {
		log.debug("finding ConfigLnMmxn instance by example");
		try {
			List<ConfigLnMmxn> results = (List<ConfigLnMmxn>) getSession()
					.createCriteria("com.bullx.database.ConfigLnMmxn")
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
		log.debug("finding ConfigLnMmxn instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnMmxn as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnMmxn> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnMmxn> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnMmxn> findByAmpTh(Object ampTh) {
		return findByProperty(AMP_TH, ampTh);
	}

	public List<ConfigLnMmxn> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnMmxn> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnMmxn instances");
		try {
			String queryString = "from ConfigLnMmxn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnMmxn merge(ConfigLnMmxn detachedInstance) {
		log.debug("merging ConfigLnMmxn instance");
		try {
			ConfigLnMmxn result = (ConfigLnMmxn) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnMmxn instance) {
		log.debug("attaching dirty ConfigLnMmxn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnMmxn instance) {
		log.debug("attaching clean ConfigLnMmxn instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}