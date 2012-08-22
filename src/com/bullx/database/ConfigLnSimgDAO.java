package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigLnSimg entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigLnSimg
 * @author MyEclipse Persistence Tools
 */

public class ConfigLnSimgDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigLnSimgDAO.class);
	// property constants
	public static final String IS_USE = "isUse";
	public static final String LN_INST = "lnInst";
	public static final String DEN_TH = "denTh";
	public static final String MST_TH = "mstTh";
	public static final String LOCATE_X = "locateX";
	public static final String LOCATE_Y = "locateY";

	public void save(ConfigLnSimg transientInstance) {
		log.debug("saving ConfigLnSimg instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigLnSimg persistentInstance) {
		log.debug("deleting ConfigLnSimg instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigLnSimg findById(java.lang.Integer id) {
		log.debug("getting ConfigLnSimg instance with id: " + id);
		try {
			ConfigLnSimg instance = (ConfigLnSimg) getSession().get(
					"com.bullx.database.ConfigLnSimg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigLnSimg> findByExample(ConfigLnSimg instance) {
		log.debug("finding ConfigLnSimg instance by example");
		try {
			List<ConfigLnSimg> results = (List<ConfigLnSimg>) getSession()
					.createCriteria("com.bullx.database.ConfigLnSimg")
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
		log.debug("finding ConfigLnSimg instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConfigLnSimg as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigLnSimg> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigLnSimg> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigLnSimg> findByDenTh(Object denTh) {
		return findByProperty(DEN_TH, denTh);
	}

	public List<ConfigLnSimg> findByMstTh(Object mstTh) {
		return findByProperty(MST_TH, mstTh);
	}

	public List<ConfigLnSimg> findByLocateX(Object locateX) {
		return findByProperty(LOCATE_X, locateX);
	}

	public List<ConfigLnSimg> findByLocateY(Object locateY) {
		return findByProperty(LOCATE_Y, locateY);
	}

	public List findAll() {
		log.debug("finding all ConfigLnSimg instances");
		try {
			String queryString = "from ConfigLnSimg";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigLnSimg merge(ConfigLnSimg detachedInstance) {
		log.debug("merging ConfigLnSimg instance");
		try {
			ConfigLnSimg result = (ConfigLnSimg) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigLnSimg instance) {
		log.debug("attaching dirty ConfigLnSimg instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigLnSimg instance) {
		log.debug("attaching clean ConfigLnSimg instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}