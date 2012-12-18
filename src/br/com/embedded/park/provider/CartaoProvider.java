package br.com.embedded.park.provider;

import java.util.List;

import javax.inject.Inject;

import br.com.embedded.park.dao.CartaoDao;
import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.service.CartaoService;

public class CartaoProvider implements CartaoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private CartaoDao cartaoDao;
	
	@Override
	public List<Cartao> findAllCartoesLiberados() {
		return cartaoDao.findAllCartoesLiberados();
	}

	@Override
	public Cartao findById(Long id) {
		return cartaoDao.findById(id);
	}

	@Override
	public List<Cartao> findAll() {
		return cartaoDao.findAll();
	}

	@Override
	public Cartao findByCodigo(String codigo) {
		return cartaoDao.findByCodigo(codigo);
	}

	@Override
	public boolean existeCartao(String codigo) {
		return cartaoDao.existeCartao(codigo);
	}
}
