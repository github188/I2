package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnSiml entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnSiml
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnSimlDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnSimlDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String H2TH = "h2th";
	public static final String C2H2TH = "c2h2th";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnSiml transientInstance) {
		log.debug("saving ConfigLnSiml instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnSiml persistentInstance) {
		log.debug("deleting ConfigLnSiml instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnSiml findById(java.lang.Integer id) {
		log.debug("getting ConfigLnSiml instance with id: " + id);
		try {
			ConfigLnSiml instance = (ConfigLnSiml) getSession().get(
					"com.bullx.database.ConfigLnSiml", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnSiml> findByExample(ConfigLnSiml instance) {
		log.debug("finding ConfigLnSiml instance by example");
		try {
			List<ConfigLnSiml> results = (List<ConfigLnSiml>) getSession()
					.createCriteria("com.bullx.database.ConfigLnSiml")
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
		log.debug("finding ConfigLnSiml instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnSiml as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnSiml> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnSiml> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnSiml> findByH2th(Object h2th) {
		return findByProperty(H2TH, h2th);
	}

	public List<ConfigLnSiml> findByC2h2th(Object c2h2th) {
		return findByProperty(C2H2TH, c2h2th);
	}

	public List<ConfigLnSiml> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnSiml> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnSiml instances");
		try {
			String queryString = "from ConfigLnSiml";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnSiml merge(ConfigLnSiml detachedInstance) {
		log.debug("merging ConfigLnSiml instance");
		try {
			ConfigLnSiml result = (ConfigLnSiml) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnSiml instance) {
		log.debug("attaching dirty ConfigLnSiml instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnSiml instance) {
		log.debug("attaching clean ConfigLnSiml instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}