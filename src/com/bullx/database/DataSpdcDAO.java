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
 * DataSpdc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataSpdc
 * @author MyEclipse Persistence Tools
 */

public class DataSpdcDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataSpdcDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String PDVALUE = "pdvalue";
	public static final String PDCOUNT = "pdcount";
	public static final String PDPOSITION = "pdposition";
	public static final String ACU_PA_DSCH = "acuPaDsch";
	public static final String APP_PA_DSCH = "appPaDsch";
	public static final String UHF_PA_DSCH = "uhfPaDsch";
	public static final String PA_DSCH_WAVE = "paDschWave";
	public static final String PA_DSCH_ALM = "paDschAlm";

	public void save(DataSpdc transientInstance) {
		log.debug("saving DataSpdc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataSpdc persistentInstance) {
		log.debug("deleting DataSpdc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataSpdc findById(java.lang.Long id) {
		log.debug("getting DataSpdc instance with id: " + id);
		try {
			DataSpdc instance = (DataSpdc) getSession().get(
					"com.bullx.database.DataSpdc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataSpdc> findByExample(DataSpdc instance) {
		log.debug("finding DataSpdc instance by example");
		try {
			List<DataSpdc> results = (List<DataSpdc>) getSession()
					.createCriteria("com.bullx.database.DataSpdc")
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
		log.debug("finding DataSpdc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataSpdc as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataSpdc> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataSpdc> findByPdvalue(Object pdvalue) {
		return findByProperty(PDVALUE, pdvalue);
	}

	public List<DataSpdc> findByPdcount(Object pdcount) {
		return findByProperty(PDCOUNT, pdcount);
	}

	public List<DataSpdc> findByPdposition(Object pdposition) {
		return findByProperty(PDPOSITION, pdposition);
	}

	public List<DataSpdc> findByAcuPaDsch(Object acuPaDsch) {
		return findByProperty(ACU_PA_DSCH, acuPaDsch);
	}

	public List<DataSpdc> findByAppPaDsch(Object appPaDsch) {
		return findByProperty(APP_PA_DSCH, appPaDsch);
	}

	public List<DataSpdc> findByUhfPaDsch(Object uhfPaDsch) {
		return findByProperty(UHF_PA_DSCH, uhfPaDsch);
	}

	public List<DataSpdc> findByPaDschWave(Object paDschWave) {
		return findByProperty(PA_DSCH_WAVE, paDschWave);
	}

	public List<DataSpdc> findByPaDschAlm(Object paDschAlm) {
		return findByProperty(PA_DSCH_ALM, paDschAlm);
	}

	public List findAll() {
		log.debug("finding all DataSpdc instances");
		try {
			String queryString = "from DataSpdc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataSpdc merge(DataSpdc detachedInstance) {
		log.debug("merging DataSpdc instance");
		try {
			DataSpdc result = (DataSpdc) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataSpdc instance) {
		log.debug("attaching dirty DataSpdc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataSpdc instance) {
		log.debug("attaching clean DataSpdc instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}