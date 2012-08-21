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
 * FileManagement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bullx.database.FileManagement
 * @author MyEclipse Persistence Tools
 */

public class FileManagementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FileManagementDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String VERSION = "version";

	public void save(FileManagement transientInstance) {
		log.debug("saving FileManagement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FileManagement persistentInstance) {
		log.debug("deleting FileManagement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FileManagement findById(java.lang.Integer id) {
		log.debug("getting FileManagement instance with id: " + id);
		try {
			FileManagement instance = (FileManagement) getSession().get(
					"com.bullx.database.FileManagement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FileManagement> findByExample(FileManagement instance) {
		log.debug("finding FileManagement instance by example");
		try {
			List<FileManagement> results = (List<FileManagement>) getSession()
					.createCriteria("com.bullx.database.FileManagement")
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
		log.debug("finding FileManagement instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FileManagement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FileManagement> findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List<FileManagement> findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		log.debug("finding all FileManagement instances");
		try {
			String queryString = "from FileManagement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FileManagement merge(FileManagement detachedInstance) {
		log.debug("merging FileManagement instance");
		try {
			FileManagement result = (FileManagement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FileManagement instance) {
		log.debug("attaching dirty FileManagement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FileManagement instance) {
		log.debug("attaching clean FileManagement instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}