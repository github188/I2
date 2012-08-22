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
 * DataSimg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataSimg
 * @author MyEclipse Persistence Tools
 */

public class DataSimgDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataSimgDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String PRES = "pres";
	public static final String DEN = "den";
	public static final String MST = "mst";
	public static final String TMP = "tmp";
	public static final String DEW_TMP = "dewTmp";
	public static final String DEN_ALM = "denAlm";
	public static final String MST_ALM = "mstAlm";
	public static final String SPLS = "spls";

	public void save(DataSimg transientInstance) {
		log.debug("saving DataSimg instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataSimg persistentInstance) {
		log.debug("deleting DataSimg instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataSimg findById(java.lang.Long id) {
		log.debug("getting DataSimg instance with id: " + id);
		try {
			DataSimg instance = (DataSimg) getSession().get(
					"com.bullx.database.DataSimg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataSimg> findByExample(DataSimg instance) {
		log.debug("finding DataSimg instance by example");
		try {
			List<DataSimg> results = (List<DataSimg>) getSession()
					.createCriteria("com.bullx.database.DataSimg")
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
		log.debug("finding DataSimg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataSimg as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataSimg> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataSimg> findByPres(Object pres) {
		return findByProperty(PRES, pres);
	}

	public List<DataSimg> findByDen(Object den) {
		return findByProperty(DEN, den);
	}

	public List<DataSimg> findByMst(Object mst) {
		return findByProperty(MST, mst);
	}

	public List<DataSimg> findByTmp(Object tmp) {
		return findByProperty(TMP, tmp);
	}

	public List<DataSimg> findByDewTmp(Object dewTmp) {
		return findByProperty(DEW_TMP, dewTmp);
	}

	public List<DataSimg> findByDenAlm(Object denAlm) {
		return findByProperty(DEN_ALM, denAlm);
	}

	public List<DataSimg> findByMstAlm(Object mstAlm) {
		return findByProperty(MST_ALM, mstAlm);
	}

	public List<DataSimg> findBySpls(Object spls) {
		return findByProperty(SPLS, spls);
	}

	public List findAll() {
		log.debug("finding all DataSimg instances");
		try {
			String queryString = "from DataSimg";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataSimg merge(DataSimg detachedInstance) {
		log.debug("merging DataSimg instance");
		try {
			DataSimg result = (DataSimg) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataSimg instance) {
		log.debug("attaching dirty DataSimg instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataSimg instance) {
		log.debug("attaching clean DataSimg instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}