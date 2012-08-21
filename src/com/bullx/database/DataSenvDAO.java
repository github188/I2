package com.bullx.database;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * DataSenv entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataSenv
 * @author MyEclipse Persistence Tools
 */

public class DataSenvDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataSenvDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String ENV_TMP = "envTmp";
	public static final String ENV_HUM = "envHum";

	public void save(DataSenv transientInstance) {
		log.debug("saving DataSenv instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataSenv persistentInstance) {
		log.debug("deleting DataSenv instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataSenv findById(java.lang.Long id) {
		log.debug("getting DataSenv instance with id: " + id);
		try {
			DataSenv instance = (DataSenv) getSession().get(
					"com.bullx.database.DataSenv", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataSenv> findByExample(DataSenv instance) {
		log.debug("finding DataSenv instance by example");
		try {
			List<DataSenv> results = (List<DataSenv>) getSession()
					.createCriteria("com.bullx.database.DataSenv")
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
		log.debug("finding DataSenv instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataSenv as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataSenv> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataSenv> findByEnvTmp(Object envTmp) {
		return findByProperty(ENV_TMP, envTmp);
	}

	public List<DataSenv> findByEnvHum(Object envHum) {
		return findByProperty(ENV_HUM, envHum);
	}

	public List findAll() {
		log.debug("finding all DataSenv instances");
		try {
			String queryString = "from DataSenv";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataSenv merge(DataSenv detachedInstance) {
		log.debug("merging DataSenv instance");
		try {
			DataSenv result = (DataSenv) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataSenv instance) {
		log.debug("attaching dirty DataSenv instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataSenv instance) {
		log.debug("attaching clean DataSenv instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}