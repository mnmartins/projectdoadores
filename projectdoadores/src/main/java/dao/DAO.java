package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import model.Hemocentro;

public class DAO<E> {

	EntityManager entityManager;

	public boolean adicionarEntidade(E entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entidade);

			transaction.commit();

			return true;

		} finally {
			entityManager.close();
		}
	}

	public boolean apagarEntidade(Class<E> entidade, int id) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();

			entidade = entityManager.find(entidade.getClass(), id);
			entityManager.remove(entidade);

		} finally {
			entityManager.close();
		}

		return true;
	}

	public E atualizarEntidade(Class<E> entidade, int id) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();

			E entity = entityManager.find(entidade, id);
			entityManager.merge(entidade);

			transaction.commit();

			return entity;
		} finally {
			entityManager.close();
		}
	}

	public List<E> pesquisarEntidadeByUf(int uf, Class<E> entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			List<E> lista = entityManager.createQuery("from "+ entidade.getSimpleName() +" where estado.id = " + uf).getResultList();

			transaction.commit();

			return lista;
		} finally {
			entityManager.close();
		}
	}

	public E pesquisarEntidadeById(long id, Class<E> entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();

			E entity = entityManager.find(entidade, id);

			transaction.commit();

			return entity;
		} finally {
			entityManager.close();
		}
	}
	
	public List<E> pesquisarHemocentroByUf(long uf, Class<E> entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			List<E> lista = entityManager.createQuery("from "+ entidade.getSimpleName() +" where uf = " + uf).getResultList();

			transaction.commit();

			return lista;
		} finally {
			entityManager.close();
		}
	}
	
	public List<E> pesquisarHemocentroByUfCidade(Long uf, Long cidade, Class<E> entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			List<E> lista = entityManager.createQuery("from "+ entidade.getSimpleName() +" where uf = " + uf + " and cidade = " + cidade).getResultList();

			transaction.commit();

			return lista;
		} finally {
			entityManager.close();
		}
	}

	public List<E> listarTodasEntidades(Class<E> entidade) {
		try {
			entityManager = new Conexao().getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();

			List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
			transaction.commit();

			return lista;
		} finally {
			entityManager.close();
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
