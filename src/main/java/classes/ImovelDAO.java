package classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ImovelDAO {

	protected EntityManager entityManager;

	public ImovelDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudSistema");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Imovel buscarPorID(int id) {
		Imovel imovel = null;

		try {
			imovel = entityManager.find(Imovel.class, id);

		} catch (Exception e) {
			entityManager.close();
			System.out.println("Erro ao buscar elemento com id = " + id);
			e.printStackTrace();
		}

		return imovel;
	}

	@SuppressWarnings("unchecked")
	public List<Imovel> buscarTodos() {
		return entityManager.createQuery("FROM " + Imovel.class.getName()).getResultList();
	}

	public void inserir(Imovel imovel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(imovel);
			entityManager.getTransaction().commit();

			System.out.println("Registro inserido com sucesso!");

		} catch (Exception ex) {
			System.out.println("Erro ao inserir registro na tabela!");
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			entityManager.close();
		}
	}

	public void alterar(Imovel imovel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(imovel);
			entityManager.getTransaction().commit();

			System.out.println("Registro alterado com sucesso!");

		} catch (Exception ex) {
			System.out.println("Erro ao alterar registro na tabela!");
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			entityManager.close();
		}
	}

	public void remover(Imovel imovel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(imovel);
			entityManager.getTransaction().commit();

			System.out.println("Registro removido com sucesso!");

		} catch (Exception ex) {
			System.out.println("Erro ao remover registro na tabela!");
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			entityManager.close();
		}
	}

	public void removerById(final int id) {
		try {
			Imovel imovel = buscarPorID(id);

			if (imovel != null) {
				remover(imovel);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}