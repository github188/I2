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
 * DataZsar entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataZsar
 * @author MyEclipse Persistence Tools
 */

public class DataZsarDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataZsarDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String SYS_VOL = "sysVol";
	public static final String TOT_A = "totA";
	public static final String RIS_A = "risA";
	public static final String ACT_COUNT = "actCount";
	public static final String ALM = "alm";

	public void save(DataZsar transientInstance) {
		log.debug("saving DataZsar instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataZsar persistentInstance) {
		log.debug("deleting DataZsar instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataZsar findById(java.lang.Integer id) {
		log.debug("getting DataZsar instance with id: " + id);
		try {
			DataZsar instance = (DataZsar) getSession().get(
					"com.bullx.database.DataZsar", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataZsar> findByExample(DataZsar instance) {
		log.debug("finding DataZsar instance by example");
		try {
			List<DataZsar> results = (List<DataZsar>) getSession()
					.createCriteria("com.bullx.database.DataZsar")
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
		log.debug("finding DataZsar instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataZsar as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataZsar> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataZsar> findBySysVol(Object sysVol) {
		return findByProperty(SYS_VOL, sysVol);
	}

	public List<DataZsar> findByTotA(Object totA) {
		return findByProperty(TOT_A, totA);
	}

	public List<DataZsar> findByRisA(Object risA) {
		return findByProperty(RIS_A, risA);
	}

	public List<DataZsar> findByActCount(Object actCount) {
		return findByProperty(ACT_COUNT, actCount);
	}

	public List<DataZsar> findByAlm(Object alm) {
		return findByProperty(ALM, alm);
	}

	public List findAll() {
		log.debug("finding all DataZsar instances");
		try {
			String queryString = "from DataZsar";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataZsar merge(DataZsar detachedInstance) {
		log.debug("merging DataZsar instance");
		try {
			DataZsar result = (DataZsar) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataZsar instance) {
		log.debug("attaching dirty DataZsar instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataZsar instance) {
		log.debug("attaching clean DataZsar instance");
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
	public DataZsar getLatestInstance(int inst){
		try {
			String queryString = "from DataZsar as inst where inst.lnInst=? order by inst.dataTime desc";
			Query qb = getSession().createQuery(queryString);
			qb.setFirstResult(0);
			qb.setMaxResults(1);
			List<DataZsar> list = qb.list();
			if (list.size() < 1) throw new RuntimeException("No DataZsar found!");
			return list.get(list.size() - 1);
		} catch (RuntimeException er) {
			log.error("No instance of DataZsar found", er);
			throw er;
		}
	}
}