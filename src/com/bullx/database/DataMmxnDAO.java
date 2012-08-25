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
 * DataMmxn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataMmxn
 * @author MyEclipse Persistence Tools
 */

public class DataMmxnDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataMmxnDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String AMP = "amp";
	public static final String AMP_ALM = "ampAlm";
	public static final String RECORD_WAVE = "recordWave";

	public void save(DataMmxn transientInstance) {
		log.debug("saving DataMmxn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataMmxn persistentInstance) {
		log.debug("deleting DataMmxn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataMmxn findById(java.lang.Long id) {
		log.debug("getting DataMmxn instance with id: " + id);
		try {
			DataMmxn instance = (DataMmxn) getSession().get(
					"com.bullx.database.DataMmxn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataMmxn> findByExample(DataMmxn instance) {
		log.debug("finding DataMmxn instance by example");
		try {
			List<DataMmxn> results = (List<DataMmxn>) getSession()
					.createCriteria("com.bullx.database.DataMmxn")
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
		log.debug("finding DataMmxn instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataMmxn as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataMmxn> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataMmxn> findByAmp(Object amp) {
		return findByProperty(AMP, amp);
	}

	public List<DataMmxn> findByAmpAlm(Object ampAlm) {
		return findByProperty(AMP_ALM, ampAlm);
	}

	public List<DataMmxn> findByRecordWave(Object recordWave) {
		return findByProperty(RECORD_WAVE, recordWave);
	}

	public List findAll() {
		log.debug("finding all DataMmxn instances");
		try {
			String queryString = "from DataMmxn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataMmxn merge(DataMmxn detachedInstance) {
		log.debug("merging DataMmxn instance");
		try {
			DataMmxn result = (DataMmxn) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataMmxn instance) {
		log.debug("attaching dirty DataMmxn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataMmxn instance) {
		log.debug("attaching clean DataMmxn instance");
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
	public DataMmxn getLatestInstance(int inst){
		try {
			String queryString = "from DataMmxn as inst where inst.lnInst=? order by inst.dataTime desc";
			Query qb = getSession().createQuery(queryString);
			qb.setFirstResult(0);
			qb.setMaxResults(1);
			List<DataMmxn> list = qb.list();
			if (list.size() < 1) throw new RuntimeException("No DataMmxn found!");
			return list.get(list.size() - 1);
		} catch (RuntimeException er) {
			log.error("No instance of DataMmxn found", er);
			throw er;
		}
	}
}