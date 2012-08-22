package com.bullx.database;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConfigIed entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.ConfigIed
 * @author MyEclipse Persistence Tools
 */

public class ConfigIedDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigIedDAO.class);
	// property constants
	public static final String IED_IP = "iedIp";
	public static final String STATUS = "status";
	public static final String OPER_TEMP = "operTemp";
	public static final String PHASE = "phase";
	public static final String IS_USE = "isUse";
	public static final String IED_NAME = "iedName";
	public static final String IED_NAME_CN = "iedNameCn";
	public static final String LD_NAME = "ldName";
	public static final String LD_NAME_CN = "ldNameCn";
	public static final String LN_PREFIX = "lnPrefix";
	public static final String LN_PREFIX_CN = "lnPrefixCn";
	public static final String LN_CLASS = "lnClass";
	public static final String LN_CLASS_CN = "lnClassCn";
	public static final String LN_INST = "lnInst";
	public static final String LN_INST_CN = "lnInstCn";
	public static final String SMP_PROD = "smpProd";

	public void save(ConfigIed transientInstance) {
		log.debug("saving ConfigIed instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConfigIed persistentInstance) {
		log.debug("deleting ConfigIed instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigIed findById(java.lang.String id) {
		log.debug("getting ConfigIed instance with id: " + id);
		try {
			ConfigIed instance = (ConfigIed) getSession().get(
					"com.bullx.database.ConfigIed", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ConfigIed> findByExample(ConfigIed instance) {
		log.debug("finding ConfigIed instance by example");
		try {
			List<ConfigIed> results = (List<ConfigIed>) getSession()
					.createCriteria("com.bullx.database.ConfigIed")
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
		log.debug("finding ConfigIed instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ConfigIed as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ConfigIed> findByIedIp(Object iedIp) {
		return findByProperty(IED_IP, iedIp);
	}

	public List<ConfigIed> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<ConfigIed> findByOperTemp(Object operTemp) {
		return findByProperty(OPER_TEMP, operTemp);
	}

	public List<ConfigIed> findByPhase(Object phase) {
		return findByProperty(PHASE, phase);
	}

	public List<ConfigIed> findByIsUse(Object isUse) {
		return findByProperty(IS_USE, isUse);
	}

	public List<ConfigIed> findByIedName(Object iedName) {
		return findByProperty(IED_NAME, iedName);
	}

	public List<ConfigIed> findByIedNameCn(Object iedNameCn) {
		return findByProperty(IED_NAME_CN, iedNameCn);
	}

	public List<ConfigIed> findByLdName(Object ldName) {
		return findByProperty(LD_NAME, ldName);
	}

	public List<ConfigIed> findByLdNameCn(Object ldNameCn) {
		return findByProperty(LD_NAME_CN, ldNameCn);
	}

	public List<ConfigIed> findByLnPrefix(Object lnPrefix) {
		return findByProperty(LN_PREFIX, lnPrefix);
	}

	public List<ConfigIed> findByLnPrefixCn(Object lnPrefixCn) {
		return findByProperty(LN_PREFIX_CN, lnPrefixCn);
	}

	public List<ConfigIed> findByLnClass(Object lnClass) {
		return findByProperty(LN_CLASS, lnClass);
	}

	public List<ConfigIed> findByLnClassCn(Object lnClassCn) {
		return findByProperty(LN_CLASS_CN, lnClassCn);
	}

	public List<ConfigIed> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<ConfigIed> findByLnInstCn(Object lnInstCn) {
		return findByProperty(LN_INST_CN, lnInstCn);
	}

	public List<ConfigIed> findBySmpProd(Object smpProd) {
		return findByProperty(SMP_PROD, smpProd);
	}

	public List findAll() {
		log.debug("finding all ConfigIed instances");
		try {
			String queryString = "from ConfigIed";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConfigIed merge(ConfigIed detachedInstance) {
		log.debug("merging ConfigIed instance");
		try {
			ConfigIed result = (ConfigIed) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigIed instance) {
		log.debug("attaching dirty ConfigIed instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigIed instance) {
		log.debug("attaching clean ConfigIed instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}