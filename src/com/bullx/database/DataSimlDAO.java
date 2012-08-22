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
 * DataSiml entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bullx.database.DataSiml
 * @author MyEclipse Persistence Tools
 */

public class DataSimlDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DataSimlDAO.class);
	// property constants
	public static final String LN_INST = "lnInst";
	public static final String H2PPM = "h2ppm";
	public static final String N2PPM = "n2ppm";
	public static final String COPPM = "coppm";
	public static final String CO2PPM = "co2ppm";
	public static final String CH4PPM = "ch4ppm";
	public static final String C2H2PPM = "c2h2ppm";
	public static final String C2H4PPM = "c2h4ppm";
	public static final String C2H6PPM = "c2h6ppm";
	public static final String O2PPM = "o2ppm";
	public static final String MST = "mst";
	public static final String HYDROCARBON = "hydrocarbon";
	public static final String CMBU_GAS = "cmbuGas";
	public static final String H2ALM = "h2alm";
	public static final String C2H2ALM = "c2h2alm";

	public void save(DataSiml transientInstance) {
		log.debug("saving DataSiml instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataSiml persistentInstance) {
		log.debug("deleting DataSiml instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataSiml findById(java.lang.Long id) {
		log.debug("getting DataSiml instance with id: " + id);
		try {
			DataSiml instance = (DataSiml) getSession().get(
					"com.bullx.database.DataSiml", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataSiml> findByExample(DataSiml instance) {
		log.debug("finding DataSiml instance by example");
		try {
			List<DataSiml> results = (List<DataSiml>) getSession()
					.createCriteria("com.bullx.database.DataSiml")
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
		log.debug("finding DataSiml instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataSiml as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DataSiml> findByLnInst(Object lnInst) {
		return findByProperty(LN_INST, lnInst);
	}

	public List<DataSiml> findByH2ppm(Object h2ppm) {
		return findByProperty(H2PPM, h2ppm);
	}

	public List<DataSiml> findByN2ppm(Object n2ppm) {
		return findByProperty(N2PPM, n2ppm);
	}

	public List<DataSiml> findByCoppm(Object coppm) {
		return findByProperty(COPPM, coppm);
	}

	public List<DataSiml> findByCo2ppm(Object co2ppm) {
		return findByProperty(CO2PPM, co2ppm);
	}

	public List<DataSiml> findByCh4ppm(Object ch4ppm) {
		return findByProperty(CH4PPM, ch4ppm);
	}

	public List<DataSiml> findByC2h2ppm(Object c2h2ppm) {
		return findByProperty(C2H2PPM, c2h2ppm);
	}

	public List<DataSiml> findByC2h4ppm(Object c2h4ppm) {
		return findByProperty(C2H4PPM, c2h4ppm);
	}

	public List<DataSiml> findByC2h6ppm(Object c2h6ppm) {
		return findByProperty(C2H6PPM, c2h6ppm);
	}

	public List<DataSiml> findByO2ppm(Object o2ppm) {
		return findByProperty(O2PPM, o2ppm);
	}

	public List<DataSiml> findByMst(Object mst) {
		return findByProperty(MST, mst);
	}

	public List<DataSiml> findByHydrocarbon(Object hydrocarbon) {
		return findByProperty(HYDROCARBON, hydrocarbon);
	}

	public List<DataSiml> findByCmbuGas(Object cmbuGas) {
		return findByProperty(CMBU_GAS, cmbuGas);
	}

	public List<DataSiml> findByH2alm(Object h2alm) {
		return findByProperty(H2ALM, h2alm);
	}

	public List<DataSiml> findByC2h2alm(Object c2h2alm) {
		return findByProperty(C2H2ALM, c2h2alm);
	}

	public List findAll() {
		log.debug("finding all DataSiml instances");
		try {
			String queryString = "from DataSiml";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataSiml merge(DataSiml detachedInstance) {
		log.debug("merging DataSiml instance");
		try {
			DataSiml result = (DataSiml) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataSiml instance) {
		log.debug("attaching dirty DataSiml instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataSiml instance) {
		log.debug("attaching clean DataSiml instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}