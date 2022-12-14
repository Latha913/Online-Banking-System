package in.co.online.bank.mgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.online.bank.mgt.dto.BankDTO;

/**
 * Hibernate implementation of Bank DAO.
 *
 */

@Repository
public class BankDAOHibImpl implements BankDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(BankDTO dto) {

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(BankDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(BankDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public BankDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(BankDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (BankDTO) criteria.uniqueResult();
	}

	public BankDTO findByPK(long id) {
		Session session = sessionFactory.getCurrentSession();
		BankDTO dto = (BankDTO) session.get(BankDTO.class, id);
		return dto;
	}

	public List<BankDTO> search(BankDTO dto) {
		return search(dto, 0, 0);
	}

	public Map<Long, BankDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, BankDTO> map = new HashMap<Long, BankDTO>();

		for (Long id : ids) {
			map.put(id, (BankDTO) session.get(BankDTO.class, id));
		}
		return map;

	}
	@Override
	public List<BankDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BankDTO> list(int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BankDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		return criteria.list();
	}

	@Override
	public List<BankDTO> search(BankDTO dto, int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BankDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getShortCode() != null && dto.getShortCode().length() > 0) {
				criteria.add(Restrictions.like("shortCode", dto.getShortCode() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		return criteria.list();
	}

	

}
