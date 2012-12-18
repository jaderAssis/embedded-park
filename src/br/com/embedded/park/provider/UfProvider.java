package br.com.embedded.park.provider;

import java.util.List;

import javax.inject.Inject;

import br.com.embedded.park.dao.UfDao;
import br.com.embedded.park.entity.Uf;
import br.com.embedded.park.service.UfService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class UfProvider implements UfService {

	private static final long serialVersionUID = 1L;

	@Inject
	private UfDao ufDao;
	
	@Override
	public List<Uf> findAll() {
		return ufDao.findAll();
	}

	@Override
	public Uf findById(Long id) {
		return ufDao.findById(id);
	}
	
}
