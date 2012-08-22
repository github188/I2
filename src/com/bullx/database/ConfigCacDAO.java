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
 * ConfigCac entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigCac
 * @author MyEclipse Persistence Tools
 */

public class ConfigCacDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigCacDAO.class);
	// property constants
	public static final String CAC_IP = "cacIp";
	public static final String CAGIP = "cagip";
	public static final String OPER_TEMP = "operTemp";
	public static final String DATA_PERIOD = "dataPeriod";
	public static final String HEARTBEAT_PERIOD = "heartbeatPeriod";

	public void save(ConfigCac transientInstance) {
		log.debug("saving ConfigCac instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigCac persistentInstance) {
		log.debug("deleting ConfigCac instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigCac findById(java.lang.String id) {
		log.debug("getting ConfigCac instance with id: " + id);
		try {
			ConfigCac instance = (ConfigCac) getSession().get(
					"com.bullx.database.ConfigCac", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigCac> findByExample(ConfigCac instance) {
		log.debug("finding ConfigCac instance by example");
		try {
			List<ConfigCac> results = (List<ConfigCac>) getSession()
					.createCriteria("com.bullx.database.ConfigCac")
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
		log.debug("finding ConfigCac instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ConfigCac as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigCac> findByCacIp(Object cacIp) {
		return findByProperty(CAC_IP, cacIp);
	}

	public List<ConfigCac> findByCagip(Object cagip) {
		return findByProperty(CAGIP, cagip);
	}

	public List<ConfigCac> findByOperTemp(Object operTemp) {
		return findByProperty(OPER_TEMP, operTemp);
	}

	public List<ConfigCac> findByDataPeriod(Object dataPeriod) {
		return findByProperty(DATA_PERIOD, dataPeriod);
	}

	public List<ConfigCac> findByHeartbeatPeriod(Object heartbeatPeriod) {
		return findByProperty(HEARTBEAT_PERIOD, heartbeatPeriod);
	}

	public List findAll() {
		log.debug("finding all ConfigCac instances");
		try {
			String queryString = "from ConfigCac";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigCac merge(ConfigCac detachedInstance) {
		log.debug("merging ConfigCac instance");
		try {
			ConfigCac result = (ConfigCac) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigCac instance) {
		log.debug("attaching dirty ConfigCac instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigCac instance) {
		log.debug("attaching clean ConfigCac instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}