package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	public static EntityManagerFactory factory = null;

	static {
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("projetodoadores");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}