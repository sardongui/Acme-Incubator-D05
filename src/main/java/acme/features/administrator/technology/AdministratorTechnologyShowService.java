
package acme.features.administrator.technology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.technologies.Technology;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorTechnologyShowService implements AbstractShowService<Administrator, Technology> {

	@Autowired
	private AdministratorTechnologyRepository repository;


	@Override
	public boolean authorise(final Request<Technology> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Technology> request, final Technology entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorName", "description", "webSite", "email", "indication", "stars");
	}

	@Override
	public Technology findOne(final Request<Technology> request) {
		assert request != null;
		Technology result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneTechnologyById(id);
		return result;
	}

}
